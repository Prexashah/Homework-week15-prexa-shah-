package com.nopcommerce.demo.steps;

import com.nopcommerce.demo.browserfactory.ManageBrowser;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.RegisterPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class RegisterSteps {

    private static final Logger log = LogManager.getLogger(ManageBrowser.class);


    @Given("User is on the homepage")
    public void userIsOnTheHomepage() {
        new HomePage().clickOnRegisterLink();

    }

    @When("User clicks on register Link")
    public void userClicksOnRegisterLink() {
        new HomePage().clickOnRegisterLink();
    }

    @Then("User should see the message{string}")
    public void userShouldSeeTheMessage(String registerMessage) {
        new RegisterPage().verifyRegisterText();
    }


    @And("User click on register link")
    public void userClickOnRegisterLink() {
        new HomePage().clickOnRegisterLink();
    }

    @When("User clicks on RegisterButton")
    public void userClicksOnRegisterButton() {
        new RegisterPage().clickOnRegisterButton();
    }

    @Then("User can see error messages for required fields")
    public void userCanSeeErrorMessagesForRequiredFields(DataTable dataTable) {
        log.info("verify all the error messages.....");
        //create an array list to store all the actual error messages
        List<String> actualErrorMessages = new ArrayList<>();
        actualErrorMessages.add(new RegisterPage().verifyErrorMessageFirstNameIsRequired());
        actualErrorMessages.add(new RegisterPage().verifyErrorMessageLastNameIsRequired());
        actualErrorMessages.add(new RegisterPage().verifyErrorMessageEmailNameIsRequired());
        actualErrorMessages.add(new RegisterPage().verifyErrorMessagePasswordIsRequired());
        actualErrorMessages.add(new RegisterPage().verifyErrorMessageConfirmPasswordIsRequired());

        //Obtain the expected error message from data table and compare with actual using assert class
        List<String> errorMessagesList = dataTable.asList(String.class);
        int index = 0;
        for (String message : errorMessagesList) {
            Assert.assertEquals(actualErrorMessages.get(index), message, "  ");
            index++;
        }


    }


    @And("Select gender as female")
    public void selectGenderAsFemale() {
        new RegisterPage().clickOnFemaleRadioBtn();
    }
    @And("User enter FirstName {string}")
    public void userEnterFirstName(String FirstName) {
        new RegisterPage().enterFirstName(FirstName);
    }

    @And("User enter lastname {string}")
    public void userEnterLastname(String lastname) {
        new RegisterPage().enterLastName(lastname);
    }
    @And("User select day of birth{string}")
    public void userSelectDayOfBirth(String text) {
        new RegisterPage().selectDayFromDropDown(text);
    }

    @And("user select month of birth{string}")
    public void userSelectMonthOfBirth(String text) {
        new RegisterPage().selectMonthFromDropDown(text);
    }

    @And("User select year of birth{string}")
    public void userSelectYearOfBirth(String text) {
        new RegisterPage().selectYearFromDropDown(text);
    }


    @And("User enter email{string}")
    public void userEnterEmail(String email) {
        new RegisterPage().enterEmail(email);
    }
    @And("User enter password{string}")
    public void userEnterPassword(String password) {
        new RegisterPage().enterPassword(password);
    }

    @And("User enter confirm Password{string}")
    public void userEnterConfirmPassword(String confirmPassword) {
        new RegisterPage().enterConfirmPassword(confirmPassword);
    }


    @And("User click on the Register button")
    public void userClickOnTheRegisterButton() {
        new RegisterPage().clickOnRegisterButton();
    }

    @Then("User should verify the message{string}")
    public void userShouldVerifyTheMessage(String regMessage) {
        Assert.assertEquals(new RegisterPage().verifyYourRegistrationCompleted(),regMessage,"user has not Register successfully");
    }



}