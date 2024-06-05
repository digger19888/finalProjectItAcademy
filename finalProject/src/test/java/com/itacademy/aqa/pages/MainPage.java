package com.itacademy.aqa.pages;

import com.itacademy.aqa.core.BasePage;
import io.qameta.allure.Allure;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {
    private Logger logger = Logger.getLogger(LogInPage.class);
    @FindBy(xpath = "//div[@class='wp-menu-image dashicons-before dashicons-admin-post']")
    public WebElement posts;
    @FindBy(xpath = "//div[@class='wp-menu-name'][contains(text(), 'Media')]")
    public WebElement media;
    @FindBy(xpath = "//div[@class='wp-menu-image dashicons-before dashicons-admin-page']")
    public WebElement pages;
    @FindBy(xpath = "//div[@class='wp-menu-image dashicons-before dashicons-admin-comments']")
    public WebElement comments;
    @FindBy(xpath = "//div[@class='wp-menu-name'][contains(text(), 'Users')]")
    public WebElement users;

    public MainPage() {
        PageFactory.initElements(driver, this);
        logger.trace("Init elements of the page");
    }

    public void switchToUsersPage() {
        logger.info("Opening page");
        Allure.attachment("MainPage", "Opening page");
        users.click();
        logger.error("element was not found");
    }

    public void switchToPostsPage() {
        logger.info("Opening page");
        Allure.attachment("PostsPage", "Opening page");
        posts.click();
        logger.error("element was not found");
    }

    public void switchToCommentsPage() {
        logger.info("Opening page");
        Allure.attachment("CommentsPage", "Opening page");
        comments.click();
        logger.error("element was not found");
    }

    public void switchToPagesPage() {
        logger.info("Opening page");
        Allure.attachment("PagesPage", "Opening page");
        pages.click();
        logger.error("element was not found");
    }
}
