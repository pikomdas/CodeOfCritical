package com.Naukri;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class JobApply_ToNaukri {

	public WebDriver driver;
	String oldTab;
	
	@Given("^user successfully login to portal and user is on Home page$")
	public void user_successfully_login_to_portal_and_user_is_on_Home_page() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "/opt/selenium/Chrome_Linux/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.naukri.com");
		driver.manage().window().maximize();
		System.out.println("Naukri.com launched from mandate()");
		String originalHandle = driver.getWindowHandle();
		// Close all popup tabs **URGENT*****
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(originalHandle)) {
				driver.switchTo().window(handle);
				driver.close();
			}
		}
		driver.switchTo().window(originalHandle);
		// Click on LOGIN on Landing page
		WebElement lgin = driver.findElement(By.xpath("/html/body/div[2]/div/ul/li[6]/a/div"));
		if (lgin.isDisplayed() == true) {
			String login = lgin.getText();
			System.out.println("LOGIN FIELD IS PRESENT " + login);
			lgin.click();
			Thread.sleep(4000);
		}

		// User throw ID and PASSWORD and CLICK on LOGIN button
		List<WebElement> usr = new ArrayList<WebElement>();
		usr.add(driver.findElement(By.id("eLogin")));
		usr.add(driver.findElement(By.id("eLoginNew")));
		usr.add(driver.findElement(By.id("usernameField")));
		try {
			for (int i = 0; i <= usr.size(); i++) {
				try {
				if (usr.get(i).isDisplayed()) {
					usr.get(i).sendKeys("pikom.das@gmail.com");
				}
			}catch (Exception e) {e.getMessage();}
			}
		} catch (Exception e) {
			e.getMessage();
		}
		
		        
        
		WebElement[] pass = {driver.findElement(By.id("passwordField")),driver.findElement(By.id("pLogin"))};
		for(WebElement e: pass) {
		if (e.isDisplayed() == true) {
			System.out.println("password FIELD IS PRESENT " + pass);
			e.sendKeys("9038583164");
		}}

		WebElement btn = driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
		if (btn.isDisplayed() == true) {
			System.out.println("Button IS PRESENT " + btn.getText());
			btn.click();
		}
		} 
	
	
	@When("^user clicks  on Search Jobs and insert text and click search$")
	public void user_clicks_on_Search_Job_and_insert_text_and_click_search() throws InterruptedException
	{
		
			Thread.sleep(8000);
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement srch1Click = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='qsb-keyskill-sugg' and @name='qp']")));
			if (srch1Click.isDisplayed() == true) {
				System.out.println("textbox1 IS PRESENT " + srch1Click.getText());
				srch1Click.click();

				WebElement jobSrchTxt = driver.findElement(By.name("qp"));
				if (srch1Click.isDisplayed() == true) {
					System.out.println("textbox2 IS PRESENT " + jobSrchTxt.getText());
					jobSrchTxt.sendKeys("Selenium");
					WebElement srch2Click = driver.findElement(By.xpath("//*[@id='search-jobs']/button"));
					if (srch2Click.isDisplayed() == true) {
						System.out.println("button2 IS PRESENT " + srch2Click.getText());
						srch2Click.click();
						System.out.println("button2 IS Clicked " + srch2Click.getText());
					}
				}
			}
	}
	
	
	@Then("^search results are displayed$")
	public void search_results_are_displayed()
	{
		System.out.println(driver.getTitle());
	}
	@Then("^user clicks on a job link and navigates to jobs description page$")
	public void user_clicks_on_a_job_link_and_navigates_to_jobs_description_page() throws InterruptedException
	{
		By mySelector = By.className("desig");
		List<WebElement> myElements = driver.findElements(mySelector);
		for (WebElement e : myElements) {
			WebDriverWait wait2 = new WebDriverWait(driver, 10);
			wait2.until(ExpectedConditions.elementToBeClickable(e));
			System.out.println(e.getText() + " >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>job link in displayed");
			oldTab = driver.getWindowHandle();
			e.click(); // CLicked on Job Link
			user_clicks_on_Apply_button_and_navigates_back_to_search_result_page();
		} // End of FOR LOOP
	
    }
	
	@And("^user clicks on Apply button and navigates back to search result page$")
	public void user_clicks_on_Apply_button_and_navigates_back_to_search_result_page() throws InterruptedException
	{
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {

			if (!handle.equals(oldTab)) {
				driver.switchTo().window(handle);
				Thread.sleep(4000);
				clickonJobApplyButton();
				Thread.sleep(4000);
			}
		}
		driver.switchTo().window(oldTab);
		System.out.println("Navigated back to>>>>>>>>>>>>>>>>>>>>>>>>>>> : " + oldTab.toUpperCase());
	}
	
	public void	clickonJobApplyButton() {			
		
		System.out.println("New WebPage Name is : " + driver.getTitle());

		driver.findElement(By.cssSelector("ul.listing.mt10.wb")).getText();
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		By buttonSelector = By.cssSelector("[id*='trig1']");
		WebElement jobApply = wait1.until(ExpectedConditions.visibilityOfElementLocated(buttonSelector));

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
			driver.close(); // Closing the tab where apply not possible
		}
	}

}// End of Class
