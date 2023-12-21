package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space ('Welcome, Please Sign In!')]")
    WebElement welcomeMessage;

    @CacheLookup
    @FindBy(id = "Email")
    WebElement email;

    @CacheLookup
    @FindBy(id = "Password")
    WebElement password;

    @CacheLookup
    @FindBy(xpath = "//button[text() = 'Log in']")
    WebElement loginBtn;

    @CacheLookup
    @FindBy(className = "message-error")
    WebElement errorMessage;
    ////a[text() = 'Log out']


    public String verifyWelcomeMsg() {

        return getTextFromElement(welcomeMessage);
    }

    public void enterEmailId(String text) {
        sendTextToElement(email, text);
    }

    public void enterPassword(String text) {
        sendTextToElement(password, text);
    }

    public void clickOnLoginBtn() {

        clickOnElement(loginBtn);
    }

    public String verifyErrorMessage() {
        return getTextFromElement(errorMessage);
    }

}


