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
