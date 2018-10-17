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
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "user successfully login to portal with \"\u003cusername\u003e\" and \"\u003cpassword\u003e\" and user is on Home page",
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
formatter.scenario({
  "line": 12,
  "name": ": Verify that user is able to search  job and appy job",
  "description": "",
  "id": "user-is-applying-job-on-www.naukri.com;:-verify-that-user-is-able-to-search--job-and-appy-job;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
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
  "duration": 185268844,
  "error_message": "java.lang.NullPointerException\n\tat com.Naukri.FileReaderManager.ConfigFileReader.getDriverPath(ConfigFileReader.java:34)\n\tat com.naukri.BrowserBase.browser.\u003cinit\u003e(browser.java:13)\n\tat com.Naukri.PageObjectClasses.LandingPage.\u003cinit\u003e(LandingPage.java:15)\n\tat com.Naukri.stepDefinations.JobApply_ToNaukri.user_successfully_login_to_portal_and_user_is_on_Home_page(JobApply_ToNaukri.java:31)\n\tat ✽.Given user successfully login to portal with \"pikom.das@gmail.com\" and \"9038583164\" and user is on Home page(/home/amit/git/CodeOfCritical/Naukri/src/main/java/com/Naukri/featureFiles/ApplyJob.feature:5)\n",
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
});