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
  "duration": 9718735511,
  "error_message": "java.lang.NullPointerException\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\n\tat com.sun.proxy.$Proxy16.isDisplayed(Unknown Source)\n\tat org.openqa.selenium.support.ui.ExpectedConditions.elementIfVisible(ExpectedConditions.java:315)\n\tat org.openqa.selenium.support.ui.ExpectedConditions.access$100(ExpectedConditions.java:44)\n\tat org.openqa.selenium.support.ui.ExpectedConditions$10.apply(ExpectedConditions.java:301)\n\tat org.openqa.selenium.support.ui.ExpectedConditions$10.apply(ExpectedConditions.java:298)\n\tat org.openqa.selenium.support.ui.ExpectedConditions$23.apply(ExpectedConditions.java:686)\n\tat org.openqa.selenium.support.ui.ExpectedConditions$23.apply(ExpectedConditions.java:682)\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:260)\n\tat com.Naukri.PageObjectClasses.LandingPage.loginToNaukri(LandingPage.java:65)\n\tat com.Naukri.stepDefinations.JobApply_ToNaukri.user_successfully_login_to_portal_and_user_is_on_Home_page(JobApply_ToNaukri.java:32)\n\tat ✽.Given user successfully login to portal with \"pikom.das@gmail.com\" and \"9038583164\" and user is on Home page(/home/amit/git/CodeOfCritical/Naukri/src/main/java/com/Naukri/featureFiles/ApplyJob.feature:5)\n",
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