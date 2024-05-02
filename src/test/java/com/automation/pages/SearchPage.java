package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

// keep here common methods for Flight and Stay search!!!
public abstract class SearchPage extends BasePage {

    @FindBy(xpath = "//android.widget.TextView[@text = 'Select dates']")
    WebElement dateField;

    @FindBy(id = "com.expedia.bookings:id/search_btn")
    WebElement searchBtn;

    @FindBy(id = "com.expedia.bookings:id/search_src_text")
    WebElement searchBox;

    @FindBy(id = "com.expedia.bookings:id/confirmButton")
    WebElement doneBtn;

    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.expedia.bookings:id/suggestion_text_container']")
    List<WebElement> searchResultList;

    String XPATH_DATE_ELEMENT = "//android.widget.TextView[@content-desc='%s, Not Selected']";

    public void enterDate(String date) {
        String dateLoc = String.format(XPATH_DATE_ELEMENT, date);
        driver.findElement(By.xpath(dateLoc)).click();
    }

    public void clickOnDoneBtn() {
        doneBtn.click();
    }

    public void clickOnSearchBtn() {
        searchBtn.click();
    }

    public void enterDestinationLocation(String destination) {
        searchBox.sendKeys(destination);
        searchResultList.get(0).click();
    }

    public void clickOnDateField() {
        dateField.click();
    }
}
