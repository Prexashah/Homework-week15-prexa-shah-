package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class YourAccountCreatedPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//div[@id='content']/h1")
    WebElement registerSuccessMessage;

    @CacheLookup
    @FindBy(linkText = "Continue")
    WebElement continueButton;


    //Methods
    public String getRegisterSuccessMessageText(){
        return getTextFromElement(registerSuccessMessage);
    }

    public void clickOnContinueButton(){
        clickOnElement(continueButton);
    }
}
