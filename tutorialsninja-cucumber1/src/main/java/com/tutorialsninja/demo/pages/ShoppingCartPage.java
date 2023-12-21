package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//div[@id = 'content']//child :: h1")
    WebElement verifyShoppingMsg;
    @CacheLookup
    @FindBy(xpath = "(//a[text() = 'MacBook'])[2]")
    WebElement verifyMacBookFromProduct;

    @CacheLookup
    @FindBy(xpath = "//div[@class='input-group btn-block']/input")
    WebElement quantity;

    @CacheLookup
    @FindBy(xpath = "//button[@class='btn btn-primary']")
    WebElement updateTab;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'alert alert-success alert-dismissible']")
    WebElement verifyUpdateMsg;

    @CacheLookup
    @FindBy(xpath = "(//td[text() ='£737.45'])[4]")
    WebElement verifyTotal;

    @CacheLookup
    @FindBy(linkText = "Checkout")
    WebElement checkOutButton;

    @CacheLookup
    @FindBy(xpath = "//table[@class='table table-striped']//td[@class='text-left']/a")
    WebElement productName;
    @CacheLookup
    @FindBy(xpath = "(//td[@class='text-left'])[6]")
    WebElement modelName;

    @CacheLookup
    @FindBy(xpath = "//div[@id='content']/h1")
    WebElement shoppingCartHeading;
    @CacheLookup
    @FindBy(xpath = "//tbody/tr/td[6]")
    WebElement total;




    public String verifyTxtShoppingCartMsg() {

        return getTextFromElement(verifyShoppingMsg);
    }

    public String verifyProductMacBook() {

        return getTextFromElement(verifyMacBookFromProduct);
    }

    public void updateQuantity(String text) {
        quantity.clear();
        sendTextToElement(quantity, text);
    }

    public void clickOnUpdateTab() {
        clickOnElement(updateTab);
    }

    public String verifyTextSuccessYouHaveModifiedYourShoppingCart() {

        return getTextFromElement(verifyUpdateMsg);
    }

    public String verifyTotal() {

        return getTextFromElement(verifyTotal);

    }

    public void clickOnCheckOutButton() {
        clickOnElement(checkOutButton);
    }
    public String getProductNameText() {
        return getTextFromElement(productName);
    }
    public String getModelNameText() {
        return getTextFromElement(modelName);
    }
    public String getTotalText() {
        return getTextFromElement(total);
    }
    public String getShoppingCartHeadingText() {
        return getTextFromElement(shoppingCartHeading);
    }



}
