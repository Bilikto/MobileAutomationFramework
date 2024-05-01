package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FlightListingPage extends BasePage {

    @FindBy(xpath = "//android.widget.TextView[@content-desc='Price Tracking']")
    WebElement priceTrackingText;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.expedia.bookings:id/card_content_area']")
    List<WebElement> flightList;

    public boolean isFlightListingPageDisplayed() {
        return priceTrackingText.isDisplayed() && flightList.size() > 0;
    }

}
