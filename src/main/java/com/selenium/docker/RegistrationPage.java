package com.selenium.docker;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

// page_url = https://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html
public class RegistrationPage extends BasePage {

    @FindBy(name = "firstName")
    private WebElement firstNameTxt;

    @FindBy(name = "lastName")
    private WebElement lastNameTxt;

    @FindBy(name = "phone")
    private WebElement phoneTxt;

    @FindBy(id = "userName")
    private WebElement userNameTxt;

    @FindBy(name = "address1")
    private WebElement addressTxt;

    @FindBy(name = "city")
    private WebElement cityTxt;

    @FindBy(name = "state")
    private WebElement stateTxt;

    @FindBy(name = "postalCode")
    private WebElement postalCodeTxt;

    @FindBy(name = "country")
    private WebElement countrySelector;

    @FindBy(id = "email")
    private WebElement emailTxt;

    @FindBy(name = "password")
    private WebElement passwordTxt;

    @FindBy(name = "confirmPassword")
    private WebElement confirmPasswordTxt;

    @FindBy(id = "register-btn")
    private WebElement submitBtn;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void goTo() {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html");
        this.wait.until(ExpectedConditions.visibilityOf(this.firstNameTxt));
    }

    public void enterUserDetails(String firstName, String lastName) {
        this.firstNameTxt.sendKeys(firstName);
        this.lastNameTxt.sendKeys(lastName);
    }

    public void eneterUserCredentials(String user, String password) {
        this.userNameTxt.sendKeys(user);
        this.passwordTxt.sendKeys(password);
        this.confirmPasswordTxt.sendKeys(password);
    }

    public void submit() {
        this.submitBtn.click();
    }
}