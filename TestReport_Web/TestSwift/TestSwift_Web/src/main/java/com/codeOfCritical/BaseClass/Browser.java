package com.codeOfCritical.BaseClass;

import com.codeOfCritical.commonUtils.getProperty;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static com.codeOfCritical.Interfaces.ElementOperations.*;

public class Browser extends BrowserConfig {
    private static final Logger log = LogManager.getLogger(Browser.class.getName());

    /**
     * This Interface will be used to call any Transaction page Objects
     * This Interface will be used in Step Definition class only
     *
     * @author partha.das
     */
    //    public static ThreadLocal<TransactionOperations<?>> transaction = new InheritableThreadLocal<>();
    /**
     * This List will collect the browser window handle
     * This List will be used in such scenarios where two browser session are
     * created parallel
     *
     * @author partha.das
     */
    public static Set<String> instance_handler = null;
    /**
     * Store the current page names
     */
    public static ThreadLocal<List<String>> pageNames = ThreadLocal.withInitial(ArrayList::new);
    protected static String screenshotFolderName;

    static {
        try {
            /*
              Creating a folder with respect of current date and time to store all cucumber
              steps screenshots if the creation status is false then stop execution with an
              execution
             */
            Calendar cal = Calendar.getInstance();
            Date date = cal.getTime();
            DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");// ("HH-mm-ss");
            String formattedDate = dateFormat.format(date);
            // Creating a folder with current date
            File sDirectory = new File(getProperty.readScreenshotLocation("stepImageLocation") + formattedDate);
            // Checking the the condition of creation of the folder
            boolean b = sDirectory.mkdir();
            if (b != false) {
                log.info("Folder creation to captureScreenShot is :" + b);
                screenshotFolderName = sDirectory.getName();
            } else {
                throw new Exception("Unable to create folder to take screenshot");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private WebDriverWait w1 = null;
    private int exceptionCount = 0;

    /**
     * This method will be used to invoke browser session - > Navigate to URL - >
     * screenshot folder creation
     *
     * @param browser
     * @throws Exception
     * @Note This method should not be used in HealthCheck related scenarios
     */
    public void openBrowserandNavigate(String browser) throws Exception {
        try {
            // Launching Browser and Navigating to Landing page
            log.info("Browsers are configurable, for checking purposes Selection is skipped. //browserConfig.getBrowserName()");

            // Calling Browser configuration method
            startBrowser(browser);
            // Clearing cookies
            driverThread.get().manage().deleteAllCookies();

            /**
             * Verifying condition to open desired environment from basicDetails.properties
             * file if exact environment not found in the properties file Then it will throw
             * Runtime Exception and execution will stop here
             */
                /*if (getProperty.readmyFile("env_name").equalsIgnoreCase("rc")) {
                    driverThread.get().get(getProperty.readmyFile("url_rc"));
                }

                else {
                    log.error("URL is not defined in properties file");
                    throw new Error("URL is not defined in properties file " + getProperty.readmyFile("env_name"));
                }*/

            log.info("URL is Presented " + driverThread.get().getCurrentUrl());

            // Web Browser timeout limit set to 20 seconds
            driverThread.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

            // Maximizing the browser
            driverThread.get().manage().window().maximize();
            log.info("Browser is MAXIMIZED");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void teardown() {
        WebDriver driver = driverThread.get();
        // Navigate to Menu and Log-Out
        // Delete All Cookies
        driverThread.get().manage().deleteAllCookies();
        // clear the storage to be added
        quitDriver();
    }

    /**
     * This method is liable to handle drop-down through Select Class This method
     * will be shared among all classes
     *
     * @param element
     * @param text
     * @param <T>
     * @param <T1>
     */
    public synchronized <T, T1> void DropdownSelect(T element, T1 text) {
        WebDriver driver = driverThread.get();
        try {
            if (((WebElement) element).getTagName() != null) {
               w1 = new WebDriverWait(driver, Duration.ofSeconds(20));
                w1.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy((WebElement) element, By.tagName("option")));
                Select select = DROP_DOWN.apply((WebElement) element);
                List<WebElement> allDropDownOptions = select.getOptions();
                try {
                    select.deselectAll();
                } catch (Exception e) {
                    log.error(e.getMessage());
                }
                List<WebElement> expectedDropdown = allDropDownOptions.stream().filter(e -> e.getText().trim().toLowerCase().replaceAll("\\s", "").startsWith(((String) text).toLowerCase().trim().replaceAll("\\s", ""))).collect(Collectors.toList());

                if (expectedDropdown.size() != 0) {
                    String toSelelct = expectedDropdown.get(0).getText();
                    SELECT_THE_TEXT.accept(select, toSelelct);
                    log.info("Selected Dropdown text is: " + toSelelct);
                } else {
                    throw new Error("DropDown name is Not found in list: " + text);
                }
            } else {
                throw new Exception(String.format("Unable to Select DropDown %s value from List because element is not displayed", text));
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    /**
     * This method is liable to handle drop-down through Select Class This method
     * will be shared among all classes for Primary and Secondary group selection
     *
     * @return null
     * @throws Exception
     */
    public synchronized <T, T1> void DropdownSelect_ReportGroup(T element, T1 text) {
        WebDriver driver = driverThread.get();
        try {
            if (((WebElement) element).getTagName() != null) {
                w1 = new WebDriverWait(driver, Duration.ofSeconds(20));
                w1.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy((WebElement) element, By.tagName("option")));
                Select select = DROP_DOWN.apply((WebElement) element);
                List<WebElement> allDropDownOptions = select.getOptions();
                try {
                    select.deselectAll();
                } catch (Exception e) {
                    log.error(e.getMessage());
                }
                for (WebElement e : allDropDownOptions) {
                    String drop = e.getText().trim();
                    if (drop.equalsIgnoreCase((String) text)) {
                        SELECT_THE_TEXT.accept(select, e.getText());
                        log.info("Selected Dropdown text is: " + drop);
                        break;
                    }
                }

            } else {
                throw new Exception(String.format("Unable to Select DropDown %s value from List because element is not displayed", text));
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    /**
     * This method will click on arrow to expand drop-down list( Report Period )
     * will be shared among all classes
     *
     * @return
     */
    public synchronized <T, T1> void ExactDropdownSelect(T element, T1 text) {
        WebDriver driver = driverThread.get();
        try {
            // Arrow
           w1 = new WebDriverWait(driver, Duration.ofSeconds(20));
            w1.until(ExpectedConditions.visibilityOf(FIND_ELEMENT.apply((WebElement) element, "./following-sibling::p/label/i")));
            WebElement arrow = FIND_ELEMENT.apply((WebElement) element, "./following-sibling::p/label/i");

            // Expected drop-down text to be selected
            String expectedDropdownText = (String) text;

            if (arrow.getTagName() != null && !(arrow.getTagName().isEmpty()) && arrow.isDisplayed()) {

                // click on the arrow
                arrow.click();
                log.info("Clicked on arrow");

                // Storing the drop-down values after expanding
                List<WebElement> alldropDownOptions = w1.until(ExpectedConditions.visibilityOfAllElements(((WebElement) element).findElements(By.xpath("./following-sibling::div/ul/li"))));

                alldropDownOptions.stream().filter(x -> x.getText().trim().equalsIgnoreCase(expectedDropdownText)).forEach(x -> {
                    x.click();
                    log.info("Expected Dropdown selected");
                });

                // Verifying if selected drop-down text is same with expected or not
                String selectedDropdownText = ((WebElement) element).findElement(By.xpath("./following-sibling::p/span/div")).getText().trim();
                log.info("Selected Dropdown text is :" + selectedDropdownText);
                if (!(selectedDropdownText.equalsIgnoreCase((String) text))) {
                    exceptionCount++;
                    if (exceptionCount < 10) {
                        log.warn("Drop-down selection problem ");
                        SEND_KEYS.accept(((WebElement) element), Keys.ESCAPE);
                        ExactDropdownSelect(element, text);
                    } else {
                        throw new Error("Drop-down selection problem " + text);
                    }
                }
            } else {
                throw new Error(String.format("Unable to Select DropDown %s value from List because element is not displayed", text));
            }
        } catch (Exception e) {
            if (e instanceof ElementNotInteractableException) {
                log.warn("ElementNotInteractableException found");
                SEND_KEYS.accept(((WebElement) element), Keys.ESCAPE);
                ExactDropdownSelect(element, text);
            } else if (e instanceof NoSuchElementException) {
                log.warn("NoSuchElementException found");
                SEND_KEYS.accept(((WebElement) element), Keys.ESCAPE);
                ExactDropdownSelect(element, text);
            } else if (e instanceof StaleElementReferenceException) {
                log.warn("StaleElementReferenceException found");
                SEND_KEYS.accept(((WebElement) element), Keys.ESCAPE);
                ExactDropdownSelect(element, text);
            } else {
                e.printStackTrace();
            }
        } finally {
            exceptionCount = 0;
        }

    }

    /**
     * This method will handle multiple drop-down by clicking on arrow and then send
     * drop-down values and then click on check box and send escape key
     *
     * @return null
     */
    public synchronized <T, T1> void MultipleDropdownSelect(T element, T1[] text) {
        WebDriver driver = driverThread.get();
        if (((WebElement) element).getTagName() != null) {
            try {
                // click on the arrow
                Thread.sleep(15000);
               w1 = new WebDriverWait(driver, Duration.ofSeconds(20));
                CLICK_ON.accept(w1.until(ExpectedConditions.elementToBeClickable(FIND_ELEMENT.apply((WebElement) element, "./following-sibling::p/label/i"))));
                log.info("Clicked on arrow");
                // Checking if we need to select all dropdown options or not
                if (text[0].toString().equalsIgnoreCase("Select All")) {
                    CLICK_ON.accept(FIND_ELEMENT.apply((WebElement) element, "./following-sibling::div/p/span"));
                    log.info("All dropdown selected");
                } else {
                    //                  if (FETCH_VALUE_OF.apply(((WebElement) element).findElement(By.xpath("./following-sibling::div/p")), "class").contains("selected") ||
                    //                          FETCH_VALUE_OF.apply(((WebElement) element).findElement(By.xpath("./following-sibling::p")), "title").matches("(.*)")) {
                    //                      CLICK_ON.accept(FIND_ELEMENT.apply((WebElement) element, "./following-sibling::div/p/span"));
                    //                      log.info("All dropdown deselected");

                    //Added by Satya
                    // Commented out the old code
                    // If loop will check if the element sibling div/p contains class name as selected. Class value will be selected if all the dropdown values are selected
                    // When complete dropdown is selected, click on Select All check box once to deselect all
                    if (FETCH_VALUE_OF.apply(((WebElement) element).findElement(By.xpath("./following-sibling::div/p")), "class").contains("selected")) {
                        CLICK_ON.accept(FIND_ELEMENT.apply((WebElement) element, "./following-sibling::div/p/span"));
                        log.info("All dropdown deselected");
                    }
                    // If loop will check if the element sibling p matches title with any string. Title can be 2 Selected/ select/ any other dropdown value
                    // Partial selection loaded by default, click on Select All check box twice to deselect all
                    else if (FETCH_VALUE_OF.apply(((WebElement) element).findElement(By.xpath("./following-sibling::p")), "title").matches("(.*)")) {
                        CLICK_ON.accept(FIND_ELEMENT.apply((WebElement) element, "./following-sibling::div/p/span"));
                        CLICK_ON.accept(FIND_ELEMENT.apply((WebElement) element, "./following-sibling::div/p/span"));
                        log.info("All dropdown deselected");
                    }

                    for (T1 str : text) {
                        // send drop-down text
                        CLEAR_OUT.accept(FIND_ELEMENT.apply((WebElement) element, "./following-sibling::p/input"));
                        // send drop-down text
                        SEND_KEYS.accept(FIND_ELEMENT.apply((WebElement) element, "./following-sibling::p/input"), ((String) str).trim());
                        log.info("Drop-down text search is entered");
                        // Select the expected drop-down
                       w1 = new WebDriverWait(driver, Duration.ofSeconds(10));
                        CLICK_ON.accept(w1.until(ExpectedConditions.elementToBeClickable(FIND_ELEMENT.apply((WebElement) element, "./following-sibling::div/ul/li[@class='opt']/span/i"))));
                        log.info("Expected drop-down is selected: " + str);
                    }
                    //                  }
                }
                // Checking if OK button is available or not
                if (FIND_ELEMENT.apply((WebElement) element, "./following-sibling::div/div/p[1]").isDisplayed()) {
                    CLICK_ON.accept(FIND_ELEMENT.apply((WebElement) element, "./following-sibling::div/div/p[1]"));
                    log.info("Clicked on Sub-Group dropdown OK button");
                } else {
                    SEND_KEYS.accept(((WebElement) element), Keys.ESCAPE);
                }
            } catch (Exception e) {
                if (e instanceof ElementNotInteractableException) {
                    exceptionCount++;
                    if (exceptionCount < 10) {
                        log.warn("ElementNotInteractableException found");
                        SEND_KEYS.accept(((WebElement) element), Keys.ESCAPE);
                        MultipleDropdownSelect(element, text);
                    } else {
                        throw new Error("Sub-Group Dropdown selection failed for " + Arrays.toString(text));
                    }
                } else if (e instanceof NoSuchElementException) {
                    exceptionCount++;
                    if (exceptionCount < 10) {
                        log.warn("NoSuchElementException found");
                        SEND_KEYS.accept(((WebElement) element), Keys.ESCAPE);
                        MultipleDropdownSelect(element, text);
                    } else {
                        throw new Error("Sub-Group Dropdown selection failed for " + Arrays.toString(text));
                    }
                } else if (e instanceof StaleElementReferenceException) {
                    exceptionCount++;
                    if (exceptionCount < 10) {
                        log.warn("StaleElementReferenceException found");
                        SEND_KEYS.accept(((WebElement) element), Keys.ESCAPE);
                        MultipleDropdownSelect(element, text);
                    } else {
                        throw new Error("Sub-Group Dropdown selection failed for " + Arrays.toString(text));
                    }
                } else {
                    e.printStackTrace();
                }
            } finally {
                exceptionCount = 0;
            }
        } else {
            throw new Error("Multi-dropdown selection failed");
        }
    }

    /**
     * This method is liable to handle CURRENCY drop-down through Select Class This
     * method
     * will be shared among all classes
     *
     * @param element
     * @param text
     * @param <T>
     * @param <T1>
     */
    public synchronized <T, T1> void DropdownSelect_currency(T element, T1 text) {
        WebDriver driver = driverThread.get();
        try {
            if (((WebElement) element).getTagName() != null) {
               w1 = new WebDriverWait(driver, Duration.ofSeconds(20));
                w1.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy((WebElement) element, By.tagName("option")));
                Select select = DROP_DOWN.apply((WebElement) element);
                List<WebElement> allDropDownOptions = select.getOptions();

                for (WebElement e : allDropDownOptions) {
                    // First trim the text then set to lower case
                    String drop = e.getText().trim().toLowerCase();

                    if (drop.equalsIgnoreCase((((String) text).toLowerCase().trim()))) {
                        SELECT_THE_TEXT.accept(select, e.getText());
                        log.info("Selected Dropdown text is: " + drop);
                        break;
                    }
                }

            } else {
                throw new Exception(String.format("Unable to Select DropDown %s value from List because element is not displayed", text));
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    /**
     * This method will CLICK on element
     */
    @Override
    public synchronized <T> void ClickOnElement(T element) {
        WebDriver driver = driverThread.get();
        try {
           w1 = new WebDriverWait(driver, Duration.ofSeconds(10));
            w1.until(ExpectedConditions.visibilityOf(((WebElement) element)));

            if (((WebElement) element).isDisplayed()) {
               w1 = new WebDriverWait(driver, Duration.ofSeconds(10));
                w1.until(ExpectedConditions.elementToBeClickable(((WebElement) element)));
                CLICK_ON.accept(((WebElement) element));
                // new ScrollAndHighlight(((WebElement) element));
            } else {
                throw new Exception("Unable to Click on Element because element is not displayed");
            }
        } catch (Exception e) {
            log.error(e.getMessage());

            if (e instanceof StaleElementReferenceException) {
                exceptionCount++;
                if (exceptionCount < 10) {
                    log.warn(e.getMessage());
                    ClickOnElement(element);
                }
            } else if (e.getCause() instanceof NoSuchElementException) {
                throw new Error("script broke because of wrong element");
            } else {
                e.printStackTrace();
            }

        } finally {
            exceptionCount = 0;
        }
    }

    /**
     * This method will clear the text box and send keys
     */
    @Override
    public synchronized <T, T1> void SendKeysTo(T element, T1 text) {

        try {
            if (((WebElement) element).isDisplayed()) {
                if (!((String) text).isEmpty() || text != null) {
                    //                    new ScrollAndHighlight(((WebElement) element));
                    CLEAR_OUT.accept(((WebElement) element));
                    SEND_KEYS.accept(((WebElement) element), ((String) text));
                }
            } else {
                throw new Error(String.format("Unable to Enter text %s to text box because element is not displayed", text));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method will handle the dynamic table All rows LIST need to be provided
     * and return sorted List of List WebElement will be returned (non-Javadoc)
     */
    @Override
    public synchronized List<List<WebElement>> handleTable(List<WebElement> allRow) {
        List<List<WebElement>> returnColumns = new ArrayList<List<WebElement>>();
        allRow.stream().parallel()
                .forEach(eachRow -> {
                    List<WebElement> eachColumnForOneRow = eachRow.findElements(By.xpath("./td"));
                    returnColumns.add(eachColumnForOneRow);
                });

        Collections.reverse(returnColumns);
        return returnColumns.stream()
                .sorted(Comparator.comparingInt(List::hashCode)).
                collect(Collectors.toList());
    }

    /*
     * This will check and uncheck the primary-subgroup dropdown options
     * This method will be removed after UI fix
     */
    public synchronized <T> void checkAndUncheckPrimarySubGroup(T element) {
        WebDriver driver = driverThread.get();
        if (((WebElement) element).getTagName() != null) {
            try {
               w1 = new WebDriverWait(driver, Duration.ofSeconds(10));
                w1.until(ExpectedConditions.elementToBeClickable(FIND_ELEMENT.apply((WebElement) element, "./following-sibling::p/label/i")));
                // click on the arrow
                CLICK_ON.accept(FIND_ELEMENT.apply((WebElement) element, "./following-sibling::p/label/i"));
                log.info("Clicked on arrow");
                // De-select all options
                CLICK_ON.accept(FIND_ELEMENT.apply((WebElement) element, "./following-sibling::div/p/span"));
                log.info("All dropdown deselected");
                Thread.sleep(3000);
                // Select all options
                CLICK_ON.accept(FIND_ELEMENT.apply((WebElement) element, "./following-sibling::div/p/span"));
                log.info("All dropdown deselected");
                // Checking if OK button is available or not
                if (FIND_ELEMENT.apply((WebElement) element, "./following-sibling::div/div/p").isDisplayed()) {
                    CLICK_ON.accept(FIND_ELEMENT.apply((WebElement) element, "./following-sibling::div/div/p"));
                    log.info("Clicked on sub-group dropdown OK button");
                } else {
                    SEND_KEYS.accept(((WebElement) element), Keys.ESCAPE);
                }
            } catch (Exception e) {
                if (e instanceof ElementNotInteractableException) {
                    log.warn("ElementNotInteractableException found");
                    checkAndUncheckPrimarySubGroup(element);
                } else if (e instanceof NoSuchElementException) {
                    log.warn("NoSuchElementException found");
                    checkAndUncheckPrimarySubGroup(element);
                } else if (e instanceof StaleElementReferenceException) {
                    log.warn("StaleElementReferenceException found");
                    checkAndUncheckPrimarySubGroup(element);
                } else {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
     * This will check and uncheck the Multiple dropdown element
     * This method will used for Multi-dropdown performance report
     */

    public synchronized <T, T1> void MultipleDropdownSelect_1(T element, T1[] text) {
        WebDriver driver = driverThread.get();
        try {
            if (((WebElement) element).getTagName() != null) {
               w1 = new WebDriverWait(driver, Duration.ofSeconds(20));
                w1.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy((WebElement) element, By.tagName("option")));
                Select select = DROP_DOWN.apply((WebElement) element);
                List<WebElement> allDropDownOptions = select.getOptions();
                try {
                    select.deselectAll();
                } catch (Exception e) {
                    log.error(e.getMessage());
                }
                for (T1 str : text) {
                    for (WebElement e : allDropDownOptions) {
                        // First trim the text then set to lower case
                        String drop = e.getText().trim().toLowerCase();

                        if (drop.equals(((String) str).toLowerCase().trim())) {
                            SELECT_THE_TEXT.accept(select, e.getText());
                            log.info("Selected Dropdown text is: " + drop);
                            break;
                        }
                    }
                }
            } else {
                throw new Exception(String.format("Unable to Select DropDown %s value from List because element is not displayed", text));
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    /**
     * This method is used to handle check boxes
     *
     * @param text Checked & UnChecked
     * @return true if checked
     */
    public boolean isChecked(String text) {
        return text.equalsIgnoreCase("checked");
    }

    public void switchToWindows(String windowName) {
        WebDriver driver = driverThread.get();
        // Getting all window handles
        Set<String> handles = driver.getWindowHandles();
        int count = 0;
        for (String win : handles) {
            count++;
            if (driver.switchTo().window(win).getTitle().trim().contentEquals(windowName)) {
                String windowTitle = driver.switchTo().window(win).getTitle();
                driver.manage().window().maximize();
                log.info("Switch to window: " + windowTitle);
                break;
            } else {
                count++;
                if (handles.size() - 1 == count) {
                    log.error(windowName + " not found");
                }
            }
        }
        handles.clear();
    }

    public void switchToFrame(WebElement frame) {
        WebDriver driver = driverThread.get();
        driver.switchTo().defaultContent();
        try {
           w1 = new WebDriverWait(driver, Duration.ofSeconds(10));
            w1.until(ExpectedConditions.visibilityOf(frame));

            if (frame.isDisplayed()) {
               w1 = new WebDriverWait(driver, Duration.ofSeconds(10));
                w1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
            } else {
                throw new Exception("Unable to switch to frame");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}// End of Class
