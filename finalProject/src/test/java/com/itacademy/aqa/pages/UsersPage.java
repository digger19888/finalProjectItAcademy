package com.itacademy.aqa.pages;

import com.itacademy.aqa.core.BasePage;
import com.itacademy.aqa.utils.WaitUtil;
import io.qameta.allure.Allure;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UsersPage extends BasePage {
    private Logger logger = Logger.getLogger(LogInPage.class);
    private static final String TABLE_USERNAME_ELEMENT = "//*[@class='username column-username has-row-actions column-primary']";
    private static final String TABLE_EMAIL_ELEMENT = "//td[@class='email column-email']";
    public static final String NEW_USER_NAME = "FAKE USER";
    private static final String NEW_USER_EMAIL = "fakeuser@mail.ru";
    public static final String EDIT_USER_EMAIL = "testfakeuser@mail.ru";
    @FindBy(xpath = "//*[@class='page-title-action']")
    public WebElement addNewButton;
    @FindBy(xpath = "//input[@id='createusersub']")
    public WebElement addNewUserButton;
    @FindBy(xpath = "//input[@id='submit']")
    public WebElement updateUserButton;
    @FindBy(xpath = "//*[@class='wp-first-item current'][contains(text(), 'All Users')]")
    public WebElement tabAllUsers;
    @FindBy(xpath = "//a[@href='user-new.php']")
    public WebElement tabAddNew;
    @FindBy(xpath = "//a[normalize-space()='Profile']")
    public WebElement tabProfile;
    @FindBy(xpath = "//input[@id='user_login']")
    public WebElement userNameField;
    @FindBy(xpath = "//input[@id='email']")
    public WebElement userEmailField;
    @FindBy(xpath = "//a[normalize-space()='FAKE USER']")
    public WebElement userNameElement;
    @FindBy(xpath = "//input[@id='first_name']")
    public WebElement firstNameField;
    @FindBy(xpath = "//*[@class='username column-username has-row-actions column-primary']")
    public WebElement table;
    @FindBy(xpath = "//div[@class='wp-menu-name'][contains(text(), 'Users')]")
    public WebElement usersTab;

    public UsersPage() {
        PageFactory.initElements(driver, this);
        logger.trace("Init elements of the page");
    }

    public List<WebElement> getUsersList() {
        logger.info("Opening page");
        Allure.attachment("UsersPage", "Opening page");
        addNewButton.click();
        logger.error("element was not found");
        userNameField.sendKeys(NEW_USER_NAME);
        logger.error("element was not found");
        userEmailField.sendKeys(NEW_USER_EMAIL);
        logger.error("element was not found");
        addNewUserButton.click();
        logger.error("element was not found");
        WaitUtil.waitUntilElementVisible(table,30);
        return driver.findElements(By.xpath(TABLE_USERNAME_ELEMENT));
    }

    public List<WebElement> getEditUsersList() {
        logger.info("Opening page");
        Allure.attachment("UsersPage", "Opening page");
        userNameElement.click();
        logger.error("element was not found");
        firstNameField.sendKeys(Keys.PAGE_DOWN);
        logger.error("element was not found");
        userEmailField.clear();
        userEmailField.sendKeys(EDIT_USER_EMAIL);
        logger.error("element was not found");
        userEmailField.sendKeys(Keys.PAGE_DOWN);
        updateUserButton.click();
        logger.error("element was not found");
        usersTab.click();
        WaitUtil.waitUntilElementVisible(table,30);
        return driver.findElements(By.xpath(TABLE_EMAIL_ELEMENT));
    }
}
