package com.selenium.docker;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

// page_url = about:blank
public class FlightConfirmationPage extends BasePage {

    @FindBy(xpath = "//font[contains(text(),'Flight Confirmation')]")
    private WebElement flightConfirmationTittle;


    @FindBy(xpath = "//font[contains(text(),'USD')]")
    private List<WebElement> prices;

    @FindBy(linkText = "SIGN-OFF")
    private WebElement signOffLink;

    public FlightConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public String printConfirmation() {
        this.wait.until(ExpectedConditions.visibilityOf(flightConfirmationTittle));
        System.out.println(this.flightConfirmationTittle.getText());
        String actualPrice = this.prices.get(1).getText();
        this.signOffLink.click();
        return actualPrice;
    }
}