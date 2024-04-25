package com.itacademy.aqa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {
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

}
