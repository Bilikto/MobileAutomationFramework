package com.automation.pages;

import com.automation.utils.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {

    @FindBy(xpath="//android.widget.TextView[@text='Get started']")
    WebElement getStartedBtn;

    @FindBy(xpath="//android.view.View[@content-desc='Close']")
    WebElement closeBtn;

    @FindBy(xpath = "//android.widget.TextView[@text='Flights']")
    WebElement flightTab;

    @FindBy(xpath = "//android.widget.TextView[@text='Stays']")
    WebElement staysTab;

    public void openApplication() {
        //closing pre-load home screen popup windows
        click(getStartedBtn);
        click(closeBtn);
    }

    public boolean isHomePageDisplayed() {
        return staysTab.isDisplayed() && flightTab.isDisplayed();
    }

    public void clickOnFlightMenu() {
        flightTab.click();
    }

    public void clickOnStaysMenu() {
        staysTab.click();
    }
}
