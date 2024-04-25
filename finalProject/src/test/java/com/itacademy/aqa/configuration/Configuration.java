package com.itacademy.aqa.configuration;

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
}
