package com.itacademy.aqa.core;

import com.itacademy.aqa.pages.LogInPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected Logger logger = Logger.getLogger(LogInPage.class);
    protected static WebDriver driver;

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }
}
