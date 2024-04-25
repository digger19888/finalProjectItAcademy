package com.itacademy.aqa.core;

import com.itacademy.aqa.webDriver.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    protected WebDriver driver;

    @BeforeTest
    public void driverInitialize() {
        driver = Browser.getDriver();
    }

    @AfterTest
    public void tearDown() {
        Browser.close();
    }
}
