package com.itacademy.aqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PagesPage {
    @FindBy(xpath = "//*[@class='page-title-action']")
    public WebElement buttonAddNew;
    @FindBy(xpath = "//a[@class='wp-first-item current']")
    public WebElement tabAllPages;
    @FindBy(xpath = "//a[@href='post-new.php?post_type=page']")
    public WebElement tabAddNew;

    private static final By PAGES_TABLE_TITLE_ELEMENT = By.xpath("//*[@class='row-title']");

    private static final By PAGES_TABLE_AUTHOR_ELEMENT = By.xpath("//*[@class='author column-author']");
}
