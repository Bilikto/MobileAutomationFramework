package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class StayListingPage extends BasePage {

    @FindBy(xpath = "//android.view.View[@resource-id='SRPCard']")
    List<WebElement> propertyList;

    public boolean isListOfPropertiesDisplayed() {
        return propertyList.size() > 0;
    }
}
