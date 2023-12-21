package com.orangehrmlive.demo.steps;

import com.orangehrmlive.demo.pages.pages.HomePage;
import com.orangehrmlive.demo.pages.pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;

public class LoginTestSteps {
    @When("User logins with valid email and password")
    public void userLoginsWithValidEmailAndPassword(DataTable dataTable) {
        List<String> credentials = dataTable.asList(String.class);
        new LoginPage().loginToApplication(credentials.get(0), credentials.get(1));

    }

    @Then("User is able to view {string} message")
    public void userIsAbleToViewMessage(String dashboardMessage) {
        Assert.assertEquals(new HomePage().getDashboardTitleText(), dashboardMessage, "User is not logged in.");
    }


    @Then("User can view the logo on the homepage")
    public void userCanViewTheLogoOnTheHomepage() {

        Assert.assertTrue(new LoginPage().getLogoElement().isDisplayed(), "Logo is not displayed.");
    }


    @And("User logs out by clicking {string}")
    public void userLogsOutByClicking(String logout) {

        new HomePage().clickOnUserProfileLogo();
        new HomePage().clickOnDropDownOptions(logout);
    }

    @Then("User can view {string} panel")
    public void userCanViewPanel(String loginText) {
        Assert.assertEquals(new LoginPage().getLoginPanelHeadingText(), loginText, "User is not logged out successfully.");

    }


    @And("User clicks on Login button")
    public void userClicksOnLoginButton() {
        new LoginPage().clickOnLoginButton();

    }

    @Then("User can view {string} error message")
    public void userCanViewErrorMessage(String errorMessage) {
        Assert.assertEquals(new LoginPage().getErrorMessageForUserNameRequiredField(), errorMessage, "Error message not displayed for username field.");
        Assert.assertEquals(new LoginPage().getErrorMessageForPasswordRequiredField(), errorMessage, "Error message not displayed for username field.");
    }


    @And("User enters {string} in username field")
    public void userEntersInUsernameField(String userName) {
        new LoginPage().enterUserName(userName);
    }

    @And("User enters {string} in password field")
    public void userEntersInPasswordField(String password) {

        new LoginPage().enterPassword(password);
    }

    @Then("User can view {string} error message for {string} and {string}")
    public void userCanViewErrorMessageForAnd(String errorMessage, String userName, String password) {
        if (userName.isEmpty() && password.isEmpty()) {
            Assert.assertEquals(new LoginPage().getErrorMessageForUserNameRequiredField(), errorMessage, "Error message for blank username is not displayed.");
            Assert.assertEquals(new LoginPage().getErrorMessageForPasswordRequiredField(), errorMessage, "Error message for blank password is not displayed.");
        } else if (userName.isEmpty()) {
            Assert.assertEquals(new LoginPage().getErrorMessageForUserNameRequiredField(), errorMessage, "Error message for blank username is not displayed.");
        } else if (password.isEmpty()) {
            Assert.assertEquals(new LoginPage().getErrorMessageForPasswordRequiredField(), errorMessage, "Error message for blank password is not displayed.");
        }else
            Assert.assertEquals(new LoginPage().getErrorMessageForInvalidCredentials(),errorMessage,"Error message for invalid username and password is not displayed.");
    }


}
