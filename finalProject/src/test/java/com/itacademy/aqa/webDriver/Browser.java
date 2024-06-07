package com.itacademy.aqa.webDriver;

import com.itacademy.aqa.configuration.Configuration;
import com.itacademy.aqa.core.BasePage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Browser {
    private static WebDriver driver;

    private Browser() {
    }

    public static void initDriver() {
        driver = BrowserFactory.createDriver(Configuration.getBrowserType());
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        BasePage.setDriver(driver);

    }

    public static WebDriver getDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    public static void close() {
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }

    public static void takeScreenShot() {

        File screenShots = new File(Configuration.getScreenShotFolder());

        if (!screenShots.exists()) {
            screenShots.mkdirs();
        }
        Date date = new Date();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy-h-mm-ss-SS--a");
        String formattedDate = simpleDateFormat.format(date);

        String fileName = Configuration.getBrowserType() + "_" + formattedDate + "_screenshot.png";

        byte[] srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);

        try {
            Files.write(new File(Configuration.getScreenShotFolder() + fileName).toPath(), srcFile, StandardOpenOption.CREATE);
        } catch (IOException ex) {
            System.out.println("Can't save a file + " + fileName);
        }
    }
}
