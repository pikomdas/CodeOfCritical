/*
 *  /////////////////// \\\\\\\\\\\\\\\\\\
 *  WWW.TECHMAHINDRA.COM PRIVACY POLICY © 2012
 * ElementOperations.java belongs to AssetVantage
 *  Do not COPY or PASTE code to WEB from ApiTest
 * Creation date-time : 17/04/21, 3:48 AM
 * /////////////////// \\\\\\\\\\\\\\\\\\
 */

package com.codeOfCritical.Interfaces;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public interface ElementOperations
{
    Consumer<WebElement> CLICK_ON = WebElement::click;
    Consumer<WebElement> CLEAR_OUT = WebElement::clear;
    Consumer<WebElement> SUBMIT = WebElement::submit;


    Function<WebElement, String> TEXT_FROM = WebElement::getText;
    Function<WebElement, String> TAG_NAME_FROM = WebElement::getTagName;
    Function<WebElement, Select> DROP_DOWN = (ele) -> new Select(ele);


    BiFunction<WebElement, String, String> FETCH_VALUE_OF = WebElement::getAttribute;
    BiFunction<WebElement, String, WebElement> FIND_ELEMENT = (element, xp) -> element.findElement(By.xpath(xp));
    BiFunction<WebElement, String, List<WebElement>> FIND_ELEMENTS = (element, xp) -> element.findElements(By.xpath(xp));
    BiFunction<WebDriver, String, List<WebElement>> FIND_ELEMENTS_ = (driver, xp) -> driver.findElements(By.xpath(xp));
    BiFunction<WebDriver, String, WebElement> FIND_ELEMENT_ = (driver, xp) -> driver.findElement(By.xpath(xp));


    BiConsumer<WebElement, CharSequence> SEND_KEYS = WebElement::sendKeys;
    BiConsumer<Select, String> SELECT_THE_TEXT = (ele, s) -> ele.selectByVisibleText(s);
    BiConsumer<WebElement, String> SELECT_THE_VALUE = (ele, s) -> DROP_DOWN.apply(ele).selectByValue(s);
    BiConsumer<WebElement, String> SELECT_THE_INDEX = (ele, s) -> DROP_DOWN.apply(ele).selectByIndex(Integer.parseInt(s));
}
