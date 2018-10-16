package com.Naukri.stepDefinations;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Naukri.PageObjectClasses.LandingPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class JobApply_ToNaukri {

	static WebDriver driver;
	static WebDriverWait w1;
	@Given("^user successfully login to portal with \"([^\"]*)\" and \"([^\"]*)\" and user is on Home page$") // \"(.*)\"
	public void user_successfully_login_to_portal_and_user_is_on_Home_page(String username, String password) throws InterruptedException
	{
		
		LandingPage lp=new LandingPage(driver);
		lp.loginToNaukri(username, password);
		} 
	
	
	@When("^user clicks  on Search Jobs and insert text and click search$")
	public void user_clicks_on_Search_Job_and_insert_text_and_click_search() throws InterruptedException
	{
		w1 = new WebDriverWait(driver, 10);
			WebElement srch1Click = w1.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='qsb-keyskill-sugg' and @name='qp']")));
			if (srch1Click.isDisplayed() == true) {
				System.out.println("textbox1 IS PRESENT " + srch1Click.getAttribute("innerHtml"));
				srch1Click.click();

				WebElement jobName = driver.findElement(By.name("qp"));
				WebElement jobLocation=driver.findElement(By.name("ql"));
				WebElement experience=driver.findElement(By.id("expDroope-experienceFor"));
				WebElement Salary=driver.findElement(By.id("salaryDroope-salaryFor"));
				if (srch1Click.isDisplayed() == true) {
					System.out.println("textbox2 IS PRESENT " + jobName.getAttribute("innerHtml"));
					jobName.sendKeys("Selenium"); //Sent Job skill
					jobLocation.sendKeys("Pune"); //Sent Job Location
					experience.click(); 
					driver.findElement(By.xpath("//*[@id=\"ul_expDroope-experience\"]/ul/li[6]/a")).click();
					Salary.click();
					driver.findElement(By.xpath("//*[@id=\"ul_salaryDroope-salary\"]/ul/li[8]/a")).click();
					WebElement srch2Click = driver.findElement(By.xpath("//*[@id='search-jobs']/button"));
					if (srch2Click.isDisplayed() == true) {
						System.out.println("button2 IS PRESENT " + srch2Click.getText());
						//Location set
						//Click on Search button to search JOB
						srch2Click.click();
						System.out.println("button2 IS Clicked " + srch2Click.getText());
					}
				}
			}
	}
	
	
	@Then("^search results are displayed$")
	public void search_results_are_displayed()
	{
		System.out.println("Search resuts are displayed on "+driver.getTitle()+ " page");
	}
	
	@Then("^user clicks on a job link and navigates to jobs description page and navigate back to sarch page$")
	public void user_clicks_on_a_job_link_and_navigates_to_jobs_description_page() throws InterruptedException
	{
		Thread.sleep(4000);
		By mySelector = By.className("desig");
		List<WebElement> myElements = driver.findElements(mySelector);
		for (WebElement e : myElements) {
			w1 = new WebDriverWait(driver, 10);
			w1.until(ExpectedConditions.elementToBeClickable(e));
			System.out.println(e.getText() + " >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>job link in displayed");
			String JobSearchResultTab = driver.getWindowHandle();
			e.click(); // CLicked on Job Link
			Set<String> handlesOfAllJobpage = driver.getWindowHandles();
			for (String handleOfOnepage : handlesOfAllJobpage) {

				if (!handleOfOnepage.equals(JobSearchResultTab)) {
					driver.switchTo().window(handleOfOnepage);
					driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					clickonJobApplyButton();
					Thread.sleep(4000);
				}
			}
			driver.switchTo().window(JobSearchResultTab);
			System.out.println("Navigated back to>>>>>>>>>>>>>>>>>>>>>>>>>>> : " + JobSearchResultTab.toUpperCase());
		} // End of FOR LOOP

	}
	
	public void clickonJobApplyButton() {

		System.out.println("Navigated to Job page Name: " + driver.getTitle());

		try {
			//driver.findElement(By.cssSelector("ul.listing.mt10.wb")).getText();
			w1 = new WebDriverWait(driver, 10);
			By buttonSelector = By.cssSelector("[id*='trig1']");
			WebElement jobApply = w1.until(ExpectedConditions.visibilityOfElementLocated(buttonSelector));
			if (jobApply.isDisplayed() == true) {
				System.out.println("Blue Color Apply button is dispayed : " + jobApply.getText());
				Actions action = new Actions(driver);
				action.moveToElement(jobApply).click().perform();
				String appluButton = jobApply.getText();
				System.out.println(appluButton);
				// Finally Apply on Quickly Review and update your Profile
				driver.findElement(By.id("qupSubmit")).click();
				driver.close();
			} else {
				System.out.println("Job Apply blue colored button not found");
				driver.close(); // Closing the tab where apply not possible
			} 
		} catch (Exception e) {
			e.getMessage();
		}
	}

}// End of Class
