/**
 * 
 */
package rnd;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.linkedin.Browser.browser;
import com.linkedin.commomUtil.ScreenshotCapture;

/**
 * @author partha.das
 *
 */
public class ScrollAndCaptureImage
{

	public static void main(String[] args) throws IOException, InterruptedException
	{
		System.out.println(System.getProperty("user.dir"));
		OpenBrowserAndNavigate o = new OpenBrowserAndNavigate();
		WebDriver driver = o.trigger();
//		TakeImage ti = new TakeImage();
//		ti.scrollElement();

		ScreenshotCapture sc = new ScreenshotCapture();
		sc.takeScreenShot(ScrollAndCaptureImage.class, driver.findElements(By.xpath("//*[@class='hljs xml']")).get(0));
	}
}

class TakeImage extends browser
{
	public void scrollElement() throws IOException, InterruptedException
	{
		JavascriptExecutor je = (JavascriptExecutor) driver;
		long scrollheight = (long) je.executeScript("return document.scrollingElement.scrollHeight;");
		long windowHeight = (long) je.executeScript("return document.scrollingElement.clientHeight;");
		List<BufferedImage> images = new ArrayList<BufferedImage>();
		int widthOfImage = 0;

		while (windowHeight <= scrollheight)
		{
			File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			BufferedImage img = ImageIO.read(screen);
			widthOfImage = img.getWidth();
			images.add(img);

			windowHeight = windowHeight + windowHeight;
			je.executeScript("document.scrollingElement.scroll(0," + windowHeight + ");");
			System.out.println("Scrolled " + windowHeight);
			Thread.sleep(1000);

		}

		int heightTotal = 0;
		for (int j = 0; j < images.size(); j++)
		{
			heightTotal += images.get(j).getHeight();

		}

		int heightCurr = 0;
		BufferedImage concatImage = new BufferedImage(widthOfImage, heightTotal, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = concatImage.createGraphics();
		for (int j = 0; j < images.size(); j++)
		{
			g2d.drawImage(images.get(j), 0, heightCurr, null);
			heightCurr += images.get(j).getHeight();
		}
		g2d.dispose();

		ImageIO.write(concatImage, "png", new File("./screenShots/test.png"));
	}
}

class OpenBrowserAndNavigate extends browser
{
	public WebDriver trigger()
	{
		selectBrowserToExecute("chrome");
		driver.get("https://www.sitepoint.com/community/t/div-inside-table-any-solution/2999");
		driver.manage().window().maximize();
		return driver;
	}
}