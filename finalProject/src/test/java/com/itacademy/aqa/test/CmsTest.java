package com.itacademy.aqa.test;

import com.itacademy.aqa.core.BaseTest;
import com.itacademy.aqa.pages.LogInPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CmsTest extends BaseTest {
    @Test
    public void checkLogInToCms() {
        LogInPage logInPage = new LogInPage();
        logInPage.logInToCms();
        Assert.assertEquals(driver.getCurrentUrl(), LogInPage.CMS_URL);
    }
}
