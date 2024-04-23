package com.automation.utils;

import java.io.FileReader;
import java.util.Properties;

public class ConfigReaderUtils {

    private static Properties prop;
    private static String configFilePath = "src/test/resources/config/config.properties";

    public static void initProperties() {
        try {
            prop = new Properties();
            FileReader reader = new FileReader(configFilePath);
            prop.load(reader);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(String key) {
        return prop.getProperty(key);
    }

}
