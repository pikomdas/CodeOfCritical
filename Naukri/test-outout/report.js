$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("/home/amit/eclipse-workspace/Naukri/src/main/java/featureFiles/ApplyJob.feature");
formatter.feature({
  "line": 1,
  "name": "user is applying job on www.naukri.com",
  "description": "",
  "id": "user-is-applying-job-on-www.naukri.com",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Verify that user is able to search  job and appy job",
  "description": "",
  "id": "user-is-applying-job-on-www.naukri.com;verify-that-user-is-able-to-search--job-and-appy-job",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "user successfully login to portal and user is on Home page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "user clicks  on Search Jobs and insert text and click search",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "search results are displayed",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "user clicks on a job link and navigates to jobs description page",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "user clicks on Apply button and navigates back to search result page",
  "keyword": "And "
});
formatter.match({
  "location": "JobApply_ToNaukri.user_successfully_login_to_portal_and_user_is_on_Home_page()"
});
formatter.result({
  "duration": 12332523094,
  "error_message": "org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"id\",\"selector\":\"eLoginNew\"}\n  (Session info: chrome\u003d69.0.3497.100)\n  (Driver info: chromedriver\u003d2.42.591071 (0b695ff80972cc1a65a5cd643186d2ae582cd4ac),platform\u003dLinux 4.15.0-36-generic x86_64) (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 0 milliseconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.14.0\u0027, revision: \u0027aacccce0\u0027, time: \u00272018-08-02T20:19:58.91Z\u0027\nSystem info: host: \u0027Critical\u0027, ip: \u0027127.0.1.1\u0027, os.name: \u0027Linux\u0027, os.arch: \u0027amd64\u0027, os.version: \u00274.15.0-36-generic\u0027, java.version: \u00271.8.0_181\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, acceptSslCerts: false, applicationCacheEnabled: false, browserConnectionEnabled: false, browserName: chrome, chrome: {chromedriverVersion: 2.42.591071 (0b695ff80972cc..., userDataDir: /tmp/.org.chromium.Chromium...}, cssSelectorsEnabled: true, databaseEnabled: false, goog:chromeOptions: {debuggerAddress: localhost:38901}, handlesAlerts: true, hasTouchScreen: false, javascriptEnabled: true, locationContextEnabled: true, mobileEmulationEnabled: false, nativeEvents: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: LINUX, platformName: LINUX, rotatable: false, setWindowRect: true, takesHeapSnapshot: true, takesScreenshot: true, unexpectedAlertBehaviour: , unhandledPromptBehavior: , version: 69.0.3497.100, webStorageEnabled: true}\nSession ID: f91dff5fb09e9f0ffeb444b2e8a91807\n*** Element info: {Using\u003did, value\u003deLoginNew}\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:214)\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:166)\n\tat org.openqa.selenium.remote.http.JsonHttpResponseCodec.reconstructValue(JsonHttpResponseCodec.java:40)\n\tat org.openqa.selenium.remote.http.AbstractHttpResponseCodec.decode(AbstractHttpResponseCodec.java:80)\n\tat org.openqa.selenium.remote.http.AbstractHttpResponseCodec.decode(AbstractHttpResponseCodec.java:44)\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:548)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:322)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementById(RemoteWebDriver.java:368)\n\tat org.openqa.selenium.By$ById.findElement(By.java:188)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:314)\n\tat com.Naukri.JobApply_ToNaukri.user_successfully_login_to_portal_and_user_is_on_Home_page(JobApply_ToNaukri.java:54)\n\tat ✽.Given user successfully login to portal and user is on Home page(/home/amit/eclipse-workspace/Naukri/src/main/java/featureFiles/ApplyJob.feature:5)\n",
  "status": "failed"
});
formatter.match({
  "location": "JobApply_ToNaukri.user_clicks_on_Search_Job_and_insert_text_and_click_search()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "JobApply_ToNaukri.search_results_are_displayed()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "JobApply_ToNaukri.user_clicks_on_a_job_link_and_navigates_to_jobs_description_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "JobApply_ToNaukri.user_clicks_on_Apply_button_and_navigates_back_to_search_result_page()"
});
formatter.result({
  "status": "skipped"
});
});