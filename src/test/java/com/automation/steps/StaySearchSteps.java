package com.automation.steps;

import com.automation.pages.StaySearchPage;
import com.automation.utils.ConfigReaderUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StaySearchSteps {

    StaySearchPage staySearchPage = new StaySearchPage();

    @When("user enters stay location {string}")
    public void user_enters_stay_location(String location) {
        staySearchPage.enterDestinationLocation(ConfigReaderUtils.getProperty(location));
    }

    @And("user click on date field")
    public void userClickOnDateField() {
        staySearchPage.clickOnDateField();
    }

    @And("select date check-in date {string}")
    public void selectDateCheckInDate(String checkInDate) {
        staySearchPage.enterDate(ConfigReaderUtils.getProperty(checkInDate));
    }

    @And("check-out date {string}")
    public void checkoutDate(String checkOutDate) {
        staySearchPage.enterDate(ConfigReaderUtils.getProperty(checkOutDate));
    }



}
