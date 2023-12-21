package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Utility {


    @CacheLookup
    @FindBy(xpath = "//h1[text() = 'Register']")
    WebElement registerText;

    @CacheLookup
    @FindBy(id = "register-button")
    WebElement registerButton;

    @CacheLookup
    @FindBy(xpath = "//span[text() = 'First name is required.']")
    WebElement firstNameError;

    @CacheLookup
    @FindBy(xpath = "//span[text() = 'Last name is required.']")
    WebElement lastNameError;

    @CacheLookup
    @FindBy(id = "Email-error")
    WebElement emailFieldError;

    @CacheLookup
    @FindBy(id = "Password-error")
    WebElement passwordFieldError;
    @CacheLookup
    @FindBy(id = "ConfirmPassword-error")
    WebElement confirmPasswordFieldError;

    @CacheLookup
    @FindBy(id = "gender-female")
    WebElement clickOnFemaleRadioBtn;
    @CacheLookup
    @FindBy(id = "FirstName")
    WebElement sendTxtFirstName;

    @CacheLookup
    @FindBy(id = "LastName")
    WebElement sendTextLastName;

    @CacheLookup
    @FindBy(name = "DateOfBirthDay")
    WebElement selectDay;
    @CacheLookup
    @FindBy(name = "DateOfBirthMonth")
    WebElement selectMonth;
    @CacheLookup
    @FindBy(name = "DateOfBirthYear")
    WebElement selectYear;

    @CacheLookup
    @FindBy(xpath = "(//input[@type = 'email'])[1]")
    WebElement sendEmail;

    @CacheLookup
    @FindBy(id = "Password")
    WebElement sendPassword;

    @CacheLookup
    @FindBy(id = "ConfirmPassword")
    WebElement sendConfirmPassword;

    @CacheLookup
    @FindBy(xpath = "//div[text() = 'Your registration completed']")
    WebElement registrationCompleteMsg;

    public String verifyRegisterText() {
        return getTextFromElement(registerText);
    }

    public void clickOnRegisterButton() {
        clickOnElement(registerButton);
    }

    public String verifyErrorMessageFirstNameIsRequired() {
        return getTextFromElement(firstNameError);
    }

    public String verifyErrorMessageLastNameIsRequired() {
        return getTextFromElement(lastNameError);

    }

    public String verifyErrorMessageEmailNameIsRequired() {
        return getTextFromElement(emailFieldError);

    }

    public String verifyErrorMessagePasswordIsRequired() {
        return getTextFromElement(passwordFieldError);
    }

    public String verifyErrorMessageConfirmPasswordIsRequired() {
        return getTextFromElement(confirmPasswordFieldError);
    }

    public void clickOnFemaleRadioBtn() {
        clickOnElement(clickOnFemaleRadioBtn);
    }

    public void enterFirstName(String text) {
        sendTextToElement(sendTxtFirstName, text);
    }

    public void enterLastName(String text) {
        sendTextToElement(sendTextLastName, text);
    }

    public void selectDayFromDropDown(String text) {
        selectByVisibleTextFromDropDown(selectDay, text);
    }

    public void selectMonthFromDropDown(String text) {
        selectByVisibleTextFromDropDown(selectMonth, text);
    }

    public void selectYearFromDropDown(String text) {
        selectByVisibleTextFromDropDown(selectYear, text);
    }

    public void enterEmail(String text) {

         sendTextToElement(sendEmail,text);
    }

    public void enterPassword(String text) {

        sendTextToElement(sendPassword, text);
    }

    public void enterConfirmPassword(String text) {
        sendTextToElement(sendConfirmPassword, text);
    }

    public String verifyYourRegistrationCompleted() {
        return getTextFromElement(registrationCompleteMsg);
    }

}