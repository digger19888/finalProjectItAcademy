package com.itacademy.aqa.utils;

import com.itacademy.aqa.webDriver.Browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {
    public static void waitUntilElementVisible(WebElement webElement, long timeoutInSeconds) {

        WebDriverWait wait = new WebDriverWait(Browser.getDriver(), timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }
    public static void waitUntilElementNotVisible(WebElement webElement, long timeoutInSeconds) {

        WebDriverWait wait = new WebDriverWait(Browser.getDriver(), timeoutInSeconds);
        wait.until(ExpectedConditions.invisibilityOf(webElement));
    }
}
