package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * 1.LoginPage - Store username, password, Login Button and LOGIN Panel text Locators
 *  and create appropriate methods for it.
 */

public class LoginPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h2[text()='Returning Customer']")
    WebElement returningCustomerHeading;

    //Methods
    public String getReturningCustomerHeadingText(){
        return getTextFromElement(returningCustomerHeading);
    }







}
