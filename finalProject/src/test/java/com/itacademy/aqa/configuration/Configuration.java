package com.itacademy.aqa.configuration;

import com.itacademy.aqa.webDriver.BrowserType;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
    private static Properties properties;

    public static Properties getProperties() {
        if (properties == null) {
            try {
                properties = new Properties();
                //initialize file based on environment we need
                properties.load(new FileInputStream("project.properties"));
                properties.putAll(System.getenv());
                properties.putAll(System.getProperties());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return properties;
    }

    public static String getSceenShotFolder() {
        return getProperties().getProperty("screenShotFolder");
    }

    public static BrowserType getBrowserType() {
        return BrowserType.valueOf(getProperties().getProperty("browser"));
    }

    public static String getRemoteBrowserUrl() {
        return getProperties().getProperty("remoteBrowserUrl");
    }
}
