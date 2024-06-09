package com.itacademy.aqa.pages;

import com.itacademy.aqa.core.BasePage;
import com.itacademy.aqa.utils.WaitUtil;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UsersPage extends BasePage {
    private static final String TABLE_USERNAME_ELEMENT = "//*[@class='username column-username has-row-actions column-primary']";
    private static final String TABLE_EMAIL_ELEMENT = "//*[@class='email column-email']";
    public static final String NEW_USER_NAME = "FAKE USER";
    private static final String NEW_USER_EMAIL = "fakeuser@mail.ru";
    public static final String NEW_SUBSCRUSER_NAME = "FAKE SUBSCRUSER";
    private static final String NEW_SUBSCRUSER_EMAIL = "fakesubscruser@mail.ru";
    public static final String EDIT_USER_EMAIL = "testfakeuser@mail.ru";
    @FindBy(xpath = "//*[@class='page-title-action']")
    public WebElement addNewButton;
    @FindBy(xpath = "//input[@id='createusersub']")
    public WebElement addNewUserButton;
    @FindBy(xpath = "//input[@id='submit']")
    public WebElement updateUserButton;
    @FindBy(xpath = "//input[@id='user_login']")
    public WebElement userNameField;
    @FindBy(xpath = "//input[@id='email']")
    public WebElement userEmailField;
    @FindBy(xpath = "//a[normalize-space()='FAKE USER']")
    public WebElement userNameElement;
    @FindBy(xpath = "//a[normalize-space()='FAKE SUBSCRUSER']")
    public WebElement userSubscriberNameElement;
    @FindBy(xpath = "//input[@id='first_name']")
    public WebElement firstNameField;
    @FindBy(xpath = "//*[@class='username column-username has-row-actions column-primary']")
    public WebElement table;
    @FindBy(xpath = "//div[@class='wp-menu-image dashicons-before dashicons-admin-users']")
    public WebElement usersTab;
    @FindBy(xpath = "//a[normalize-space()='FAKE USER']/../following-sibling::div/span[@class='delete']/a")
    public WebElement deleteUserTab;
    @FindBy(xpath = "//a[normalize-space()='FAKE SUBSCRUSER']/../following-sibling::div/span[@class='delete']/a")
    public WebElement deleteSubscrUserTab;
    @FindBy(xpath = "//input[@id='pass1']")
    public WebElement passwordField;
    @FindBy(xpath = "//li[@id='wp-admin-bar-my-account']")
    public WebElement profile;
    @FindBy(xpath = "//a[@class='ab-item'][normalize-space()='Log Out']")
    public WebElement logOutButton;
    @FindBy(xpath = "//input[@id='submit']")
    public WebElement confirmDeletionButton;

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
        WaitUtil.waitUntilElementVisible(table, 30);
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
        logger.error("element was not found");
        updateUserButton.click();
        logger.error("element was not found");
        usersTab.click();
        WaitUtil.waitUntilElementVisible(table, 30);
        return driver.findElements(By.xpath(TABLE_EMAIL_ELEMENT));
    }

    public List<WebElement> getDeleteUsersList() {
        logger.info("Opening page");
        Allure.attachment("UsersPage", "Opening page");
        Actions action = new Actions(driver);
        action.moveToElement(userNameElement).perform();
        deleteUserTab.click();
        logger.error("element was not found");
        confirmDeletionButton.click();
        WaitUtil.waitUntilElementVisible(table, 30);
        return driver.findElements(By.xpath(TABLE_USERNAME_ELEMENT));
    }

    public String addUserWithSubscriberRole() {
        logger.info("Opening page");
        Allure.attachment("UsersPage", "Opening page");
        addNewButton.click();
        logger.error("element was not found");
        userNameField.sendKeys(NEW_SUBSCRUSER_NAME);
        logger.error("element was not found");
        userEmailField.sendKeys(NEW_SUBSCRUSER_EMAIL);
        logger.error("element was not found");
        String password = passwordField.getAttribute("data-pw");
        logger.error("element was not found");
        addNewUserButton.click();
        logger.error("element was not found");
        WaitUtil.waitUntilElementVisible(table, 30);
        Actions action = new Actions(driver);
        action.moveToElement(profile).perform();
        logOutButton.click();
        return password;
    }

    public List<WebElement> getDeleteSubscriberUsersList() {
        logger.info("Opening page");
        Allure.attachment("UsersPage", "Opening page");
        Actions action = new Actions(driver);
        action.moveToElement(userSubscriberNameElement).perform();
        deleteSubscrUserTab.click();
        logger.error("element was not found");
        confirmDeletionButton.click();
        WaitUtil.waitUntilElementVisible(table, 30);
        return driver.findElements(By.xpath(TABLE_USERNAME_ELEMENT));
    }
}
