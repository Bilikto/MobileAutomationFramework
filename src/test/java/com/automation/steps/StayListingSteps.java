package com.automation.steps;

import com.automation.pages.StayListingPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class StayListingSteps {

    StayListingPage stayListingPage = new StayListingPage();

    @Then("verify list of properties are displayed on the screen")
    public void verifyListOfPropertiesAreDisplayedOnTheScreen() {
        Assert.assertTrue(stayListingPage.isListOfPropertiesDisplayed());
    }

}
