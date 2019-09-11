package com.Naukri.stepDefinations;

import com.Naukri.BrowserBase.browser;
import com.Naukri.PageObjectClasses.HomePageToSearchJob;
import com.Naukri.PageObjectClasses.JobSearchResultPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class JobApply_ToNaukri extends browser{

	@Given("^user successfully login to portal with \"([^\"]*)\" and \"([^\"]*)\" and user is on Home page$") // \"(.*)\"
	public void user_successfully_login_to_portal_and_user_is_on_Home_page(String username, String password){

		
		System.out.println();
		
	}

	@When("^user clicks on Search Jobs and insert text and click search$")
	public void user_clicks_on_Search_Job_and_insert_text_and_click_search() throws InterruptedException {
		HomePageToSearchJob hptsj = new HomePageToSearchJob(driver);
		hptsj.profileDetails();
		hptsj.searchJob("Selenium", "Pune");
	}

	@Then("^search results are displayed$")
	public void search_results_are_displayed() {
		System.out.println("Search resuts are displayed on " + driver.getTitle() + " page");
	}

	@Then("^user clicks on a job link and navigates to jobs description page and navigate back to sarch page$")
	public void user_clicks_on_a_job_link_and_navigates_to_jobs_description_page() throws Throwable {
		JobSearchResultPage jsrp = new JobSearchResultPage(driver);
		jsrp.appyjob1by1();
	}

}// End of Class
