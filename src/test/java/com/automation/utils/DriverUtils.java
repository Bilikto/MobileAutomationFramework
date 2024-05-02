package com.automation.utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class DriverUtils {

    private static AppiumDriver driver;

    public static void createLocalDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", ConfigReaderUtils.getProperty("platform.name"));
        capabilities.setCapability("deviceName", ConfigReaderUtils.getProperty("device.name"));
        capabilities.setCapability("appium:automationName", ConfigReaderUtils.getProperty("automation.name"));
        capabilities.setCapability("appium:app", System.getProperty("user.dir") +"\\"+ ConfigReaderUtils.getProperty("apk.name"));

        driver = new AppiumDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    public static void createBrowserStackDriver() throws MalformedURLException {
        // below are generated on browser stack site (see --> browserstack capability generator in Google)
        DesiredCapabilities capabilities = new DesiredCapabilities();

        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
        browserstackOptions.put("projectName", ConfigReaderUtils.getProperty("project.name"));
        browserstackOptions.put("buildName", ConfigReaderUtils.getProperty("build.name"));
        browserstackOptions.put("userName", ConfigReaderUtils.getProperty("bs.username"));
        browserstackOptions.put("accessKey", ConfigReaderUtils.getProperty("bs.access.key"));

        capabilities.setCapability("bstack:options", browserstackOptions);
        capabilities.setCapability("platformName", ConfigReaderUtils.getProperty("bs.platform.name"));
        capabilities.setCapability("platformVersion", ConfigReaderUtils.getProperty("bs.platform.version"));
        capabilities.setCapability("deviceName", ConfigReaderUtils.getProperty("bs.device.name"));
        capabilities.setCapability("app", ConfigReaderUtils.getProperty("bs.app.url"));

        URL url = new URL(ConfigReaderUtils.getProperty("bs.url"));
        driver = new AppiumDriver(url, capabilities); // Not a RemoteWebDriver!!!
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }


    public static AppiumDriver getDriver() {
        return driver;
    }

}
