$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("/home/amit/git/CodeOfCritical/Naukri/src/main/java/com/Naukri/featureFiles/ApplyJob.feature");
formatter.feature({
  "line": 1,
  "name": "user is applying job on www.naukri.com",
  "description": "",
  "id": "user-is-applying-job-on-www.naukri.com",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 3,
  "name": ": Verify that user is able to search  job and appy job",
  "description": "",
  "id": "user-is-applying-job-on-www.naukri.com;:-verify-that-user-is-able-to-search--job-and-appy-job",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 2,
      "name": "@test"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "user successfully login to portal with \"\u003cusername\u003e\" and \"\u003cpassword\u003e\" and user is on Home page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "user clicks on Search Jobs and insert text and click search",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "search results are displayed",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "user clicks on a job link and navigates to jobs description page and navigate back to sarch page",
  "keyword": "Then "
});
formatter.examples({
  "line": 10,
  "name": "",
  "description": "",
  "id": "user-is-applying-job-on-www.naukri.com;:-verify-that-user-is-able-to-search--job-and-appy-job;",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ],
      "line": 11,
      "id": "user-is-applying-job-on-www.naukri.com;:-verify-that-user-is-able-to-search--job-and-appy-job;;1"
    },
    {
      "cells": [
        "pikom.das@gmail.com",
        "9038583164"
      ],
      "line": 12,
      "id": "user-is-applying-job-on-www.naukri.com;:-verify-that-user-is-able-to-search--job-and-appy-job;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 13728240493,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": ": Verify that user is able to search  job and appy job",
  "description": "",
  "id": "user-is-applying-job-on-www.naukri.com;:-verify-that-user-is-able-to-search--job-and-appy-job;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 2,
      "name": "@test"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "user successfully login to portal with \"pikom.das@gmail.com\" and \"9038583164\" and user is on Home page",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "user clicks on Search Jobs and insert text and click search",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "search results are displayed",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "user clicks on a job link and navigates to jobs description page and navigate back to sarch page",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "pikom.das@gmail.com",
      "offset": 40
    },
    {
      "val": "9038583164",
      "offset": 66
    }
  ],
  "location": "JobApply_ToNaukri.user_successfully_login_to_portal_and_user_is_on_Home_page(String,String)"
});
formatter.result({
  "duration": 4862270059,
  "status": "passed"
});
formatter.match({
  "location": "JobApply_ToNaukri.user_clicks_on_Search_Job_and_insert_text_and_click_search()"
});
formatter.result({
  "duration": 15601741952,
  "status": "passed"
});
formatter.match({
  "location": "JobApply_ToNaukri.search_results_are_displayed()"
});
formatter.result({
  "duration": 1996110644,
  "status": "passed"
});
formatter.match({
  "location": "JobApply_ToNaukri.user_clicks_on_a_job_link_and_navigates_to_jobs_description_page()"
});
formatter.result({
  "duration": 2713383132762,
  "error_message": "org.openqa.selenium.WebDriverException: chrome not reachable\n  (Session info: chrome\u003d70.0.3538.77)\n  (Driver info: chromedriver\u003d2.42.591071 (0b695ff80972cc1a65a5cd643186d2ae582cd4ac),platform\u003dLinux 4.15.0-47-generic x86_64) (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 0 milliseconds\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027Critical\u0027, ip: \u0027127.0.1.1\u0027, os.name: \u0027Linux\u0027, os.arch: \u0027amd64\u0027, os.version: \u00274.15.0-47-generic\u0027, java.version: \u00271.8.0_181\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, acceptSslCerts: false, applicationCacheEnabled: false, browserConnectionEnabled: false, browserName: chrome, chrome: {chromedriverVersion: 2.42.591071 (0b695ff80972cc..., userDataDir: /tmp/.org.chromium.Chromium...}, cssSelectorsEnabled: true, databaseEnabled: false, goog:chromeOptions: {debuggerAddress: localhost:44299}, handlesAlerts: true, hasTouchScreen: false, javascriptEnabled: true, locationContextEnabled: true, mobileEmulationEnabled: false, nativeEvents: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: LINUX, platformName: LINUX, rotatable: false, setWindowRect: true, takesHeapSnapshot: true, takesScreenshot: true, unexpectedAlertBehaviour: , unhandledPromptBehavior: , version: 70.0.3538.77, webStorageEnabled: true}\nSession ID: de5662932c32922ad01458faffae6a33\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:214)\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:166)\n\tat org.openqa.selenium.remote.http.JsonHttpResponseCodec.reconstructValue(JsonHttpResponseCodec.java:40)\n\tat org.openqa.selenium.remote.http.AbstractHttpResponseCodec.decode(AbstractHttpResponseCodec.java:80)\n\tat org.openqa.selenium.remote.http.AbstractHttpResponseCodec.decode(AbstractHttpResponseCodec.java:44)\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\n\tat org.openqa.selenium.remote.RemoteWebDriver$RemoteTargetLocator.window(RemoteWebDriver.java:903)\n\tat com.Naukri.PageObjectClasses.JobSearchResultPage.appyjob1by1(JobSearchResultPage.java:103)\n\tat com.Naukri.stepDefinations.JobApply_ToNaukri.user_clicks_on_a_job_link_and_navigates_to_jobs_description_page(JobApply_ToNaukri.java:36)\n\tat ✽.Then user clicks on a job link and navigates to jobs description page and navigate back to sarch page(/home/amit/git/CodeOfCritical/Naukri/src/main/java/com/Naukri/featureFiles/ApplyJob.feature:8)\n",
  "status": "failed"
});
formatter.after({
  "duration": 7109846,
  "error_message": "org.openqa.selenium.NoSuchWindowException: no such window: target window already closed\nfrom unknown error: web view not found\n  (Session info: chrome\u003d70.0.3538.77)\n  (Driver info: chromedriver\u003d2.42.591071 (0b695ff80972cc1a65a5cd643186d2ae582cd4ac),platform\u003dLinux 4.15.0-47-generic x86_64) (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 0 milliseconds\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027Critical\u0027, ip: \u0027127.0.1.1\u0027, os.name: \u0027Linux\u0027, os.arch: \u0027amd64\u0027, os.version: \u00274.15.0-47-generic\u0027, java.version: \u00271.8.0_181\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, acceptSslCerts: false, applicationCacheEnabled: false, browserConnectionEnabled: false, browserName: chrome, chrome: {chromedriverVersion: 2.42.591071 (0b695ff80972cc..., userDataDir: /tmp/.org.chromium.Chromium...}, cssSelectorsEnabled: true, databaseEnabled: false, goog:chromeOptions: {debuggerAddress: localhost:44299}, handlesAlerts: true, hasTouchScreen: false, javascriptEnabled: true, locationContextEnabled: true, mobileEmulationEnabled: false, nativeEvents: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: LINUX, platformName: LINUX, rotatable: false, setWindowRect: true, takesHeapSnapshot: true, takesScreenshot: true, unexpectedAlertBehaviour: , unhandledPromptBehavior: , version: 70.0.3538.77, webStorageEnabled: true}\nSession ID: de5662932c32922ad01458faffae6a33\n\tat sun.reflect.GeneratedConstructorAccessor18.newInstance(Unknown Source)\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:214)\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:166)\n\tat org.openqa.selenium.remote.http.JsonHttpResponseCodec.reconstructValue(JsonHttpResponseCodec.java:40)\n\tat org.openqa.selenium.remote.http.AbstractHttpResponseCodec.decode(AbstractHttpResponseCodec.java:80)\n\tat org.openqa.selenium.remote.http.AbstractHttpResponseCodec.decode(AbstractHttpResponseCodec.java:44)\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:609)\n\tat org.openqa.selenium.remote.RemoteWebDriver.getCurrentUrl(RemoteWebDriver.java:287)\n\tat com.Naukri.utility.configFiles.cucumberReportAfterExecution.\u003cinit\u003e(cucumberReportAfterExecution.java:26)\n\tat com.Naukri.hooks.Hooks.beforeSecondRnd(Hooks.java:47)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n\tat java.lang.reflect.Method.invoke(Method.java:498)\n\tat cucumber.runtime.Utils$1.call(Utils.java:37)\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:13)\n\tat cucumber.runtime.Utils.invoke(Utils.java:31)\n\tat cucumber.runtime.java.JavaHookDefinition.execute(JavaHookDefinition.java:60)\n\tat cucumber.runtime.Runtime.runHookIfTagsMatch(Runtime.java:253)\n\tat cucumber.runtime.Runtime.runHooks(Runtime.java:225)\n\tat cucumber.runtime.Runtime.runAfterHooks(Runtime.java:217)\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:46)\n\tat cucumber.runtime.junit.ExecutionUnitRunner.run(ExecutionUnitRunner.java:91)\n\tat org.junit.runners.Suite.runChild(Suite.java:128)\n\tat org.junit.runners.Suite.runChild(Suite.java:27)\n\tat org.junit.runners.ParentRunner$4.run(ParentRunner.java:330)\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:78)\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:328)\n\tat org.junit.runners.ParentRunner.access$100(ParentRunner.java:65)\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:292)\n\tat org.junit.runners.ParentRunner$3.evaluate(ParentRunner.java:305)\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:412)\n\tat cucumber.runtime.junit.ExamplesRunner.run(ExamplesRunner.java:59)\n\tat org.junit.runners.Suite.runChild(Suite.java:128)\n\tat org.junit.runners.Suite.runChild(Suite.java:27)\n\tat org.junit.runners.ParentRunner$4.run(ParentRunner.java:330)\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:78)\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:328)\n\tat org.junit.runners.ParentRunner.access$100(ParentRunner.java:65)\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:292)\n\tat org.junit.runners.ParentRunner$3.evaluate(ParentRunner.java:305)\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:412)\n\tat cucumber.runtime.junit.ScenarioOutlineRunner.run(ScenarioOutlineRunner.java:53)\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:63)\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:18)\n\tat org.junit.runners.ParentRunner$4.run(ParentRunner.java:330)\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:78)\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:328)\n\tat org.junit.runners.ParentRunner.access$100(ParentRunner.java:65)\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:292)\n\tat org.junit.runners.ParentRunner$3.evaluate(ParentRunner.java:305)\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:412)\n\tat cucumber.runtime.junit.FeatureRunner.run(FeatureRunner.java:70)\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:93)\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:37)\n\tat org.junit.runners.ParentRunner$4.run(ParentRunner.java:330)\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:78)\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:328)\n\tat org.junit.runners.ParentRunner.access$100(ParentRunner.java:65)\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:292)\n\tat org.junit.internal.runners.statements.RunAfters.evaluate(RunAfters.java:27)\n\tat org.junit.runners.ParentRunner$3.evaluate(ParentRunner.java:305)\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:412)\n\tat cucumber.api.junit.Cucumber.run(Cucumber.java:98)\n\tat org.junit.runner.JUnitCore.run(JUnitCore.java:137)\n\tat org.junit.runner.JUnitCore.run(JUnitCore.java:115)\n\tat org.testng.junit.JUnit4TestRunner.start(JUnit4TestRunner.java:81)\n\tat org.testng.junit.JUnit4TestRunner.run(JUnit4TestRunner.java:69)\n\tat org.testng.TestRunner$1.run(TestRunner.java:697)\n\tat org.testng.TestRunner.runJUnitWorkers(TestRunner.java:1004)\n\tat org.testng.TestRunner.privateRunJUnit(TestRunner.java:728)\n\tat org.testng.TestRunner.run(TestRunner.java:629)\n\tat org.testng.SuiteRunner.runTest(SuiteRunner.java:366)\n\tat org.testng.SuiteRunner.runSequentially(SuiteRunner.java:361)\n\tat org.testng.SuiteRunner.privateRun(SuiteRunner.java:319)\n\tat org.testng.SuiteRunner.run(SuiteRunner.java:268)\n\tat org.testng.SuiteRunnerWorker.runSuite(SuiteRunnerWorker.java:52)\n\tat org.testng.SuiteRunnerWorker.run(SuiteRunnerWorker.java:86)\n\tat org.testng.TestNG.runSuitesSequentially(TestNG.java:1244)\n\tat org.testng.TestNG.runSuitesLocally(TestNG.java:1169)\n\tat org.testng.TestNG.run(TestNG.java:1064)\n\tat org.apache.maven.surefire.testng.TestNGExecutor.run(TestNGExecutor.java:135)\n\tat org.apache.maven.surefire.testng.TestNGDirectoryTestSuite.executeSingleClass(TestNGDirectoryTestSuite.java:112)\n\tat org.apache.maven.surefire.testng.TestNGDirectoryTestSuite.execute(TestNGDirectoryTestSuite.java:99)\n\tat org.apache.maven.surefire.testng.TestNGProvider.invoke(TestNGProvider.java:146)\n\tat org.apache.maven.surefire.booter.ForkedBooter.invokeProviderInSameClassLoader(ForkedBooter.java:384)\n\tat org.apache.maven.surefire.booter.ForkedBooter.runSuitesInProcess(ForkedBooter.java:345)\n\tat org.apache.maven.surefire.booter.ForkedBooter.execute(ForkedBooter.java:126)\n\tat org.apache.maven.surefire.booter.ForkedBooter.main(ForkedBooter.java:418)\n",
  "status": "failed"
});
});