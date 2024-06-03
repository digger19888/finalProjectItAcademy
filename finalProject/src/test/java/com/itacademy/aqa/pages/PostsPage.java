package com.itacademy.aqa.pages;

import com.itacademy.aqa.core.BasePage;
import com.itacademy.aqa.utils.WaitUtil;
import io.qameta.allure.Allure;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PostsPage extends BasePage {
    public static final String NEW_POST_TITLE = "FAKE POST";
    private static final String POSTS_TABLE_TITLE_ELEMENT = "//*[@class='row-title']";
    private Logger logger = Logger.getLogger(LogInPage.class);
    @FindBy(xpath = "//*[@class='page-title-action']")
    public WebElement addNewButton;
    @FindBy(xpath = "//button[normalize-space()='Publish']")
    public WebElement publishButton;
    @FindBy(xpath = "//a[@aria-label='View Posts']")
    public WebElement viewPostsButton;
    @FindBy(name = "editor-canvas")
    public WebElement frame;
    @FindBy(xpath = "//h1[@aria-label= 'Add title']")
    public WebElement addTitleField;
    @FindBy(xpath = "//div[@class='components-snackbar__content']")
    public WebElement informationPopup;
    @FindBy(xpath = "//*[@class='row-title']")
    public WebElement table;
    @FindBy(xpath = "//a[@class='wp-first-item current']")
    public WebElement tabAllPosts;
    @FindBy(xpath = "//a[@href='post-new.php']")
    public WebElement tabAddNew;
    @FindBy(xpath = "//a[normalize-space()='Categories']")
    public WebElement tabCategories;
    @FindBy(xpath = "//a[normalize-space()='Tags']")
    public WebElement tabTags;

    public PostsPage() {
        PageFactory.initElements(driver, this);
        logger.trace("Init elements of the page");
    }

    public List<WebElement> getPostsList() {
        logger.info("Opening page");
        Allure.attachment("PostsPage", "Opening page");
        addNewButton.click();
        driver.switchTo().frame(frame);
        addTitleField.click();
        addTitleField.sendKeys(NEW_POST_TITLE);
        logger.error("element was not found");
        driver.switchTo().defaultContent();
        publishButton.click();
        WaitUtil.waitUntilElementVisible(informationPopup,30);
        viewPostsButton.click();
        logger.error("element was not found");
        WaitUtil.waitUntilElementVisible(table,30);
        return driver.findElements(By.xpath(POSTS_TABLE_TITLE_ELEMENT));
    }

}
