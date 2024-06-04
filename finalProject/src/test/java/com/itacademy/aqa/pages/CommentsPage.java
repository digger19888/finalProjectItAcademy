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

public class CommentsPage extends BasePage {
    private static final String COMMENTS_ELEMENT = "//*[@class='comment column-comment has-row-actions column-primary']";
    private Logger logger = Logger.getLogger(LogInPage.class);
    @FindBy(xpath = "//*[@class='author column-author']")
    public WebElement authorTableElement;
    @FindBy(xpath = "//*[@class='comment column-comment has-row-actions column-primary']")
    public WebElement table;
    @FindBy(xpath = "//div[@class='wp-menu-image dashicons-before dashicons-admin-comments']")
    public WebElement comments;

    public CommentsPage() {
        PageFactory.initElements(driver, this);
        logger.trace("Init elements of the page");
    }

    public List<WebElement> getCommentsList() {
        logger.info("Opening page");
        Allure.attachment("CommentsPage", "Opening page");
        comments.click();
        WaitUtil.waitUntilElementVisible(table, 30);
        return driver.findElements(By.xpath(COMMENTS_ELEMENT));
    }


}
