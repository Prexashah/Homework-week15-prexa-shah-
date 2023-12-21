package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Utility {

    @CacheLookup
    @FindBy(linkText = "Log in")
    WebElement loginLink;

    @CacheLookup
    @FindBy(xpath = "//a[text() = 'Log out']")
    WebElement logoutLink;

    @CacheLookup
    @FindBy(xpath = "//a[@class = 'ico-register']")
    WebElement registerLink;

    @CacheLookup
    @FindBy(xpath = "(//a[text() = 'Computers '])[1]")
    WebElement computerTab;

    @CacheLookup
    @FindBy(xpath = "//a[text() = 'Log in']")
    WebElement verifyLoginLink;



    public void clickOnLoginLink() {

        clickOnElement(loginLink);
    }

    public String verifyThatLogOutLinkIsDisplay() {
        return getTextFromElement(logoutLink);
    }

    public void clickOnLogOutLink() {
        clickOnElement(logoutLink);
    }

    public String verifyThatLoginLinkIsDisplay() {
        return getTextFromElement(verifyLoginLink);
    }

    public void clickOnRegisterLink() {
        clickOnElement(registerLink);
    }

    public void clickOnComputerTab() {

        clickOnElement(computerTab);
    }
}
