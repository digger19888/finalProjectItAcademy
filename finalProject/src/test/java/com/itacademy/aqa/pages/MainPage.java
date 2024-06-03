package com.itacademy.aqa.pages;

import com.itacademy.aqa.core.BasePage;
import io.qameta.allure.Allure;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {
    private Logger logger = Logger.getLogger(LogInPage.class);
    @FindBy(xpath = "//div[@class='wp-menu-name'][contains(text(), 'Posts')]")
    public WebElement posts;
    @FindBy(xpath = "//div[@class='wp-menu-name'][contains(text(), 'Media')]")
    public WebElement media;
    @FindBy(xpath = "//div[@class='wp-menu-name'][contains(text(), 'Pages')]")
    public WebElement pages;
    @FindBy(xpath = "//div[@class='wp-menu-name'][contains(text(), 'Comments')]")
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
}
