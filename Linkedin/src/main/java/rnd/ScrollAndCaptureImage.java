/**
 * 
 */
package rnd;

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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.linkedin.Browser.browser;

/**
 * @author partha.das
 *
 */
public class ScrollAndCaptureImage
{
	public static void main(String[] args) throws IOException, InterruptedException
	{
		OpenBrowserAndNavigate o = new OpenBrowserAndNavigate();
		o.trigger();
		TakeImage ti = new TakeImage();
		ti.scrollElement();
	}
}

class TakeImage extends browser
{
	public void scrollElement() throws IOException, InterruptedException
	{
		JavascriptExecutor je = (JavascriptExecutor) driver;
		long scrollheight = (long) je.executeScript("return document.scrollingElement.scrollHeight;");
		long windowHeight = (long) je.executeScript("return document.scrollingElement.clientHeight;");
		List<byte[]> imageAll = new ArrayList<byte[]>();
		while (windowHeight <= scrollheight)
		{
			windowHeight = windowHeight + windowHeight;
			je.executeScript("document.scrollingElement.scroll(0," + scrollheight + ");");
			System.out.println("Scrolled " + windowHeight);
			Thread.sleep(3000);
			byte[] image = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			imageAll.add(image);
		}
		
		byte[] x = imageAll.stream().collect(() -> new ByteArrayOutputStream(), (b, e) ->
		{
			try
			{
				b.write(e);
			} catch (IOException e1)
			{
				throw new RuntimeException(e1);
			}
		}, (a, b) ->
		{
		}).toByteArray();
		InputStream in = new ByteArrayInputStream(x);
		BufferedImage finalImage = ImageIO.read(in);

		ImageIO.write(finalImage, "png", new File("./screenShots/test.png"));
	}
}

class OpenBrowserAndNavigate extends browser
{
	public WebDriver trigger()
	{
		selectBrowserToExecute("chrome");
		driver.get("https://assetvantage.com");
		driver.manage().window().maximize();
		return driver;
	}
}