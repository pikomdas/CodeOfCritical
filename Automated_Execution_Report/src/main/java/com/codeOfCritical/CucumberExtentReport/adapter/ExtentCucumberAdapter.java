package com.codeOfCritical.CucumberExtentReport.adapter;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.gherkin.model.Asterisk;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.model.service.LogService;
import com.aventstack.extentreports.model.service.TestService;
import com.codeOfCritical.CucumberExtentReport.service.ExtentService;
import io.cucumber.core.exception.CucumberException;
import io.cucumber.messages.Messages.GherkinDocument.Feature;
import io.cucumber.messages.Messages.GherkinDocument.Feature.Scenario;
import io.cucumber.messages.Messages.GherkinDocument.Feature.Scenario.Examples;
import io.cucumber.messages.Messages.GherkinDocument.Feature.Step;
import io.cucumber.messages.Messages.GherkinDocument.Feature.TableRow;
import io.cucumber.messages.Messages.GherkinDocument.Feature.TableRow.TableCell;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.StrictAware;
import io.cucumber.plugin.event.*;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * A port of Cucumber-JVM (MIT licensed) HtmlFormatter for Extent Framework
 * Original source:
 * https://github.com/cucumber/cucumber-jvm/blob/master/core/src/main/java/cucumber/runtime/formatter/HTMLFormatter.java
 */
public class ExtentCucumberAdapter implements ConcurrentEventListener, StrictAware
{

    private static final String SCREENSHOT_DIR_PROPERTY = "screenshot.dir";
    private static final String SCREENSHOT_REL_PATH_PROPERTY = "screenshot.rel.path";

    private static final Map<String, ExtentTest> featureMap = new ConcurrentHashMap<>();
    private static final ThreadLocal<ExtentTest> featureTestThreadLocal = new InheritableThreadLocal<>();
    private static final Map<String, ExtentTest> scenarioOutlineMap = new ConcurrentHashMap<>();
    private static final ThreadLocal<ExtentTest> scenarioOutlineThreadLocal = new InheritableThreadLocal<>();
    private static final ThreadLocal<ExtentTest> scenarioThreadLocal = new InheritableThreadLocal<>();
    private static final ThreadLocal<Boolean> isHookThreadLocal = new InheritableThreadLocal<>();
    private static final ThreadLocal<ExtentTest> stepTestThreadLocal = new InheritableThreadLocal<>();

    private final String screenshotDir;
    private String screenshotRelPath;
    private boolean strict = false;

    @SuppressWarnings("serial")
    private static final Map<String, String> MIME_TYPES_EXTENSIONS = new HashMap<String, String>()
    {
        {
            put("image/bmp", "bmp");
            put("image/gif", "gif");
            put("image/jpeg", "jpg");
            put("image/png", "png");
            put("image/svg+xml", "svg");
            put("video/ogg", "ogg");
        }
    };

    private static final AtomicInteger EMBEDDED_INT = new AtomicInteger(0);

    private final TestSourcesModel testSources = new TestSourcesModel();

    private final ThreadLocal<URI> currentFeatureFile = new ThreadLocal<>();
    private final ThreadLocal<Scenario> currentScenarioOutline = new InheritableThreadLocal<>();
    private final ThreadLocal<Examples> currentExamples = new InheritableThreadLocal<>();

    private final EventHandler<TestSourceRead> testSourceReadHandler = event -> handleTestSourceRead(event);
    private final EventHandler<TestCaseStarted> caseStartedHandler = event -> handleTestCaseStarted(event);
    private final EventHandler<TestStepStarted> stepStartedHandler = event -> handleTestStepStarted(event);
    private final EventHandler<TestStepFinished> stepFinishedHandler = event -> handleTestStepFinished(event);
    private final EventHandler<EmbedEvent> embedEventhandler = event -> handleEmbed(event);
    private final EventHandler<WriteEvent> writeEventhandler = event -> handleWrite(event);
    private final EventHandler<TestRunFinished> runFinishedHandler = event -> finishReport();

    public ExtentCucumberAdapter(String arg)
    {
        ExtentService.getInstance();
        Object prop = ExtentService.getProperty(SCREENSHOT_DIR_PROPERTY);
        screenshotDir = prop == null ? "test-output/" : String.valueOf(prop);
        prop = ExtentService.getProperty(SCREENSHOT_REL_PATH_PROPERTY);
        screenshotRelPath = prop == null || String.valueOf(prop).isEmpty() ? screenshotDir : String.valueOf(prop);
        screenshotRelPath = screenshotRelPath == null ? "" : screenshotRelPath;
    }

    @Override
    public void setEventPublisher(EventPublisher publisher)
    {
        publisher.registerHandlerFor(TestSourceRead.class, testSourceReadHandler);
        publisher.registerHandlerFor(TestCaseStarted.class, caseStartedHandler);
        publisher.registerHandlerFor(TestStepStarted.class, stepStartedHandler);
        publisher.registerHandlerFor(TestStepFinished.class, stepFinishedHandler);
        publisher.registerHandlerFor(EmbedEvent.class, embedEventhandler);
        publisher.registerHandlerFor(WriteEvent.class, writeEventhandler);
        publisher.registerHandlerFor(TestRunFinished.class, runFinishedHandler);
    }

    @Override
    public void setStrict(boolean strict)
    {
        this.strict = strict;
    }

    private void handleTestSourceRead(TestSourceRead event)
    {
        testSources.addTestSourceReadEvent(event.getUri(), event);
    }

    private synchronized void handleTestCaseStarted(TestCaseStarted event)
    {
        handleStartOfFeature(event.getTestCase());
        handleScenarioOutline(event.getTestCase());
        createTestCase(event.getTestCase());
    }

    private synchronized void handleTestStepStarted(TestStepStarted event)
    {
        isHookThreadLocal.set(false);

        if (event.getTestStep() instanceof HookTestStep)
        {
            ExtentTest t = scenarioThreadLocal.get().createNode(Asterisk.class, event.getTestStep().getCodeLocation());
            stepTestThreadLocal.set(t);
            isHookThreadLocal.set(true);
        }

        if (event.getTestStep() instanceof PickleStepTestStep)
        {
            PickleStepTestStep testStep = (PickleStepTestStep) event.getTestStep();
            createTestStep(testStep);
        }
    }

    private synchronized void handleTestStepFinished(TestStepFinished event)
    {
        updateResult(event.getResult());
    }

    private synchronized void updateResult(Result result)
    {
        switch (result.getStatus().name().toLowerCase())
        {
            case "failed":
                stepTestThreadLocal.get().fail(result.getError());
                break;
            case "undefined":
                if (strict)
                {
                    stepTestThreadLocal.get().fail("Step undefined");
                    break;
                }
                stepTestThreadLocal.get().skip("Step undefined");
                break;
            case "pending":
            case "skipped":
                if (isHookThreadLocal.get())
                {
                    ExtentService.getInstance().removeTest(stepTestThreadLocal.get());
                    break;
                }
                Boolean currentEndingEventSkipped = (stepTestThreadLocal.get().getModel().getLogContext() != null
                        && !stepTestThreadLocal.get().getModel().getLogContext().isEmpty()) && stepTestThreadLocal.get().getModel().getLogContext().getLast().getStatus() == Status.SKIP;
                if (result.getError() != null)
                {
                    stepTestThreadLocal.get().skip(result.getError());
                }
                else if (!currentEndingEventSkipped)
                {
                    String details = result.getError() == null ? "Step skipped" : result.getError().getMessage();
                    stepTestThreadLocal.get().skip(details);
                }
                break;
            case "passed":
                if (stepTestThreadLocal.get() != null && stepTestThreadLocal.get().getModel().getLogContext().isEmpty()
                        && !isHookThreadLocal.get())
                {
                    stepTestThreadLocal.get().pass("");
                }

                if (stepTestThreadLocal.get() != null)
                {
                    Boolean hasLog = TestService.testHasLog(stepTestThreadLocal.get().getModel());
                    Boolean hasScreenCapture = hasLog && LogService
                            .logHasScreenCapture(stepTestThreadLocal.get().getModel().getLogContext().getFirst());
                    if (isHookThreadLocal.get() && !hasLog && !hasScreenCapture)
                    {
                        ExtentService.getInstance().removeTest(stepTestThreadLocal.get());
                    }
                }
                break;
            default:
                break;
        }
    }

    private synchronized void handleEmbed(EmbedEvent event)
    {
        String mimeType = event.getMediaType();
        String extension = MIME_TYPES_EXTENSIONS.get(mimeType);
        if (extension != null)
        {
            StringBuilder fileName = new StringBuilder("embedded").append(EMBEDDED_INT.incrementAndGet()).append(".")
                    .append(extension);
            try
            {
                URL url = toUrl(fileName.toString());
                writeBytesToURL(event.getData(), url);
                try
                {
                    File f = new File(url.toURI());
                    if (stepTestThreadLocal.get() == null)
                    {
                        ExtentTest t = scenarioThreadLocal.get().createNode(Asterisk.class, "Embed");
                        stepTestThreadLocal.set(t);
                    }
                    stepTestThreadLocal.get().info("",
                            MediaEntityBuilder.createScreenCaptureFromPath(screenshotRelPath + f.getName()).build());
                    //Screen shot for html report.
                    stepTestThreadLocal.get().addScreenCaptureFromPath(screenshotRelPath + f.getName());
                }
                catch (URISyntaxException e)
                {
                    e.printStackTrace();
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    private static void writeBytesToURL(byte[] buf, URL url) throws IOException
    {
        OutputStream out = createReportFileOutputStream(url);
        try
        {
            out.write(buf);
        }
        catch (IOException e)
        {
            throw new IOException("Unable to write to report file item: ", e);
        }
    }

    private static OutputStream createReportFileOutputStream(URL url)
    {
        try
        {
            return new URLOutputStream(url);
        }
        catch (IOException e)
        {
            throw new CucumberException(e);
        }
    }

    private URL toUrl(String fileName)
    {
        try
        {
            URL url = Paths.get(screenshotDir, fileName).toUri().toURL();
            return url;
        }
        catch (IOException e)
        {
            throw new CucumberException(e);
        }
    }

    private void handleWrite(WriteEvent event)
    {
        String text = event.getText();
        if (text != null && !text.isEmpty())
        {
            stepTestThreadLocal.get().info(text);
        }
    }

    private void finishReport()
    {
        ExtentService.getInstance().flush();
    }

    private synchronized void handleStartOfFeature(TestCase testCase)
    {
        if (currentFeatureFile == null || !currentFeatureFile.equals(testCase.getUri()))
        {
            currentFeatureFile.set(testCase.getUri());
            createFeature(testCase);
        }
    }

    private synchronized void createFeature(TestCase testCase)
    {
        Feature feature = testSources.getFeature(testCase.getUri());
        if (feature != null)
        {
            if (featureMap.containsKey(feature.getName()))
            {
                featureTestThreadLocal.set(featureMap.get(feature.getName()));
                return;
            }
            if (featureTestThreadLocal.get() != null
                    && featureTestThreadLocal.get().getModel().getName().equals(feature.getName()))
            {
                return;
            }
            ExtentTest t = ExtentService.getInstance().createTest(
                    com.aventstack.extentreports.gherkin.model.Feature.class, feature.getName(),
                    feature.getDescription());
            featureTestThreadLocal.set(t);
            featureMap.put(feature.getName(), t);
            List<String> tagList = feature.getTagsList().stream().map(tag -> tag.getName()).collect(Collectors.toList());
            tagList.forEach(featureTestThreadLocal.get()::assignCategory);
        }
    }

    private synchronized void handleScenarioOutline(TestCase testCase)
    {
        TestSourcesModel.AstNode astNode = testSources.getAstNode(currentFeatureFile.get(), testCase.getLine());
        Scenario scenarioDefinition = TestSourcesModel.getScenarioDefinition(astNode);

        if (scenarioDefinition.getKeyword().equals("Scenario Outline"))
        {
            //ScenarioOutline scenarioOutline = (ScenarioOutline) TestSourcesModel.getScenarioDefinition(astNode);
            if (currentScenarioOutline.get() == null
                    || !currentScenarioOutline.get().getName().equals(scenarioDefinition.getName()))
            {
                scenarioOutlineThreadLocal.set(null);
                createScenarioOutline(scenarioDefinition);
                currentScenarioOutline.set(scenarioDefinition);
                // addOutlineStepsToReport(scenarioOutline);
            }
            Examples examples = (Examples) astNode.parent.node;
            if (currentExamples.get() == null || !currentExamples.get().equals(examples))
            {
                currentExamples.set(examples);
                createExamples(examples);
            }
        }
        else
        {
            scenarioOutlineThreadLocal.set(null);
            currentScenarioOutline.set(null);
            currentExamples.set(null);
        }
    }

    private synchronized void createScenarioOutline(Scenario scenarioOutline)
    {
        if (scenarioOutlineMap.containsKey(scenarioOutline.getName()))
        {
            scenarioOutlineThreadLocal.set(scenarioOutlineMap.get(scenarioOutline.getName()));
            return;
        }
        if (scenarioOutlineThreadLocal.get() == null)
        {
            ExtentTest t = featureTestThreadLocal.get().createNode(
                    com.aventstack.extentreports.gherkin.model.ScenarioOutline.class, scenarioOutline.getName(),
                    scenarioOutline.getDescription());
            scenarioOutlineThreadLocal.set(t);
            scenarioOutlineMap.put(scenarioOutline.getName(), t);
            /*
             * List<String> tags = createTagsList(scenarioOutline.getTags());
             * tags.forEach(scenarioOutlineThreadLocal.get()::assignCategory);
             */
            List<String> featureTags = scenarioOutlineThreadLocal.get().getModel()
                    .getParent().getCategoryContext().getAll()
                    .stream()
                    .map(x -> x.getName())
                    .collect(Collectors.toList());
            scenarioOutline.getTagsList()
                    .stream()
                    .map(x -> x.getName())
                    .filter(x -> !featureTags.contains(x))
                    .forEach(scenarioOutlineThreadLocal.get()::assignCategory);
        }
    }

    private void createExamples(Examples examples)
    {
        List<TableRow> rows = new ArrayList<>();
        rows.add(examples.getTableHeader());
        rows.addAll(examples.getTableBodyList());
        String[][] data = getTable(rows);
        String markup = MarkupHelper.createTable(data).getMarkup();
        if (examples.getName() != null && !examples.getName().isEmpty())
        {
            markup = examples.getName() + markup;
        }
        markup = scenarioOutlineThreadLocal.get().getModel().getDescription() + markup;
        scenarioOutlineThreadLocal.get().getModel().setDescription(markup);
    }

    private String[][] getTable(List<TableRow> rows)
    {
        String[][] data = null;
        int rowSize = rows.size();
        for (int i = 0; i < rowSize; i++)
        {
            TableRow row = rows.get(i);
            List<TableCell> cells = row.getCellsList();
            int cellSize = cells.size();
            if (data == null)
            {
                data = new String[rowSize][cellSize];
            }
            for (int j = 0; j < cellSize; j++)
            {
                data[i][j] = cells.get(j).getValue();
            }
        }
        return data;
    }

    private synchronized void createTestCase(TestCase testCase)
    {
        TestSourcesModel.AstNode astNode = testSources.getAstNode(currentFeatureFile.get(), testCase.getLine());
        if (astNode != null)
        {
            Scenario scenarioDefinition = TestSourcesModel.getScenarioDefinition(astNode);
            ExtentTest parent = scenarioOutlineThreadLocal.get() != null ? scenarioOutlineThreadLocal.get()
                    : featureTestThreadLocal.get();
            ExtentTest t = parent.createNode(com.aventstack.extentreports.gherkin.model.Scenario.class,
                    scenarioDefinition.getName(), scenarioDefinition.getDescription());
            scenarioThreadLocal.set(t);
        }
        if (!testCase.getTags().isEmpty())
        {
            testCase.getTags().forEach(x -> scenarioThreadLocal.get().assignCategory(x));
        }
    }

    private synchronized void createTestStep(PickleStepTestStep testStep)
    {
        String stepName = testStep.getStep().getText();
        TestSourcesModel.AstNode astNode = testSources.getAstNode(currentFeatureFile.get(),
                testStep.getStep().getLine());
        if (astNode != null)
        {
            Step step = (Step) astNode.node;
            try
            {
                String name = stepName == null || stepName.isEmpty()
                        ? step.getText().replace("<", "&lt;").replace(">", "&gt;")
                        : stepName;
                ExtentTest t = scenarioThreadLocal.get().createNode(new GherkinKeyword(step.getKeyword().trim()),
                        step.getKeyword() + name, testStep.getCodeLocation());
                stepTestThreadLocal.set(t);
            }
            catch (ClassNotFoundException e)
            {
                e.printStackTrace();
            }
        }
        StepArgument argument = testStep.getStep().getArgument();
        if (argument != null)
        {
            if (argument instanceof DocStringArgument)
            {
                // createDocStringMap((DocStringArgument)argument);
                stepTestThreadLocal.get().pass(createDocString((DocStringArgument) argument));
            }
            else if (argument instanceof DataTableArgument)
            {
                stepTestThreadLocal.get()
                        .pass(MarkupHelper.createTable(createDataTableList((DataTableArgument) argument)).getMarkup());
            }
        }
    }

    private String[][] createDataTableList(DataTableArgument dataTable)
    {
        List<List<String>> cells = dataTable.cells();
        int rowSize = cells.size();
        int cellSize = cells.get(0).size();
        String[][] data = new String[rowSize][cellSize];

        for (int i = 0; i < rowSize; i++)
        {
            for (int j = 0; j < cellSize; j++)
            {
                data[i][j] = cells.get(i).get(j);
            }
        }
        return data;
    }

    private String createDocString(DocStringArgument docString)
    {
        return docString.getContent().replaceAll("(\r\n|\n)", "<br />");
    }

    // the below additions are from PR #33
    // https://github.com/extent-framework/extentreports-cucumber4-adapter/pull/33
    public static synchronized void addTestStepLog(String message)
    {
        stepTestThreadLocal.get().info(message);
    }

    public static synchronized void addTestStepScreenCaptureFromPath(String imagePath) throws IOException
    {
        stepTestThreadLocal.get().addScreenCaptureFromPath(imagePath);
    }

    public static synchronized void addTestStepScreenCaptureFromPath(String imagePath, String title)
            throws IOException
    {
        stepTestThreadLocal.get().addScreenCaptureFromPath(imagePath, title);
    }

    public static ExtentTest getCurrentStep()
    {
        return stepTestThreadLocal.get();
    }

}
