package com.itacademy.aqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PostsPage {

    @FindBy(xpath = "//*[@class='page-title-action']")
    public WebElement buttonAddNew;
    @FindBy(xpath = "//a[@class='wp-first-item current']")
    public WebElement tabAllPosts;
    @FindBy(xpath = "//a[@href='post-new.php']")
    public WebElement tabAddNew;
    @FindBy(xpath = "//a[normalize-space()='Categories']")
    public WebElement tabCategories;
    @FindBy(xpath = "//a[normalize-space()='Tags']")
    public WebElement tabTags;

    private static final By POSTS_TABLE_TITLE_ELEMENT = By.xpath("//*[@class='row-title']");
    private static final By POSTS_TABLE_AUTHOR_ELEMENT = By.xpath("//*[@class='author column-author']");
    private static final By POSTS_TABLE_CATEGORIES_ELEMENT = By.xpath("//*[@class='categories column-categories']");



}
