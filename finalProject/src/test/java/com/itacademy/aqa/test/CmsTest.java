package com.itacademy.aqa.test;

import com.itacademy.aqa.core.BaseTest;
import com.itacademy.aqa.pages.LogInPage;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CmsTest extends BaseTest {
    private Logger logger = Logger.getLogger(this.getClass());
    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void checkLogInToCms() {
        logger.info("Starting new test case");
        LogInPage logInPage = new LogInPage();
        logInPage.logInToCms();
        Assert.assertEquals(driver.getCurrentUrl(), LogInPage.CMS_URL);
        logger.info("Test case finished");
    }
}
