package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class FlightSearchPage extends SearchPage {

    @FindBy(xpath = "//android.widget.TextView[@text = 'Flying from']")
    WebElement flyingFromField;

    @FindBy(xpath = "//android.widget.TextView[@text = 'Flying to']")
    WebElement flyingToField;

    @FindBy(xpath = "//android.widget.TextView[@text = 'Travellers']")
    WebElement travellersField;

    @FindBy(xpath = "//android.widget.TextView[@text = 'Preferred class']")
    WebElement preferredClassField;

    @FindBy(id = "com.expedia.bookings:id/parentPanel")
    WebElement searchErrorPopUp;

    @FindBy(id = "android:id/message")
    WebElement searchErrorMsgText;

    @FindBy(id = "android:id/button1")
    WebElement searchErrorDoneBtn;

    public boolean isFlightSearchPageDisplayed() {
        return flyingFromField.isDisplayed() && flyingToField.isDisplayed();
    }

    public void enterSourceLocation(String source) {
        flyingFromField.click();
        searchBox.sendKeys(source);
        searchResultList.get(0).click();
    }

    public boolean isSearchErrorTextDisplayed() {
        return searchErrorPopUp.isDisplayed();
    }

    public String getSearchErrorMessage() {
        return searchErrorMsgText.getText();
    }

    public void clickOnErrorPupUpDoneBtn() {
        searchErrorDoneBtn.click();
    }
}
