package com.itacademy.aqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MediaPage {
    @FindBy(xpath = "//*[@class='page-title-action']")
    public WebElement buttonAddNew;
    @FindBy(xpath = "//a[@class='wp-first-item current']")
    public WebElement tabLibrary;
    @FindBy(xpath = "//a[@href='media-new.php']")
    public WebElement tabAddNew;
    private static final By MEDIA_TABLE_FILE_ELEMENT = By.xpath("//*[@class='media-icon image-icon']");
    private static final By MEDIA_TABLE_AUTHOR_ELEMENT = By.xpath("//*[@class='author column-author']");


}
