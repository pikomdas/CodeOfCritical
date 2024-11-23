package com.codeOfCritical.test;

import com.codeOfCritical.BaseClass.Browser;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeOfCritical.test.RnD.writeFile;

public class DemoThreads extends Browser {


    @Test
    public void test() throws InterruptedException {
        Runnable br1 = () -> {
            WebDriver driver = null;

            try {
                synchronized (this) {
                    driver = startBrowser("Chrome");
                    wait();
                }
                driver.get("http://makemytrip.com");
                List<WebElement> links = driver.findElements(By.tagName("a"));
                String x = links.stream()
                        .map(ele -> ele.getAttribute("href"))
                        .collect(Collectors.joining("\n", "[", "]"));
                System.out.println(x);
                writeFile(x);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            } finally {
                driver.quit();
            }

        };

        Runnable br2 = () -> {
            WebDriver driver = null;
            try {
                synchronized (this) {
                    driver = startBrowser("Chrome");
                    notify();
                }
                driver.get("http://irctc.co.in");
                List<WebElement> links = driver.findElements(By.tagName("a"));
                String y = links.stream()
                        .map(ele -> ele.getAttribute("href"))
                        .collect(Collectors.joining("\n", "[", "]"));
                System.out.println(y);
                writeFile(y);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                driver.quit();
            }

        };

        Thread t1 = new Thread(br1);
        Thread t2 = new Thread(br2);

        t1.start();
        t2.start();

        t2.join();
        t1.join();

    }
}