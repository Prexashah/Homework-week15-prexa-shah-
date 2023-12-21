package com.tutorialsninja.demo.steps;

import com.tutorialsninja.demo.browserfactory.ManageBrowser;
import com.tutorialsninja.demo.pages.DesktopPage;
import com.tutorialsninja.demo.pages.DesktopsProductsPage;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.ShoppingCartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopsSteps {

    private static final Logger log = LogManager.getLogger(ManageBrowser.class);

    @Given("user Mouse hover on Desktops tab and clicks")
    public void userMouseHoverOnDesktopsTabAndClicks() {
        new HomePage().mouseHoverAndClickDesktopTab();
    }

    @And("User clicks on show all desktops")
    public void userClicksOnShowAllDesktops() {
        new HomePage().clickOnShowAllDesktops();
    }

    public List<String> selectProductBeforeFilter() {
        //creating an array list to store all the products before sorting and sort them using sort method
        List<WebElement> productBeforeFilterList = new DesktopPage().getFilteredProductList();
        ArrayList<String> productBeforeFilter = new ArrayList<>();
        for (WebElement product : productBeforeFilterList) {
            productBeforeFilter.add(product.getText());
        }
        Collections.sort(productBeforeFilter, String.CASE_INSENSITIVE_ORDER);
        Collections.reverse(productBeforeFilter);
        return productBeforeFilter;
    }


    @When("User select the position {string}")
    public void userSelectThePosition(String products) {
        new DesktopPage().selectSortByPositionNameZToA(products);
    }

    public List<String> selectProductsAfterFilter() {

        //Create an array and store all products before sorting and sort them using Collections sort method
        List<WebElement> productsAfterFilterList = new DesktopPage().getFilteredProductList();
        ArrayList<String> productsAfterFilter = new ArrayList<>();
        for (WebElement product : productsAfterFilterList) {
            productsAfterFilter.add(product.getText());
        }
        Collections.sort(productsAfterFilter, String.CASE_INSENSITIVE_ORDER);
        Collections.reverse(productsAfterFilter);
        return productsAfterFilter;
    }


    @Then("Products should display in Descending order")
    public void productsShouldDisplayInDescendingOrder() {
        log.info("Verifying the display order of product....");
        Assert.assertEquals(selectProductBeforeFilter(), selectProductsAfterFilter(), "The products are not displayed in alphabetical order.");
    }

    @Given("User mouse hover on Currency Dropdown and clicks")
    public void userMouseHoverOnCurrencyDropdownAndClicks() {
        new HomePage().mouseHoverOnCurrencyAndClick();
    }

    @And("User mouse hover on £sterling and clicks")
    public void userMouseHoverOn£sterlingAndClicks() {
        new HomePage().clickOnSterlingPound();
    }

    @And("User mouse hover on {string}Tab")
    public void userMouseHoverOnTab(String menuTab) {
        switch (menuTab) {
            case "Desktops":
                new HomePage().mouseHoverAndClickDesktopTab();
                break;
            case "Laptops & Notebooks":
                new HomePage().mouseHoverOnLaptopsNoteBooksAndClick();
                break;
            case "Components":
                new HomePage().mouseHoverOnComponentsTabAndClick();
                break;
        }

    }

    @And("User clicks on {string}")
    public void userClicksOn(String dropDown) {
        //selecting dropdowns from all the dropdowns
        List<WebElement> allOptions = new HomePage().showAllOptionsFromTopNav();
        try {
            for (WebElement e : allOptions) {
                if (e.getText().equals(dropDown)) {
                    e.click();
                }
            }
        } catch (StaleElementReferenceException e) {

        }
    }

    @And("User selects sort by position {string}")
    public void userSelectsSortByPosition(String text) {
        new DesktopPage().selectSortByPositionNameAToZ(text);


    }

    @And("User selects {string} from product list")
    public void userSelectsFromProductList(String product) {
        log.info("selecting require product from the result");
        List<WebElement> allProducts = new DesktopPage().getAllProducts();
        for (WebElement element : allProducts) {
            if (element.getText().equalsIgnoreCase(product)) {
                System.out.println("Matching product: " + element.getText());//debug purpose
                element.click();
                break;
            }
        }
    }

    @Then("User can view {string} text")
    public void userCanViewText(String product) {
        Assert.assertEquals(new DesktopsProductsPage().getProductNameHeadingText(), product, "The product displayed is not correct.");

    }

    @And("User selects {string} from currency drop down")
    public void userSelectsFromCurrencyDropDown(String ar0) {

    }

    @And("User selects {string} from Quantity")
    public void userSelectsFromQuantity(String quantity) {
        new DesktopsProductsPage().enterQuantity(quantity);
    }

    @And("User clicks on Add to cart button")
    public void userClicksOnAddToCartButton() {
        new DesktopsProductsPage().clickOnAddToCartButton();
    }

    @Then("User can view {string} message")
    public void userCanViewMessage(String successMSG) {
        Assert.assertTrue(new DesktopsProductsPage().getProductAddedSuccessMessageText().contains(successMSG),
                "Product not added to the cart");
    }

    @And("User clicks on {string} link into success message")
    public void userClicksOnLinkIntoSuccessMessage(String shoppingLink) {
        new DesktopsProductsPage().clickOnShoppingCartLinkInSuccessMessage();

    }

    @Then("User can view {string} ,{string},{string},{string}")
    public void userCanView(String shoppingHeading, String productName, String model, String price) {
        Assert.assertTrue(new ShoppingCartPage().getShoppingCartHeadingText().contains(shoppingHeading), "Navigated to wrong page.");
        Assert.assertEquals(new ShoppingCartPage().getProductNameText(), productName, "Wrong product in the cart.");
        Assert.assertEquals(new ShoppingCartPage().getModelNameText(), model, "Wrong model in the cart");
        Assert.assertEquals(new ShoppingCartPage().getTotalText(), price, "Total is wrong.");
    }


}



