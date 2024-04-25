package com.itacademy.aqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UsersPage {
    @FindBy(xpath = "//*[@class='page-title-action']")
    public WebElement buttonAddNew;
    @FindBy(xpath = "//*[@class='wp-first-item current'][contains(text(), 'All Users')]")
    public WebElement tabAllUsers;
    @FindBy(xpath = "//a[@href='user-new.php']")
    public WebElement tabAddNew;
    @FindBy(xpath = "//a[normalize-space()='Profile']")
    public WebElement tabProfile;
    private static final By POSTS_TABLE_USERNAME_ELEMENT = By.xpath("//*[@class='username column-username has-row-actions column-primary']");
    private static final By POSTS_TABLE_NAME_ELEMENT = By.xpath("//*[@class='name column-name']");
    private static final By POSTS_TABLE_EMAIL_ELEMENT = By.xpath("//*[@class='email column-email']");
    private static final By POSTS_TABLE_ROLE_ELEMENT = By.xpath("role column-role']");

}
