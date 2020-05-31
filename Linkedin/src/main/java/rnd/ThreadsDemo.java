package rnd;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class ThreadsDemo
{
	public static void main(String[] args) throws InterruptedException
	{
		List<WebDriver> li = new ArrayList<WebDriver>();

		Runnable r1 = () -> {
			WebDriver driver = new browser().trigger();
			li.add(driver);
			driver.get("https://assetvantage.com");
			List<WebElement> ll = driver.findElements(By.xpath("//a"));
			ll.forEach(x -> {
				new Service(x.getTagName(), x.getAttribute("href")).addData();
			});
		};
		Runnable r2 = () -> {
			WebDriver driver = new browser().trigger();
			li.add(driver);
			driver.get("https://hotstar.com");
			List<WebElement> ll = driver.findElements(By.xpath("//a"));
			ll.forEach(x -> {
				new Service(x.getTagName(), x.getAttribute("href")).addData();
			});
		};
		Runnable quitDriver = () -> {
			li.forEach(x -> x.quit());
		};


		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		Thread t3 = new Thread(quitDriver);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		t3.start();
		Service.ss.forEach(System.out::println);
	}
}

class Service
{
	public static List<Service> ss = new ArrayList<Service>();
	private String tagName;
	private String text;

	public Service(String tagName, String text)
	{
		this.tagName = tagName;
		this.text = text;
	}

	private int count = 0;

	@Override
	public String toString()
	{
		return "Service{" +
				"tagName='" + tagName + '\'' +
				", text='" + text + '\'' +
				", count=" + count +
				'}';
	}

	public void addData()
	{
		ss.add(this);
		System.out.println("Added " + count + " time");
		count++;
	}

}

class browser
{
	private WebDriver driver;

	static
	{
		WebDriverManager.chromedriver().setup();
	}

	public WebDriver trigger()
	{
		driver = new ChromeDriver();
		return driver;
	}
}

