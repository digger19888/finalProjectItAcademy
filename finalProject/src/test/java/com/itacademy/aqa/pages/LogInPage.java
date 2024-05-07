package com.itacademy.aqa.pages;

import com.itacademy.aqa.configuration.Configuration;
import com.itacademy.aqa.core.BasePage;
import io.qameta.allure.Allure;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage extends BasePage {

    private Logger logger = Logger.getLogger(LogInPage.class);

    private final static String CMS_BASE_URL = "https://wordpress-test-app-for-selenium.azurewebsites.net/wp-admin";
    public final static String CMS_URL = "https://wordpress-test-app-for-selenium.azurewebsites.net/wp-admin/";

    @FindBy(xpath = "//*[@id='user_login']")
    public WebElement login;
    @FindBy(xpath = "//*[@id='user_pass']")
    public WebElement password;

    @FindBy(xpath = "//*[@id='wp-submit']")
    public WebElement logInButton;

    @FindBy(xpath = "//*[@id='rememberme']")
    public WebElement rememberMeCheckbox;

    public LogInPage() {
        driver.get(CMS_BASE_URL);
        PageFactory.initElements(driver, this);
        logger.trace("Init elements of the page");
    }

    public void logInToCms() {
        logger.info("Opening page");
        Allure.attachment("LogInPage", "Opening page");
        login.sendKeys(Configuration.getProperties().getProperty("username"));
        logger.error("element was not found");
        password.sendKeys(Configuration.getProperties().getProperty("password"));
        logger.error("element was not found");
        rememberMeCheckbox.click();
        logInButton.click();

    }

}
