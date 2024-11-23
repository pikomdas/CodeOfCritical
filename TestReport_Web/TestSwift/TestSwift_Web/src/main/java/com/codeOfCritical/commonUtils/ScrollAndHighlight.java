/*
 * /////////////////// \\\\\\\\\\\\\\\\\\
 * WWW.TECHMAHINDRA.COM PRIVACY POLICY © 2012
 * ScrollAndHighlight.java belongs to AssetVantage
 * Do not COPY or PASTE code to WEB from TemenosT24
 * Creation date-time : 25-Apr-2019 12:18:55 PM
 * /////////////////// \\\\\\\\\\\\\\\\\\
 */
package com.codeOfCritical.commonUtils;

import com.codeOfCritical.BaseClass.Browser;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * @author partha.das
 */
public class ScrollAndHighlight extends Browser
{
    
    public ScrollAndHighlight(List<WebElement> element)
    {
       /* WebDriver driver = driverThread.get();
        element.stream().parallel().forEach(e ->
        {
            Actions actions = new Actions(driver);
            actions.moveToElement(e);
            actions.perform();
            // Adding highlight to element
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].setAttribute('style', 'background: yellow; border: 0.2px solidred;');", e);
            // Removing highlight from element
            ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', 'background: none');", e);
            
        });*/
        
    }
    
    public ScrollAndHighlight(WebElement element)
    {
       /* WebDriver driver = driverThread.get();
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
        // Adding highlight to element
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].setAttribute('style', 'background: #FFFF00; border: 0.2px solid #000000;');", element);
        // Remove highlight
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', 'background: none');", element);*/
        
    }
    
    @Deprecated
    public static void highlightRed(String poistionName, String columnValue)
    {
        /*WebDriver driver = driverThread.get();
        WebElement baseElement = driver
                .findElement(By.xpath("//*[contains(text(),'" + poistionName + "')]/parent::td/parent::tr"));
        List<WebElement> element1 = baseElement.findElements(By.xpath("td"));
        for (WebElement element : element1)
        {
            if (element.getText().contains(columnValue))
            {
                Actions actions = new Actions(driver);
                actions.moveToElement(element);
                actions.perform();
                ((JavascriptExecutor) driver).executeScript(
                        "arguments[0].setAttribute('style', 'background: Red; border: 2px solid red;');", element);
                break;
            }
        }*/
    }
    
    public void highlightRedForASingleRow(List<WebElement> element1)
    {
        /*WebDriver driver = driverThread.get();
        element1.stream().parallel().filter(x -> x != null).forEach(x -> {
            Actions actions = new Actions(driver);
            actions.moveToElement(x);
            actions.perform();
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].setAttribute('style', 'background: Red; border: 2px solid red;');", x);
        });*/
    }
}
