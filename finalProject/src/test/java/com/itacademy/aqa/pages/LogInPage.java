package com.itacademy.aqa.pages;

import com.itacademy.aqa.configuration.Configuration;
import com.itacademy.aqa.core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.System.getProperties;
import static org.testng.util.Strings.valueOf;

public class LogInPage extends BasePage {
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
    }

    public void logInToCms() {
        login.sendKeys(Configuration.getProperties().getProperty("username"));
        password.sendKeys(Configuration.getProperties().getProperty("password"));
        rememberMeCheckbox.click();
        logInButton.click();
    }

}
