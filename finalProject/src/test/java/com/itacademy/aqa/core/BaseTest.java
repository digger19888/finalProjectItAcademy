package com.itacademy.aqa.core;

import com.itacademy.aqa.webDriver.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void driverInitialize() {
        driver = Browser.getDriver();
    }

    @AfterMethod
    public void tearDown() {
        Browser.close();
    }
}
