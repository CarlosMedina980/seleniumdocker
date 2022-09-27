package com.selenium.docker;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

// page_url = https://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html
public class RegistrationConfirmationPage extends BasePage {


    @FindBy(partialLinkText = "sign-in")
    private WebElement signInLink;

    @FindBy(linkText = "Flights")
    private WebElement flightsLink;

    public RegistrationConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public void goToFlightsDetailsPage() {
        this.wait.until(ExpectedConditions.visibilityOf(signInLink));
        this.flightsLink.click();
    }
}