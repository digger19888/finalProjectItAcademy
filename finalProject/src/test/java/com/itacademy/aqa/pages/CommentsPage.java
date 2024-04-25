package com.itacademy.aqa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommentsPage {
    @FindBy(xpath = "//*[@class='author column-author']")
    public WebElement authorTableElement;
    @FindBy(xpath = "//*[@class='comment column-comment has-row-actions column-primary']")
    public WebElement commentTableElement;
}
