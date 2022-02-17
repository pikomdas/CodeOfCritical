package rnd;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public class StreamDemo
{
	public static void main(String[] args) throws InterruptedException
	{
		long l1, l2;
		l1 = System.currentTimeMillis();
		Stream<String> mystream = Stream.of("https://codeOfCritical.com", "https://hotstar.com", "https://netflix.com");
		mystream.parallel().forEach(x -> {
			WebDriver driver = new browser1().trigger();

			driver.get(x);
			List<WebElement> ll = driver.findElements(By.xpath("//a"));
			ll.stream().parallel().forEach(y -> {
				new Service1(y.getTagName(), y.getAttribute("href")).addData();
			});
			driver.quit();
		});
		System.out.println("---------------------------------------------------------------------------------");
		Service1.ss.forEach(System.out::println);
		System.out.println("---------------------------------------------------------------------------------");
		l2 = System.currentTimeMillis();
		System.out.println((l2 - l1) / 1000); //28 //25
	}

}

class Service1
{
	public static List<Service1> ss = new ArrayList<Service1>();
	private String tagName;
	private String text;

	public Service1(String tagName, String text)
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

class browser1
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