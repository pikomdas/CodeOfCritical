package cucumber.runtime;

import cucumber.api.StepDefinitionReporter;
import cucumber.runtime.xstream.LocalizedXStreams;
import gherkin.I18n;
import gherkin.formatter.Argument;
import gherkin.formatter.model.Step;

import java.util.*;

public class RuntimeGlue implements Glue
{
	final Map<String, StepDefinition> stepDefinitionsByPattern = new TreeMap<String, StepDefinition>();
	final List<HookDefinition> beforeHooks = new ArrayList<HookDefinition>();
	final List<HookDefinition> afterHooks = new ArrayList<HookDefinition>();
	final List<HookDefinition> beforeStepHooks = new ArrayList<>();
	final List<HookDefinition> afterStepHooks = new ArrayList<>();

	private final UndefinedStepsTracker tracker;
	private final LocalizedXStreams localizedXStreams;

	public RuntimeGlue(UndefinedStepsTracker tracker, LocalizedXStreams localizedXStreams)
	{
		this.tracker = tracker;
		this.localizedXStreams = localizedXStreams;
	}

	@Override
	public void addStepDefinition(StepDefinition stepDefinition) {
		StepDefinition previous = stepDefinitionsByPattern.get(stepDefinition.getPattern());
		if (previous != null)
		{
			throw new DuplicateStepDefinitionException(previous, stepDefinition);
		}
		stepDefinitionsByPattern.put(stepDefinition.getPattern(), stepDefinition);
	}

	@Override
	public void addBeforeHook(HookDefinition hookDefinition) {
		beforeHooks.add(hookDefinition);
		Collections.sort(beforeHooks, new HookComparator(true));
	}

	@Override
	public void addAfterHook(HookDefinition hookDefinition) {
		afterHooks.add(hookDefinition);
		Collections.sort(afterHooks, new HookComparator(false));
	}

	@Override
	public void addBeforeStepHook(HookDefinition hookDefinition) {
		beforeStepHooks.add(hookDefinition);
		Collections.sort(beforeStepHooks, new HookComparator(true));
	}

	@Override
	public void addAfterStepHook(HookDefinition hookDefinition) {
		afterStepHooks.add(hookDefinition);
		Collections.sort(afterStepHooks, new HookComparator(false));
	}

	@Override
	public List<HookDefinition> getBeforeHooks() {
		return beforeHooks;
	}

	@Override
	public List<HookDefinition> getAfterHooks() {
		return afterHooks;
	}

	@Override
	public List<HookDefinition> getBeforeStepsHooks() {
		return beforeStepHooks;
	}

	@Override
	public List<HookDefinition> getAfterStepsHooks() {
		return afterStepHooks;
	}

	@Override
	public StepDefinitionMatch stepDefinitionMatch(String featurePath, Step step, I18n i18n) {
		List<StepDefinitionMatch> matches = stepDefinitionMatches(featurePath, step);
		try
		{
			if (matches.size() == 0)
			{
				tracker.addUndefinedStep(step, i18n);
				return null;
			}
			if (matches.size() == 1)
			{
				return matches.get(0);
			}
			else
			{
				throw new AmbiguousStepDefinitionsException(matches);
			}
		}
		finally
		{
			tracker.storeStepKeyword(step, i18n);
		}
	}

	private List<StepDefinitionMatch> stepDefinitionMatches(String featurePath, Step step) {
		List<StepDefinitionMatch> result = new ArrayList<StepDefinitionMatch>();
		for (StepDefinition stepDefinition : stepDefinitionsByPattern.values())
		{
			List<Argument> arguments = stepDefinition.matchedArguments(step);
			if (arguments != null)
			{
				result.add(new StepDefinitionMatch(arguments, stepDefinition, featurePath, step, localizedXStreams));
			}
		}
		return result;
	}

	@Override
	public void reportStepDefinitions(StepDefinitionReporter stepDefinitionReporter) {
		for (StepDefinition stepDefinition : stepDefinitionsByPattern.values())
		{
			stepDefinitionReporter.stepDefinition(stepDefinition);
		}
	}

	@Override
	public void removeScenarioScopedGlue() {
		removeScenarioScopedHooks(beforeHooks);
		removeScenarioScopedHooks(afterHooks);
		removeScenarioScopedStepdefs();
	}

	private void removeScenarioScopedHooks(List<HookDefinition> beforeHooks1) {
		Iterator<HookDefinition> hookIterator = beforeHooks1.iterator();
		while (hookIterator.hasNext())
		{
			HookDefinition hook = hookIterator.next();
			if (hook.isScenarioScoped())
			{
				hookIterator.remove();
			}
		}
	}

	private void removeScenarioScopedStepdefs() {
		Iterator<Map.Entry<String, StepDefinition>> stepdefs = stepDefinitionsByPattern.entrySet().iterator();
		while (stepdefs.hasNext())
		{
			StepDefinition stepDefinition = stepdefs.next().getValue();
			if (stepDefinition.isScenarioScoped())
			{
				stepdefs.remove();
			}
		}
	}
}
