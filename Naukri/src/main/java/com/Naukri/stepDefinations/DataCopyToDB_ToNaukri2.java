package com.Naukri.stepDefinations;
/*package com.Naukri;

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

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DataCopyToDB_ToNaukri2 {

	static WebDriver driver;
	static WebDriverWait w1;
	@Given("^user successfully login to portal with \"([^\"]*)\" and \"([^\"]*)\" and user is on Home page$") // \"(.*)\"
	public void user_successfully_login_to_portal_and_user_is_on_Home_page(String username, String password) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "/opt/selenium/Chrome_Linux/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.naukri.com");
		driver.manage().window().maximize();
		System.out.println("Naukri.com launched");
		String originalHandle = driver.getWindowHandle();
		// Closing all popUp windows while LogIn
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

		// User throws ID and PASSWORD and CLICKs on LOGIN button
	
		driver.findElement(By.name("email")).sendKeys(username);
		driver.findElement(By.name("PASSWORD")).sendKeys(password);
		
        WebElement btn = driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
		if (btn.isDisplayed() == true) {
			System.out.println("Button IS PRESENT " + btn.getText());
			btn.click();
		}
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
			//Job Name, output as String
			String Jobname = null;
			try {
				Jobname = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div[1]/div[1]/div/h1")).getText();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//Company name 
			String companyName = null;
			try {
				companyName = driver.findElement(By.id("jdCpName")).getText();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//Location of Job
			String jobLocation = null;
			try {
				jobLocation = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div[1]/div[1]/div/div[2]/div/a")).getText();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//salary f Job
			String salary = null;
			try {
				salary = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div[2]/div[2]/p[1]/span/span")).getText();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//Role of Job
			String jobRole = null;
			try {
				jobRole = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div[2]/div[2]/p[5]/span")).getText();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			 * EMAIL and PHONE NUMBER IF FOUND
			 * AFTER CLICKING on View Contact Details LINK
			 
			WebElement ContactDetails=driver.findElement(By.linkText("View Contact Details"));
			ContactDetails.click();
			String email = null;
			try {
				email = driver.findElement(By.xpath("//*[@id=\"viewContact\"]/p[2]/span/img")).getText();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String recruiterName = null;
			try {
				recruiterName = driver.findElement(By.xpath("//*[@id=\"viewContact\"]/p[1]/span")).getText();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				System.out.println("Jobname "+Jobname+" from Company "+companyName+" on Location "+jobLocation+
						" Offering Salary" +salary+ " for Role of the "+jobRole+ " and email of HR "
						+recruiterName+ " is " +email);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
*/