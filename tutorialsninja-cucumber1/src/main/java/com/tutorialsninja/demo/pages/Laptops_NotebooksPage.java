package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Laptops_NotebooksPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h2[text() = 'Laptops & Notebooks']")
    WebElement verifyDesktopTxt;
    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement selectPriceHighToLow;

    @CacheLookup
    @FindBy(xpath = "//a[text() = 'MacBook']")
    WebElement clickOnMacbook;
    @FindAll({@FindBy(xpath = "//p[@class='price']")})
    List<WebElement> productsList;


    public String verifyTheTextDLaptopsAndNoteBooks() {
        return getTextFromElement(verifyDesktopTxt);
    }

    public void selectPriceHighToLow(String text) {
        selectByVisibleTextFromDropDown(selectPriceHighToLow, text);
    }

    public void clickOnMacBook() {
        clickOnElement(clickOnMacbook);
    }

    public List<WebElement> getFilteredProductList() {
        try {
            waitUntilVisibilityOfElementLocated(productsList, 20);
            return productsList;
        } catch (Exception e) {
            driver.getCurrentUrl();
            return productsList;
        }

    }
}
