package com.automation.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class DriverUtils {

    private static AppiumDriver driver;
//    private static AndroidDriver driver;

    public static void createLocalDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", ConfigReaderUtils.getProperty("platform.name"));
        capabilities.setCapability("deviceName", ConfigReaderUtils.getProperty("device.name"));
        capabilities.setCapability("appium:automationName", ConfigReaderUtils.getProperty("automation.name"));
        capabilities.setCapability("appium:app", System.getProperty("user.dir") +"\\"+ ConfigReaderUtils.getProperty("apk.name"));

        driver = new AppiumDriver(capabilities);
//        driver = new AndroidDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    public static void createBrowserStackDriver() throws MalformedURLException {
        // below are generated on browser stack site (see --> browserstack capability generator in Google)
        DesiredCapabilities capabilities = new DesiredCapabilities();

        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
        browserstackOptions.put("projectName", "ExpediaAutomation");
        browserstackOptions.put("buildName", "RegressionTest");
        browserstackOptions.put("userName", "biliktodashiev_2rj7Yh");
        browserstackOptions.put("accessKey", "SSQoFKadYYZidkQusNvy");

        capabilities.setCapability("bstack:options", browserstackOptions);
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("platformVersion", "9.0");
        capabilities.setCapability("deviceName", "Samsung Galaxy S10e");
        capabilities.setCapability("app", "bs://bee1bd37757fac99f54a629797eb2e1bac9c994f");

        URL url = new URL("http://hub-cloud.browserstack.com/wd/hub");
        driver = new AppiumDriver(url, capabilities); // Not a RemoteWebDriver!!!
//        driver = new AndroidDriver(url, capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }


    public static AppiumDriver getDriver() {
        return driver;
    }

}
