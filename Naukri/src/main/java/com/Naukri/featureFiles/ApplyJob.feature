Feature: user is applying job on www.naukri.com

Scenario Outline:: Verify that user is able to search  job and appy job

Given user successfully login to portal with "<username>" and "<password>" and user is on Home page
When user clicks  on Search Jobs and insert text and click search
Then search results are displayed
Then user clicks on a job link and navigates to jobs description page and navigate back to sarch page

Examples:
  |username| password|
  |pikom.das@gmail.com|9038583164|  