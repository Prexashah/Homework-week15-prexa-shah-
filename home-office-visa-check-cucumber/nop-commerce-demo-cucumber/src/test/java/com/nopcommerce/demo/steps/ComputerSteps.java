package com.nopcommerce.demo.steps;

import com.nopcommerce.demo.pages.BuildYourOwnComputerPage;
import com.nopcommerce.demo.pages.ComputerPage;
import com.nopcommerce.demo.pages.DesktopsPage;
import com.nopcommerce.demo.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ComputerSteps {
    @When("User Clicks on Computer tab")
    public void userClicksOnComputerTab() {
        new HomePage().clickOnComputerTab();
    }


    @Then("User should see the text{string}")
    public void userShouldSeeTheText(String computer) {
        Assert.assertEquals(new ComputerPage().verifyComputerTab(), computer, " user is not on computer page");
    }


    @And("User clicks on Desktop link")
    public void userClicksOnDesktopLink() {
        new ComputerPage().clickOnDeskTopLink();
    }

    @Then("User should verify the text{string}")
    public void userShouldVerifyTheText(String desktop) {
        Assert.assertEquals(new ComputerPage().verifyDesktopTxt(), desktop, "User is not on Desktop page");
    }

    @And("User click on Product Build your own computer")
    public void userClickOnProductBuildYourOwnComputer() {
        new DesktopsPage().clickOnBuildYourComputer();
    }

    @And("User select products {string},{string},{string},{string},{string} on build your computer page")
    public void userSelectProductsOnBuildYourComputerPage(String processor, String ram, String hdd, String os, String software) {
        new BuildYourOwnComputerPage().selectProcessor(processor);
        new BuildYourOwnComputerPage().selectRAM(ram);
        new BuildYourOwnComputerPage().clickOnHddRadioButton(hdd);
        new BuildYourOwnComputerPage().selectOsRadioCheckBox(os);
        new BuildYourOwnComputerPage().selectSoftwareCheckBox(software);
    }

    @And("clicks on Add to cart button")
    public void clicksOnAddToCartButton() {
        new BuildYourOwnComputerPage().clickOnAddToCartBtn();
    }

    @Then("user should see the message{string}")
    public void userShouldSeeTheMessage(String messageAddToCart) {
        Assert.assertEquals(new BuildYourOwnComputerPage().verifyTheMessageAddToCart(),messageAddToCart,"The Products are not in the shopping cart");
    }
}
