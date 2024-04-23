package com.automation.utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.awt.*;
import java.time.Duration;

public class DriverUtils {

    private static AppiumDriver driver;

    public static void createDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "R9WR309VEWJ");
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:app", "C:\\Users\\dashi\\Desktop\\DevX workspace\\Lessons\\FRAMEWORKS\\MobileAutomationFramework\\expedia.apk");

        driver = new AppiumDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    public static AppiumDriver getDriver() {
        return driver;
    }

}
