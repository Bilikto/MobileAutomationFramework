package com.automation.steps;

import com.automation.pages.FlightSearchPage;
import com.automation.utils.ConfigReaderUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class FlightSearchSteps {

    FlightSearchPage flightSearchPage = new FlightSearchPage();

    @Then("verify user is on flight search screen")
    public void verify_user_is_on_flight_search_screen() {
        Assert.assertTrue(flightSearchPage.isFlightSearchPageDisplayed());
    }

    @When("user enters flight source to {string}")
    public void user_enters_flight_source_to(String source) {
        flightSearchPage.enterSourceLocation(ConfigReaderUtils.getProperty(source));
    }

    @When("flight destination to {string}")
    public void flight_to(String destination) {
        flightSearchPage.enterDestinationLocation(ConfigReaderUtils.getProperty(destination));
    }

    @When("select date from {string} to {string}")
    public void select_date_from_to(String travelDate, String returnDate) {
        flightSearchPage.enterDate(ConfigReaderUtils.getProperty(travelDate));
        flightSearchPage.enterDate(ConfigReaderUtils.getProperty(returnDate));
    }

    @When("click on done button")
    public void click_on_done_button() {
        flightSearchPage.clickOnDoneBtn();
    }

    @When("click on search button")
    public void click_on_search_button() {
        flightSearchPage.clickOnSearchBtn();
    }

    @Then("verify invalid search error is displayed with text")
    public void verify_invalid_search_error_is_displayed_with_text(DataTable dataTable) {
        String errorMsg = dataTable.asList().get(0);
        Assert.assertTrue(flightSearchPage.isSearchErrorTextDisplayed());
        Assert.assertEquals(errorMsg, flightSearchPage.getSearchErrorMessage());
    }

    @And("click on done button on invalid search error popup")
    public void clickOnDoneButtonOnInvalidSearchErrorPopup() {
        flightSearchPage.clickOnErrorPupUpDoneBtn();
    }
}
