package src.main.java.com.linkedin.commomUtil;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.linkedin.Browser.browser;

public class ScreenshotCapture extends browser {

	private static Logger log = LogManager.getLogger(ScreenshotCapture.class.getName());

	public void takeScreenShotofCurrentpage() throws IOException {

		try {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("./screenShots/" + System.currentTimeMillis() + ".png"));
			log.info("ScreenShot is Captured");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @param pageName - Page name where the element is located
	 * @param element  - Element to capture
	 * @throws IOException
	 */
	public void takeScreenShot(Class<?> pageName, WebElement element) throws IOException {
		BufferedImage finalImage = captureFullScreenShot(scrollTheElement(element));
		ImageIO.write(finalImage, "png", new File("./screenShots/" + pageName.getName() + ".png"));
	}

	/**
	 * @param pageName - Page name where the element is located
	 * @param element  - Element to capture
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void takeScreenShot(Class<?> pageName) throws IOException, InterruptedException {
		BufferedImage finalImage = captureFullScreenShot(scrollThePage());
		ImageIO.write(finalImage, "png", new File("./screenShots/" + pageName.getName() + ".png"));
	}

	public void getIntoTheView(WebElement element) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("return arguments[0].scrollIntoView;", element);
	}

	/**
	 * @param element
	 * @return - total scrollHeight of the element
	 */
	private long getScrollHeightOfElement(WebElement element) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		long scrollheight = (long) je.executeScript("return arguments[0].scrollHeight;", element);
		return scrollheight;

	}

	/**
	 * @param element
	 * @return - visible height in window of the element
	 */
	private long getClientHeightOfElement(WebElement element) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		long clientHeight = (long) je.executeScript("return arguments[0].clientHeight;", element);
		return clientHeight;
	}

	private void scroll(WebElement element, long from, long to) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scroll(" + from + "," + to + ");", element);
	}

	/**
	 * @param element - WebElement to scroll
	 * @return - List of BufferedImage object during the scrolling
	 * @throws IOException
	 */
	public List<BufferedImage> scrollTheElement(WebElement element) throws IOException {
		List<BufferedImage> images = new ArrayList<BufferedImage>();
		getIntoTheView(element);
		long totalScrollableHeight = getScrollHeightOfElement(element);
		long visibleHeightInWindow = getClientHeightOfElement(element);
		long toScroll = 0;
		while (toScroll <= totalScrollableHeight) {
			// Capturing screenshot
			File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			BufferedImage img = ImageIO.read(screen);
			images.add(img);
			// Scrolling
			long fromScroll = toScroll;
			toScroll += visibleHeightInWindow;
			scroll(element, fromScroll, toScroll);
		}
		return images;

	}

	/**
	 * @param images - should take input of the BufferedImage list during the scroll
	 * @return - single BufferedImage object by concatenating all BufferedImages
	 */
	private BufferedImage captureFullScreenShot(List<BufferedImage> images) {
		int widthOfImage = 0;
		int heightTotal = 0;
		for (int j = 0; j < images.size(); j++) {
			heightTotal += images.get(j).getHeight();
			widthOfImage = images.get(j).getWidth();
		}

		int heightCurr = 0;
		BufferedImage concatImage = new BufferedImage(widthOfImage, heightTotal, BufferedImage.TYPE_INT_RGB);

		Graphics2D g2d = concatImage.createGraphics();
		for (int j = 0; j < images.size(); j++) {
			g2d.drawImage(images.get(j), 0, heightCurr, null);
			heightCurr += images.get(j).getHeight();
		}
		g2d.dispose();

		return concatImage;
	}

	private List<BufferedImage> scrollThePage() throws IOException, InterruptedException {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		long scrollheight = (long) je.executeScript("return document.scrollingElement.scrollHeight;");
		long windowHeight = (long) je.executeScript("return document.scrollingElement.clientHeight;");
		List<BufferedImage> images = new ArrayList<BufferedImage>();
		long toScroll = 0;

		while (!(toScroll >= scrollheight)) {
			File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			BufferedImage img = ImageIO.read(screen);
			images.add(img);
			
			long fromScroll=toScroll;
			toScroll = toScroll + windowHeight;
			je.executeScript("document.scrollingElement.scroll("+fromScroll+"," + toScroll + ");");
			Thread.sleep(1000);
		}
		return images;
	}
}
