package com.selenium.docker;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;

// page_url = about:blank
public class FlightDetailsPage extends BasePage {

    @FindBy(id = "passCount")
    private WebElement passengers;

    @FindBy(id = "findFlights")
    private WebElement findFlightsBtn;

    public FlightDetailsPage(WebDriver driver) {
        super(driver);
    }

    public void selectPasseners(String numberOfPassengers) {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.passengers));
        Select select = new Select(passengers);
        select.selectByValue(numberOfPassengers);

    }

    public void goToFindFlightsPage() {
        this.findFlightsBtn.click();
    }
}