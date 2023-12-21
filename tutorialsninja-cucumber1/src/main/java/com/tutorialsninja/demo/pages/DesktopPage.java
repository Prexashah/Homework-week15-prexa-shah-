package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * 3.DashboardPage - Dashboard text Locator
 *  and create appropriate methods for it.
 */
public class DesktopPage extends Utility {
    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement selectNameZToA;

    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement selectNameAToZ;

    @CacheLookup
    @FindBy(xpath = "//div[@class='details']//h2[@class='product-title']/a")
    WebElement verifyProductsDescendingOrder;



    @CacheLookup
    @FindAll({@FindBy(xpath = "//div[@class='caption']")})
    List<WebElement> productsList;

    @CacheLookup
    @FindBy(xpath = "//h2[text() = 'Desktops']")
    WebElement verifyDesktopTxt;

    @CacheLookup
    @FindAll({@FindBy(xpath = "//div[@class='caption']/h4")})
    List<WebElement> allDesktopProducts;

    @CacheLookup
    @FindBy(xpath = "(//a[text() = 'HP LP3065'])[2]")
    WebElement productHPLP3065;

    public void selectSortByPositionNameZToA(String text) {
        selectByVisibleTextFromDropDown(selectNameZToA, text);
    }

    public List<WebElement> sortElement() {
        return productsList;

    }


    public void selectSortByPositionNameAToZ(String text) {

        selectByVisibleTextFromDropDown(selectNameAToZ, text);
    }

    public String verifyTheTextDesktops() {
        return getTextFromElement(verifyDesktopTxt);

    }
    public List<WebElement> getAllProducts() {
        return allDesktopProducts;
    }
    public List<WebElement> getFilteredProductList() {

        waitUntilVisibilityOfElementLocated(productsList, 10); //Using overloaded method that takes a list of elements and waits for them to be displayed.
        return productsList;
    }
    public void clickOnProductHpLP3065(){
        clickOnElement(productHPLP3065);
    }


}
