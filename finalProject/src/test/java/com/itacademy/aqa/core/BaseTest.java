package com.itacademy.aqa.core;

import com.itacademy.aqa.pages.LogInPage;
import com.itacademy.aqa.webDriver.Browser;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;
    protected Logger logger = Logger.getLogger(LogInPage.class);

    @BeforeMethod
    public void driverInitialize() {
        driver = Browser.getDriver();
    }

    @AfterMethod
    public void tearDown() {
        Browser.close();
    }
}
