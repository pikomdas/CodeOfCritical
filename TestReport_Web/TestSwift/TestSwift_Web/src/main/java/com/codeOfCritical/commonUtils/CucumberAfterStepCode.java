package com.codeOfCritical.commonUtils;

import com.codeOfCritical.CucumberExtentReport.Reporter;
import com.codeOfCritical.BaseClass.Browser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CucumberAfterStepCode extends Browser
{

    private static final Logger Log = LogManager.getLogger(CucumberAfterStepCode.class.getName());
    private WebElement element;
    /**
     * Each thread or scenario will create a List to Store screenshots
     */
    public static ThreadLocal<List<String>> screenShots = new ThreadLocal<>()
    {
        @Override
        protected List<String> initialValue()
        {
            return new ArrayList<String>();
        }
    };

    public CucumberAfterStepCode()
    {
        WebDriver driver = driverThread.get();
        // if browser closed, need not to take screen shot
        if (driver != null)
        {
            //driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(300, TimeUnit.SECONDS);
            try
            {
                Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
                        .takeScreenshot(driver);
                File destinationPath = new File(
                        getProperty.readScreenshotLocation("stepImageLocation") + screenshotFolderName + File.separator
                                + String.join("_", LocalDateTime.now().toString().split("[^A-Za-z0-9]")) + ".png");
                ImageIO.write(screenshot.getImage(), "PNG", destinationPath);
                Reporter.addScreenCaptureFromPath(destinationPath.getAbsolutePath());
                screenShots.get().add(destinationPath.getAbsolutePath());
            }
            catch (IOException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
