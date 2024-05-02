package com.automation.pages;

import com.automation.utils.DriverUtils;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public abstract class BasePage {

    protected AppiumDriver driver;

    public BasePage() {
        this.driver = DriverUtils.getDriver();
        PageFactory.initElements(driver, this);
    }

    // if-else condition has an issue --> it will check element is displayed or not. If elem is not it`ll wait for 60 sec, and then throw an exception!
    // How to avoid it? --> override implicit wait! and create your own click method!!!
    public void click(WebElement element) {
        try{
            //overriding implicit wait
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            element.click();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            //setting back to 60 sec!
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        }
    }

}
