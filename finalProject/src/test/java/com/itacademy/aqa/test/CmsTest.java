package com.itacademy.aqa.test;

import com.itacademy.aqa.core.BaseTest;
import com.itacademy.aqa.pages.*;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static com.itacademy.aqa.pages.UsersPage.EDIT_USER_EMAIL;
import static com.itacademy.aqa.pages.UsersPage.NEW_USER_NAME;

public class CmsTest extends BaseTest {
    private Logger logger = Logger.getLogger(this.getClass());
    MainPage mainPage;
    LogInPage logInPage;
    PostsPage postsPage;
    CommentsPage commentsPage;
    UsersPage usersPage;
    PagesPage pagesPage;

    @BeforeTest
    public void setUp() {
        mainPage = new MainPage();
        logInPage = new LogInPage();
        postsPage = new PostsPage();
        commentsPage = new CommentsPage();
        usersPage = new UsersPage();
        pagesPage = new PagesPage();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void checkLogIntoCmsWithAdminCredentials() {
        logger.info("Starting new test case");
        logInPage.logInToCms();
        Assert.assertEquals(driver.getCurrentUrl(), LogInPage.CMS_URL);
        logger.info("Test case finished");
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void testAddNewUser() {
        boolean result = false;
        logger.info("Starting new test case");
        logInPage.logInToCms();
        mainPage.switchToUsersPage();
        List<WebElement> users = usersPage.getUsersList();
        int itemsListLength = users.size();
        for (int i = 0; i < itemsListLength - 1; i++) {
            if (users.get(i).getText().contains(NEW_USER_NAME)) {
                result = true;
                break;
            }
        }
        Assert.assertTrue(result, "User with " + NEW_USER_NAME + " does not exist");
        logger.info("Test case finished");
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void testEditUser() {
        boolean result = false;
        logger.info("Starting new test case");
        logInPage.logInToCms();
        mainPage.switchToUsersPage();
        List<WebElement> users = usersPage.getEditUsersList();
        int itemsListLength = users.size();
        for (int i = 0; i < itemsListLength - 1; i++) {
            if (users.get(i).getText().contains(EDIT_USER_EMAIL)) {
                result = true;
                break;
            }
        }
        Assert.assertTrue(result, "User with " + EDIT_USER_EMAIL + " does not exist");
        logger.info("Test case finished");
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void testDeleteUser() {
        logger.info("Starting new test case");
        logInPage.logInToCms();
        Assert.assertEquals(driver.getCurrentUrl(), LogInPage.CMS_URL);
        logger.info("Test case finished");
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void testAddNewPost() {
        logger.info("Starting new test case");
        logInPage.logInToCms();
        Assert.assertEquals(driver.getCurrentUrl(), LogInPage.CMS_URL);
        logger.info("Test case finished");
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void testEditPost() {
        logger.info("Starting new test case");
        logInPage.logInToCms();
        Assert.assertEquals(driver.getCurrentUrl(), LogInPage.CMS_URL);
        logger.info("Test case finished");
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void testAddNewComment() {
        logger.info("Starting new test case");
        logInPage.logInToCms();
        Assert.assertEquals(driver.getCurrentUrl(), LogInPage.CMS_URL);
        logger.info("Test case finished");
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void testDeleteComment() {
        logger.info("Starting new test case");
        logInPage.logInToCms();
        Assert.assertEquals(driver.getCurrentUrl(), LogInPage.CMS_URL);
        logger.info("Test case finished");
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void testDeletePost() {
        logger.info("Starting new test case");
        logInPage.logInToCms();
        Assert.assertEquals(driver.getCurrentUrl(), LogInPage.CMS_URL);
        logger.info("Test case finished");
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void testAddNewPage() {
        logger.info("Starting new test case");
        logInPage.logInToCms();
        Assert.assertEquals(driver.getCurrentUrl(), LogInPage.CMS_URL);
        logger.info("Test case finished");
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void testEditPage() {
        logger.info("Starting new test case");
        logInPage.logInToCms();
        Assert.assertEquals(driver.getCurrentUrl(), LogInPage.CMS_URL);
        logger.info("Test case finished");
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void testDeletePage() {
        logger.info("Starting new test case");
        logInPage.logInToCms();
        Assert.assertEquals(driver.getCurrentUrl(), LogInPage.CMS_URL);
        logger.info("Test case finished");
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void testLogInToCmsWithSubscriberCredentials() {
        logger.info("Starting new test case");
        logInPage.logInToCms();
        Assert.assertEquals(driver.getCurrentUrl(), LogInPage.CMS_URL);
        logger.info("Test case finished");
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void testDeleteUserWithSubscriberRole() {
        logger.info("Starting new test case");
        logInPage.logInToCms();
        Assert.assertEquals(driver.getCurrentUrl(), LogInPage.CMS_URL);
        logger.info("Test case finished");
    }

    @AfterTest
    public void close() {
        mainPage = null;
        logInPage = null;
        postsPage = null;
        commentsPage = null;
        usersPage = null;
        pagesPage = null;
    }
}
