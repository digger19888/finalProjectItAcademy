package com.itacademy.aqa.pages;

import com.itacademy.aqa.core.BasePage;
import com.itacademy.aqa.utils.WaitUtil;
import io.qameta.allure.Allure;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PagesPage extends BasePage {
    public static final String NEW_PAGE_TITLE = "FAKE PAGE";
    public static final String EDIT_PAGE_TITLE = "EDIT FAKE PAGE";
    private static final String PAGES_TABLE_TITLE_ELEMENT = "//*[@class='row-title']";

    private static final By PAGES_TABLE_AUTHOR_ELEMENT = By.xpath("//*[@class='author column-author']");
    private Logger logger = Logger.getLogger(LogInPage.class);
    @FindBy(xpath = "//*[@class='page-title-action']")
    public WebElement addNewButton;
    @FindBy(xpath = "//a[@class='wp-first-item current']")
    public WebElement tabAllPages;
    @FindBy(xpath = "//div[@class='wp-menu-image dashicons-before dashicons-admin-page']")
    public WebElement pages;
    @FindBy(name = "editor-canvas")
    public WebElement frame;
    @FindBy(xpath = "//h1[@aria-label= 'Add title']")
    public WebElement addTitleField;
    @FindBy(xpath = "//div[@class='components-snackbar__content']")
    public WebElement informationPopup;
    @FindBy(xpath = "//button[normalize-space()='Publish']")
    public WebElement publishButton;
    @FindBy(xpath = "//a[@aria-label='View Pages']")
    public WebElement viewPagesButton;
    @FindBy(xpath = "//a[@aria-label='“FAKE PAGE” (Edit)']")
    public WebElement editPagesButton;
    @FindBy(xpath = "//button[normalize-space()='Update']")
    public WebElement updateButton;
    @FindBy(xpath = "//a[@aria-label='“EDIT FAKE PAGE” (Edit)']")
    public WebElement editPageElement;
    @FindBy(xpath = "//a[@aria-label='Move “EDIT FAKE PAGE” to the Trash']")
    public WebElement trashPageButton;
    @FindBy(xpath = "//a[@class='ab-item'][normalize-space()='WordPress on Azure']")
    public WebElement wordpressOnAzureMenu;
    @FindBy(xpath = "//a[normalize-space()='Dashboard']")
    public WebElement dashboard;
    @FindBy(xpath = "//*[@class='row-title']")
    public WebElement table;
    public PagesPage() {
        PageFactory.initElements(driver, this);
        logger.trace("Init elements of the page");
    }

    public List<WebElement> getPagesList() {
        logger.info("Opening page");
        Allure.attachment("PagesPage", "Opening page");
        addNewButton.click();
        driver.switchTo().frame(frame);
        addTitleField.click();
        addTitleField.sendKeys(NEW_PAGE_TITLE);
        logger.error("element was not found");
        driver.switchTo().defaultContent();
        publishButton.click();
        WaitUtil.waitUntilElementVisible(informationPopup, 30);
        viewPagesButton.click();
        logger.error("element was not found");
        WaitUtil.waitUntilElementVisible(table, 30);
        return driver.findElements(By.xpath(PAGES_TABLE_TITLE_ELEMENT));
    }

    public List<WebElement> getEditPagesList() {
        logger.info("Opening page");
        Allure.attachment("PagesPage", "Opening page");
        editPagesButton.click();
        driver.switchTo().frame(frame);
        addTitleField.click();
        addTitleField.clear();
        addTitleField.sendKeys(EDIT_PAGE_TITLE);
        logger.error("element was not found");
        driver.switchTo().defaultContent();
        updateButton.click();
        WaitUtil.waitUntilElementVisible(informationPopup, 30);
        viewPagesButton.click();
        logger.error("element was not found");
        WaitUtil.waitUntilElementVisible(table, 30);
        return driver.findElements(By.xpath(PAGES_TABLE_TITLE_ELEMENT));
    }

    public List<WebElement> getDeletePagesList() {
        Actions action = new Actions(driver);
        action.moveToElement(editPageElement).perform();
        trashPageButton.click();
        logger.error("element was not found");
        Actions menuHover = new Actions(driver);
        menuHover.moveToElement(wordpressOnAzureMenu).perform();
        dashboard.click();
        logger.error("element was not found");
        pages.click();
        logger.error("element was not found");
        WaitUtil.waitUntilElementVisible(table, 30);
        return driver.findElements(By.xpath(PAGES_TABLE_TITLE_ELEMENT));
    }
}
