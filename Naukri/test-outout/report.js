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
  "duration": 29938384807,
  "status": "passed"
});
formatter.match({
  "location": "JobApply_ToNaukri.user_clicks_on_Search_Job_and_insert_text_and_click_search()"
});
formatter.result({
  "duration": 1074746084,
  "status": "passed"
});
formatter.match({
  "location": "JobApply_ToNaukri.search_results_are_displayed()"
});
formatter.result({
  "duration": 28231307,
  "status": "passed"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});