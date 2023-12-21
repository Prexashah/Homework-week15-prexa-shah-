package com.tutorialsninja.demo.steps;

import com.tutorialsninja.demo.pages.ComponentPage;
import com.tutorialsninja.demo.pages.DesktopPage;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.Laptops_NotebooksPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class TopMenuTestSteps {
    @Given("User is on homePage")
    public void userIsOnHomePage() {

    }

    @And("Mouse hover on Desktops tab and click")
    public void mouseHoverOnDesktopsTabAndClick() {
        new HomePage().mouseHoverAndClickDesktopTab();
    }

    @When("User clicks on show all desktops from desktopmenu")
    public void userClicksOnShowAllDesktopsFromDesktopmenu() {
        new HomePage().clickOnShowAllDesktops();
    }

    @Then("User should see the text{string}")
    public void userShouldSeeTheText(String desktopsText) {
        Assert.assertEquals(new DesktopPage().verifyTheTextDesktops(), desktopsText, "User is not on destop page");
    }


    @When("User mouse hover Laptops and notebooks and click on tab")
    public void userMouseHoverLaptopsAndNotebooksAndClickOnTab() {
        new HomePage().mouseHoverOnLaptopsNoteBooksAndClick();
    }

    @And("Clicks on show all laptops & notebook dropdown")
    public void clicksOnShowAllLaptopsNotebookDropdown() {
        new HomePage().showAllLaptopsAndNoteBooks();
    }

    @Then("User should see the message{string}")
    public void userShouldSeeTheMessage(String verifyText) {
        Assert.assertEquals(new Laptops_NotebooksPage().verifyTheTextDLaptopsAndNoteBooks(),verifyText,"user is not on Laptops and notebook page");
    }

    @When("UserMouseHove and clicks on Components tab")
    public void usermousehoveAndClicksOnComponentsTab() {
        new HomePage().mouseHoverOnComponentsTabAndClick();
    }

    @And("User clicks on show all components tab")
    public void userClicksOnShowAllComponentsTab() {
        new HomePage().clickOnShowAllComponentsTab();
    }

    @Then("User should see the headingtext{string}")
    public void userShouldSeeTheHeadingtext(String verifyText) {
        Assert.assertEquals(new ComponentPage().verifyTheTextComponents(),verifyText,"user is not on component page");
    }
}
