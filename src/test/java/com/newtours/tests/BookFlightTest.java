package com.newtours.tests;

import com.selenium.docker.*;
import com.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BookFlightTest extends BaseTest {

    private String numberOfPassengers;
    private String expectedPrice;

    @Test
    @Parameters({"numberOfPassengers", "expectedPrice"})
    public void setParams(String numberOfPassengers, String expectedPrice) {
        this.numberOfPassengers = numberOfPassengers;
        this.expectedPrice = expectedPrice;
    }

    @Test(dependsOnMethods = "setParams")
    public void registrationPageTest() {
        RegistrationPage registrationPage = new RegistrationPage(this.driver);
        registrationPage.goTo();
        registrationPage.enterUserDetails("Carlos", "Medina");
        registrationPage.eneterUserCredentials("User", "Pssword");
        registrationPage.submit();
    }

    @Test(dependsOnMethods = "registrationPageTest")
    public void registrationConfirmationPageTest() {
        RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage(this.driver);
        registrationConfirmationPage.goToFlightsDetailsPage();
    }

    @Test(dependsOnMethods = "registrationConfirmationPageTest")
    public void flightsDetailsPageTest() {
        FlightDetailsPage flightDetailsPage = new FlightDetailsPage(this.driver);
        flightDetailsPage.selectPasseners(this.numberOfPassengers);
        flightDetailsPage.goToFindFlightsPage();
    }

    @Test(dependsOnMethods = "flightsDetailsPageTest")
    public void findFlightsPageTest() {
        FindFlightPage findFlightPage = new FindFlightPage(this.driver);
        findFlightPage.submitFindFlightsPage();
        findFlightPage.goToFlightConfirmationPage();
    }

    @Test(dependsOnMethods = "findFlightsPageTest")
    public void findConfirmationPageTest() {
        FlightConfirmationPage flightConfirmationPage = new FlightConfirmationPage(this.driver);
        String actualPrice = flightConfirmationPage.printConfirmation();
        Assert.assertEquals(actualPrice, this.expectedPrice);

    }
}

