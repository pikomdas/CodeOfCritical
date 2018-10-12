Feature: user is applying job on www.naukri.com

Scenario: Verify that user is able to search  job and appy job

Given user successfully login to portal and user is on Home page
When user clicks  on Search Jobs and insert text and click search
Then search results are displayed
Then user clicks on a job link and navigates to jobs description page
And user clicks on Apply button and navigates back to search result page
