package com.itacademy.aqa.test;

import com.itacademy.aqa.core.BaseTest;
import com.itacademy.aqa.pages.*;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

import static com.itacademy.aqa.pages.PagesPage.EDIT_PAGE_TITLE;
import static com.itacademy.aqa.pages.PagesPage.NEW_PAGE_TITLE;
import static com.itacademy.aqa.pages.PostsPage.*;
import static com.itacademy.aqa.pages.UsersPage.*;

public class CmsTest extends BaseTest {
    private Logger logger = Logger.getLogger(this.getClass());
    MainPage mainPage;
    LogInPage logInPage;
    PostsPage postsPage;
    CommentsPage commentsPage;
    UsersPage usersPage;
    PagesPage pagesPage;

    @BeforeMethod
    public void setUp() {
        mainPage = new MainPage();
        logInPage = new LogInPage();
        postsPage = new PostsPage();
        commentsPage = new CommentsPage();
        usersPage = new UsersPage();
        pagesPage = new PagesPage();
    }

    @Test(groups = {"smoke", "regression"}, priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    public void checkLogIntoCmsWithAdminCredentials() {
        logger.info("Starting new test case");
        logInPage.logInToCms();
        Assert.assertEquals(driver.getCurrentUrl(), LogInPage.CMS_URL);
        logger.info("Test case finished");
    }

    @Test(groups = {"smoke", "regression"}, priority = 1)
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
        Assert.assertTrue(result, "User with name: " + NEW_USER_NAME + " does not exist");
        logger.info("Test case finished");
    }

    @Test(groups = "regression", priority = 2)
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
        Assert.assertTrue(result, "User with email: " + EDIT_USER_EMAIL + " does not exist");
        logger.info("Test case finished");
    }

    @Test(groups = {"smoke", "regression"}, priority = 5)
    @Severity(SeverityLevel.CRITICAL)
    public void testDeleteUser() {
        boolean result = false;
        logger.info("Starting new test case");
        logInPage.logInToCms();
        mainPage.switchToUsersPage();
        List<WebElement> users = usersPage.getDeleteUsersList();
        int itemsListLength = users.size();
        for (int i = 0; i < itemsListLength - 1; i++) {
            if (users.get(i).getText().contains(NEW_USER_NAME)) {
                result = true;
                break;
            }
        }
        Assert.assertFalse(result, "User with name: " + NEW_USER_NAME + " exists");
        logger.info("Test case finished");
    }

    @Test(groups = {"smoke", "regression"}, priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    public void testAddNewPost() {
        boolean result = false;
        logger.info("Starting new test case");
        logInPage.logInToCms();
        mainPage.switchToPostsPage();
        List<WebElement> posts = postsPage.getPostsList();
        int itemsListLength = posts.size();
        for (int i = 0; i < itemsListLength - 1; i++) {
            if (posts.get(i).getText().contains(NEW_POST_TITLE)) {
                result = true;
                break;
            }
        }
        Assert.assertTrue(result, "Post with title: " + NEW_POST_TITLE + " does not exist");
        logger.info("Test case finished");
    }

    @Test(groups = "regression", priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    public void testEditPost() {
        boolean result = false;
        logger.info("Starting new test case");
        logInPage.logInToCms();
        mainPage.switchToPostsPage();
        List<WebElement> posts = postsPage.getEditPostsList();
        int itemsListLength = posts.size();
        for (int i = 0; i < itemsListLength - 1; i++) {
            if (posts.get(i).getText().contains(EDIT_POST_TITLE)) {
                result = true;
                break;
            }
        }
        Assert.assertTrue(result, "Post with title: " + EDIT_POST_TITLE + " does not exist");
        logger.info("Test case finished");
    }

    @Test(groups = "regression", priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    public void testAddNewComment() {
        boolean result = false;
        logger.info("Starting new test case");
        logInPage.logInToCms();
        mainPage.switchToPostsPage();
        postsPage.addNewComment();
        List<WebElement> comments = commentsPage.getCommentsList();
        int itemsListLength = comments.size();
        for (int i = 0; i < itemsListLength - 1; i++) {
            if (comments.get(i).getText().contains(FAKE_COMMENT)) {
                result = true;
                break;
            }
        }
        Assert.assertTrue(result, "Comment with text: " + FAKE_COMMENT + " does not exist");
        logger.info("Test case finished");
    }

    @Test(groups = "regression", priority = 4)
    @Severity(SeverityLevel.CRITICAL)
    public void testDeleteComment() {
        boolean result = false;
        logger.info("Starting new test case");
        logInPage.logInToCms();
        mainPage.switchToCommentsPage();
        List<WebElement> comments = commentsPage.getDeletedCommentsList();
        int itemsListLength = comments.size();
        for (int i = 0; i < itemsListLength - 1; i++) {
            if (comments.get(i).getText().contains(FAKE_COMMENT)) {
                result = true;
                break;
            }
        }
        Assert.assertFalse(result, "Comment with text: " + FAKE_COMMENT + " exists");
        logger.info("Test case finished");
    }

    @Test(groups = {"smoke", "regression"}, priority = 5)
    @Severity(SeverityLevel.CRITICAL)
    public void testDeletePost() {
        boolean result = false;
        logger.info("Starting new test case");
        logInPage.logInToCms();
        mainPage.switchToPostsPage();
        List<WebElement> posts = postsPage.getDeletePostList();
        int itemsListLength = posts.size();
        for (int i = 0; i < itemsListLength - 1; i++) {
            if (posts.get(i).getText().contains(EDIT_POST_TITLE)) {
                result = true;
                break;
            }
        }
        Assert.assertFalse(result, "Post with title: " + EDIT_POST_TITLE + " exists");
        logger.info("Test case finished");
    }

    @Test(groups = {"smoke", "regression"}, priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    public void testAddNewPage() {
        boolean result = false;
        logger.info("Starting new test case");
        logInPage.logInToCms();
        mainPage.switchToPagesPage();
        List<WebElement> pages = pagesPage.getPagesList();
        int itemsListLength = pages.size();
        for (int i = 0; i < itemsListLength - 1; i++) {
            if (pages.get(i).getText().contains(NEW_PAGE_TITLE)) {
                result = true;
                break;
            }
        }
        Assert.assertTrue(result, "Page with title: " + NEW_PAGE_TITLE + " does not exist");
        logger.info("Test case finished");
    }

    @Test(groups = "regression", priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    public void testEditPage() {
        boolean result = false;
        logger.info("Starting new test case");
        logInPage.logInToCms();
        mainPage.switchToPagesPage();
        List<WebElement> pages = pagesPage.getEditPagesList();
        int itemsListLength = pages.size();
        for (int i = 0; i < itemsListLength - 1; i++) {
            if (pages.get(i).getText().contains(EDIT_PAGE_TITLE)) {
                result = true;
                break;
            }
        }
        Assert.assertTrue(result, "Post with title: " + EDIT_PAGE_TITLE + " does not exist");
        logger.info("Test case finished");
    }

    @Test(groups = {"smoke", "regression"}, priority = 5)
    @Severity(SeverityLevel.CRITICAL)
    public void testDeletePage() {
        boolean result = false;
        logger.info("Starting new test case");
        logInPage.logInToCms();
        mainPage.switchToPagesPage();
        List<WebElement> pages = pagesPage.getDeletePagesList();
        int itemsListLength = pages.size();
        for (int i = 0; i < itemsListLength - 1; i++) {
            if (pages.get(i).getText().contains(EDIT_PAGE_TITLE)) {
                result = true;
                break;
            }
        }
        Assert.assertFalse(result, "Page with title: " + EDIT_PAGE_TITLE + " exists");
        logger.info("Test case finished");
    }

    @Test(groups = "regression", priority = 4)
    @Severity(SeverityLevel.CRITICAL)
    public void testLogInToCmsWithSubscriberCredentials() {
        logger.info("Starting new test case");
        logInPage.logInToCms();
        mainPage.switchToUsersPage();
        String userPassword = usersPage.addUserWithSubscriberRole();
        logInPage.logInToCmsWithSubscriberRole(NEW_SUBSCRUSER_NAME, userPassword);
        Assert.assertEquals(driver.getCurrentUrl(), LogInPage.SUBSCRIBER_PROFILE);
        logger.info("Test case finished");
    }

    @Test(groups = "regression", priority = 5)
    @Severity(SeverityLevel.CRITICAL)
    public void testDeleteUserWithSubscriberRole() {
        boolean result = false;
        logger.info("Starting new test case");
        logInPage.logInToCms();
        mainPage.switchToUsersPage();
        List<WebElement> users = usersPage.getDeleteSubscriberUsersList();
        int itemsListLength = users.size();
        for (int i = 0; i < itemsListLength - 1; i++) {
            if (users.get(i).getText().contains(NEW_SUBSCRUSER_NAME)) {
                result = true;
                break;
            }
        }
        Assert.assertFalse(result, "User with name: " + NEW_SUBSCRUSER_NAME + " exists");
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
