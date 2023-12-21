package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class MacBookPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[text() = 'MacBook']")
    WebElement verifyMacBookTxt;

    @CacheLookup
    @FindBy(id = "button-cart")
    WebElement clickONAddToCart;
    @CacheLookup
    @FindBy(xpath = "//div[@class ='alert alert-success alert-dismissible']")
    WebElement verifyShoppingCart;

    @CacheLookup
    @FindBy(xpath = "//a[text () = 'shopping cart']")
    WebElement clickOnShoppingLnk;

    public String verifyTxtMacBook(){
        return getTextFromElement(verifyMacBookTxt);
    }
    public void clickOnAddToCart(){
        clickOnElement(clickONAddToCart);
    }
    public String verifyMessageYouHaveAddedMacBookToYourCart()

    {
        return getTextFromElement(verifyShoppingCart);

    }
    public void clickOnShoppingCart(){
        clickOnElement(clickOnShoppingLnk);
    }
}
