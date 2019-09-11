package com.Naukri.stepDefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/*
 * 
 */
public class login_ToNaukri 
{
	
	public WebDriver driver;
	
    @Given("^user is on login page$")
    public void gotoLoginPage() 
    {
    	System.setProperty("webdriver.chrome.driver","/opt/selenium/Chrome_Linux/chromedriver");	
    	driver=new ChromeDriver();
    	driver.get("https://www.naukri.com");
		driver.manage().window().maximize();
		System.out.println("Naukri.com launched from mandate()");
		String originalHandle = driver.getWindowHandle();

	                 //Close all popup tabs **URGENT*****
                     for(String handle : driver.getWindowHandles()) {
	                    if (!handle.equals(originalHandle)) {
	                         driver.switchTo().window(handle);
	                         driver.close();
	                                 }
	                 }

	    driver.switchTo().window(originalHandle);
    }
    
    @When("^user throw username and password and click on Login button$")
    public void loginToNaukri()
    {
    	try {
			
  	        WebElement lgin = driver.findElement(By.xpath("/html/body/div[2]/div/ul/li[6]/a/div"));
  			if(lgin.isDisplayed()==true)
  			{
  			  String login=lgin.getText();
  			  System.out.println("LOGIN FIELD IS PRESENT " +login);
  			  lgin.click();
  			  Thread.sleep(4000);}
  		      } 
    	catch (Exception e) {
  			    e.printStackTrace();
  			    }
    	try {
     	   WebElement usr = driver.findElement(By.id("usernameField"));
 			if(usr.isDisplayed()==true)
 			{
 			System.out.println("username FIELD IS PRESENT " +usr);
 			usr.sendKeys("pikom.das@gmail.com");}}
 			catch (Exception e) {
 				e.printStackTrace();
 			}
 			try {driver.findElement(By.id("eLogin")).sendKeys("pikom.das@gmail.com");}
 			catch (Exception e) {
 				e.printStackTrace();
 			}
 			try { driver.findElement(By.id("eLoginNew")).sendKeys("pikom.das@gmail.com");}
 			catch (Exception e) {
 				e.printStackTrace();
 			}
 			try {WebElement pass = driver.findElement(By.id("passwordField"));
 			if(pass.isDisplayed()==true)
 			{
 			System.out.println("password FIELD IS PRESENT " +pass);
 			pass.sendKeys("9038583164");}}
 			catch (Exception e) {
 				e.printStackTrace();
 			}
 			try{ driver.findElement(By.id("pLogin")).sendKeys("9038583164");}
 			catch (Exception e) {
 				e.printStackTrace();
 			}
 			
 			try {
 				WebElement btn = driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
 				if (btn.isDisplayed() == true) {
 					System.out.println("button IS PRESENT " + btn.getText());
 					btn.click();
 				} 
 			} catch (Exception e) {
 				e.printStackTrace();
 			}
 }			
    
@Then("^Naukri.com home page is displayed$")
public void naukriHomePage() {
	System.out.println(driver.getTitle().toUpperCase());
}



}  //END OF CLASS

