package com.tutorialsninja.demo.steps;

import com.tutorialsninja.demo.browserfactory.ManageBrowser;
import com.tutorialsninja.demo.pages.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopsandNoptebooksSteps {

    private static final Logger log = Logger.getLogger(ManageBrowser.class);

    public List<Double> selectProductsBeforeFilter() {
        //Store elements in an array and use Collections sort method before filter
        List<WebElement> beforeFilterPrice = new Laptops_NotebooksPage().getFilteredProductList();
        List<Double> beforeFilterPriceList = new ArrayList<>();
        String[] priceArray;
        //Split element to exclude child element text, replace $ symbol and ,(comma) with "", covert into double
        for (WebElement p : beforeFilterPrice) {
            priceArray = p.getText().split("\n");
            System.out.println(priceArray[0]); //for debug purpose
            String number = priceArray[0].replace("$", "");
            String num = number.replace(",", "");
            beforeFilterPriceList.add(Double.valueOf(num));
        }

        Collections.sort(beforeFilterPriceList);
        Collections.reverse(beforeFilterPriceList);
        return beforeFilterPriceList;
    }

    @Given("User navigates to homepage")
    public void userNavigatesToHomepage() {

    }

    @When("User mouse hovers and clicks {string} tab and clicks")
    public void userMouseHoversAndClicksTabAndClicks(String arg0) {
        new HomePage().mouseHoverOnLaptopsNoteBooksAndClick();
    }

    @And("User select {string}")
    public void userSelect(String arg0) {
        new HomePage().showAllLaptopsAndNoteBooks();
    }

    @And("User selects sort by position {string} from laptops and notebooks page")
    public void userSelectsSortByPositionFromLaptopsAndNotebooksPage(String sortByOption) {
        new Laptops_NotebooksPage().selectPriceHighToLow(sortByOption);

    }

    public List<Double> selectProductsAfterFilter() {
        List<WebElement> afterFilterPrice = new Laptops_NotebooksPage().getFilteredProductList();
        ArrayList<Double> afterFilterPriceList = new ArrayList<>();

        String[] priceArrayAfterFilter;
        //Split element to exclude child element text, replace $ symbol and ,(comma) with "", covert into double
        for (WebElement p : afterFilterPrice) {
            // System.out.println(p);
            priceArrayAfterFilter = p.getText().split("\n");
            System.out.println(priceArrayAfterFilter[0]);//for debug purpose
            String number = priceArrayAfterFilter[0].replace("$", "");
            String num = number.replace(",", "");
            afterFilterPriceList.add(Double.valueOf(num));

        }
        return afterFilterPriceList;
    }

    @Then("User can view products in the descending order of price")
    public void userCanViewProductsInTheDescendingOrderOfPrice() {
        Assert.assertEquals(selectProductsBeforeFilter(), selectProductsAfterFilter(), "Products are not displayed in price order.");
    }

    @And("User selects the product {string}")
    public void userSelectsTheProduct(String product) {
        new Laptops_NotebooksPage().clickOnMacBook();

    }

    @Then("User can view {string} text in the product page heading")
    public void userCanViewTextInTheProductPageHeading(String headingTxt) {
        Assert.assertEquals(new MacBookPage().verifyTxtMacBook(), headingTxt, "Navigated to incorrect product page....");

    }

    @And("User clicks on Add To Cart button")
    public void userClicksOnAddToCartButton() {
        new MacBookPage().clickOnAddToCart();
    }

    @Then("User can view {string}")
    public void userCanView(String successMessage) {
        Assert.assertTrue(new MacBookPage().verifyMessageYouHaveAddedMacBookToYourCart().contains(successMessage), "The product is not added to cart successfully.");

    }

    @Then("User can view {string} in page heading and {string} in product name")
    public void userCanViewInPageHeadingAndInProductName(String shoppingCartHeading, String productName) {
        Assert.assertTrue(new ShoppingCartPage().getShoppingCartHeadingText().contains(shoppingCartHeading), "Navigated to wrong page.");
        Assert.assertEquals(new ShoppingCartPage().getProductNameText(), productName, "Wrong product name displayed in cart.");
    }

    @And("User updates quantity to {string}")
    public void userUpdatesQuantityTo(String quantity) {
        new ShoppingCartPage().updateQuantity(quantity);

    }

    @And("User clicks on update tab")
    public void userClicksOnUpdateTab() {
        new ShoppingCartPage().clickOnUpdateTab();

    }

    @Then("User can view {string}, {string} in the cart.")
    public void userCanViewInTheCart(String successMessage, String totalPrice) {
        Assert.assertTrue(new ShoppingCartPage().verifyTextSuccessYouHaveModifiedYourShoppingCart().contains(successMessage), "Cart is not updated.");
        Assert.assertEquals(new ShoppingCartPage().getTotalText(), totalPrice, "Total is wrong");

    }

    @And("User clicks on Checkout button")
    public void userClicksOnCheckoutButton() {
        new ShoppingCartPage().clickOnCheckOutButton();

    }

    @Then("User can view {string} text in the page heading")
    public void userCanViewTextInThePageHeading(String checkOutHeading) {
        Assert.assertEquals(new CheckoutPage().verifyCheckoutMsg(), checkOutHeading, "User is not navigated to 'Checkout' page.");

    }

    @And("User can view {string} check out option")
    public void userCanViewCheckOutOption(String newCustomerOption) {
        Assert.assertEquals(new CheckoutPage().verifyTheTextNewCustomer(), newCustomerOption, "'New Customer' option is not displayed.");
    }

    @And("User checks out using {string} radio button")
    public void userChecksOutUsingRadioButton(String checkOutOption) {
        new CheckoutPage().clickOnRadioButton(checkOutOption);
        new CheckoutPage().clickOnContinueButton();

    }

    @And("enter following details for checkout")
    public void enterFollowingDetailsForCheckout(DataTable dataTable) {
        List<String> userDetails = dataTable.asList(String.class);
        new CheckoutPage().enterFirstName(userDetails.get(0));
        new CheckoutPage().enterLastName(userDetails.get(1));
        new CheckoutPage().enterEmail(userDetails.get(2));
        new CheckoutPage().enterPhone(userDetails.get(3));
        new CheckoutPage().enterAddress(userDetails.get(4));
        new CheckoutPage().enterCity(userDetails.get(5));
        new CheckoutPage().enterPostCode(userDetails.get(6));
        new CheckoutPage().selectCountryFromDropDown(userDetails.get(7));
        new CheckoutPage().selectRegionOrStateFromDropDown(userDetails.get(8));
        new CheckoutPage().clickOnContinueButtonInPaymentMethod();
        new CheckoutPage().enterCommentsAboutOrder(userDetails.get(9));
        new CheckoutPage().clickOnTermsAndConditionsCheckBox();
        new CheckoutPage().clickOnContinueButtonInPaymentMethod();

    }

    @Then("User can view {string} for payment required")
    public void userCanViewForPaymentRequired(String arg0) {
    }
}