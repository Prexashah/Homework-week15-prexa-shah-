package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DesktopsProductsPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='HP LP3065']")
    WebElement hP_LP3065P;

    @CacheLookup
    @FindBy(xpath = "//div[@class='input-group date']/span")
    WebElement deliveryDateDropDown;

    @CacheLookup
    @FindBy(xpath = "//thead//th[@class='picker-switch'])[1]")
    WebElement monthAndYear;
    @CacheLookup
    @FindBy(xpath = "//thead//th[@class='picker-switch'])[1]/following-sibling::th")
    WebElement monthYearForwardArrow;

    @CacheLookup
    @FindAll({@FindBy(xpath = "//div[@class='datepicker-days']//td")})
    List<WebElement> allDatesOnCalender;

    @CacheLookup
    @FindBy(id = "input-quantity")
    WebElement quantity;

    @CacheLookup
    @FindBy(id = "button-cart")
    WebElement addToCartButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement successMessage;
    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='shopping cart']")
    WebElement shoppingCartLink;
    @CacheLookup
    @FindBy(xpath = "//h1[text() = 'HP LP3065']")
    WebElement getHPLP3065Text;

    @CacheLookup
    @FindAll({@FindBy(xpath = "//div[@class='caption']")})
    List<WebElement> productsList;

    @CacheLookup
    @FindBy(xpath = "(//div[@class='col-sm-4'])[2]/h1")
    WebElement productNameHeading;


    //Methods

    public void enterQuantity(String qty) {
        quantity.clear();
        sendTextToElement(quantity, qty);
    }

    public void clickOnAddToCartButton() {
        clickOnElement(addToCartButton);
    }

    public String getProductAddedSuccessMessageText() {
        return getTextFromElement(successMessage);
    }

    public void clickOnShoppingCartLinkInSuccessMessage() {
        clickOnElement(shoppingCartLink);
    }

    public List<WebElement> getFilteredProductList() {

        waitUntilVisibilityOfElementLocated(productsList, 10); //Using overloaded method that takes a list of elements and waits for them to be displayed.
        return productsList;
    }
    public String verifyTheTextHPLP3065(){
      return   getTextFromElement(getHPLP3065Text);
    }
    public String getProductNameHeadingText(){
        return getTextFromElement(productNameHeading);
    }

}