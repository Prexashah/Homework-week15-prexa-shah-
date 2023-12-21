package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckoutPage extends Utility {

    //element
    @CacheLookup
    @FindBy(xpath = "//h1[text() = 'Checkout']")
    WebElement verifyTextCheckout;

    @CacheLookup
    @FindBy(xpath = "//h2[text() = 'New Customer']")
    WebElement verifyNewCustomerTxt;

    @FindAll({@FindBy(xpath = "//input[@name='account']")})
    List<WebElement> radioButton;

    @FindBy(id = "button-account")
    WebElement continueButton;

    @CacheLookup
    @FindBy(id = "input-payment-firstname")
    WebElement firstName;
    @CacheLookup
    @FindBy(id = "input-payment-lastname")
    WebElement lastName;
    @CacheLookup
    @FindBy(id = "input-payment-email")
    WebElement email;
    @CacheLookup
    @FindBy(id = "input-payment-telephone")
    WebElement phone;
    @CacheLookup
    @FindBy(id = "input-payment-password")
    WebElement password;

    @CacheLookup
    @FindBy(id = "input-payment-confirm")
    WebElement confirmPassword;
    @CacheLookup
    @FindBy(id = "input-payment-address-1")
    WebElement address;
    @CacheLookup
    @FindBy(id = "input-payment-city")
    WebElement city;
    @CacheLookup
    @FindBy(id = "input-payment-postcode")
    WebElement postCode;
    @CacheLookup
    @FindBy(id = "input-payment-country")
    WebElement countryDropDown;

    @CacheLookup
    @FindBy(id = "input-payment-zone")
    WebElement regionStateDropDown;
    @CacheLookup
    @FindBy(xpath = "//div[@class='pull-right']/input[@value='Continue']")
    WebElement continueButtonAfterBillingDetails;
    @CacheLookup
    @FindBy(xpath = "//textarea[@name='comment']")
    WebElement sendCommentsOnOrders;
    @CacheLookup
    @FindBy(xpath = "//input[@name='agree']")
    WebElement termsAndConditionsCheckBox;
    @CacheLookup
    @FindBy(id = "button-payment-method")
    WebElement continueButtonInPaymentMethod;

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    WebElement paymentRequiredWarningMessage;
    @FindBy(xpath = "//input[@name='agree']")
    WebElement checkBox;

    //methods
    public String verifyCheckoutMsg() {
        return getTextFromElement(verifyTextCheckout);

    }

    public String verifyTheTextNewCustomer() {
        return getTextFromElement(verifyNewCustomerTxt);

    }

    public void clickOnRadioButton(String text) {
        List<WebElement> rButtons = radioButton;
        for (WebElement r : rButtons) {
            if (r.getText().equalsIgnoreCase(text)) {
                r.click();
                break;
            }
        }
    }

    public void clickOnContinueButton() {
        clickOnElement(continueButton);
    }

    public void enterFirstName(String text) {
        sendTextToElement(firstName, text);
    }

    public void enterLastName(String text) {
        sendTextToElement(lastName, text);
    }

    public void enterEmail(String text) {
        sendTextToElement(email, text);
    }

    public void enterPhone(String text) {
        sendTextToElement(phone, text);
    }

    public void enterPassword(String text) {
        sendTextToElement(password, text);
    }

    public void enterConfirmPassword(String text) {
        sendTextToElement(confirmPassword, text);
    }

    public void enterAddress(String text) {
        sendTextToElement(address, text);
    }

    public void enterCity(String text) {
        sendTextToElement(city, text);
    }

    public void enterPostCode(String text) {
        sendTextToElement(postCode, text);
    }

    public void selectCountryFromDropDown(String text) {
        selectByVisibleTextFromDropDown(countryDropDown, text);
    }

    public void selectRegionOrStateFromDropDown(String text) {
        selectByVisibleTextFromDropDown(regionStateDropDown, text);
    }

    public void clickOnContinueButtonForBilling() {
        clickOnElement(continueButtonAfterBillingDetails);
    }

    public void enterCommentsAboutOrder(String text) {
        sendTextToElement(sendCommentsOnOrders, text);
    }

    public void clickOnTermsAndConditionsCheckBox() {
        clickOnElement(termsAndConditionsCheckBox);
    }

    public void clickOnContinueButtonInPaymentMethod() {
        clickOnElement(continueButtonInPaymentMethod);
    }

    public String getWarningMessageText() {
        return getTextFromElement(paymentRequiredWarningMessage);
    }
    public void clickOnCheckBox() {
        clickOnElement(checkBox);
    }


}