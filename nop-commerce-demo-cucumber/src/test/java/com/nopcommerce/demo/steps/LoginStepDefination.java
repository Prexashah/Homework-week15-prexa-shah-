package com.nopcommerce.demo.steps;

import com.nopcommerce.demo.browserfactory.ManageBrowser;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;

public class LoginStepDefination {

    private static final Logger log = LogManager.getLogger(ManageBrowser.class);

    @Given("User is on homepage")
    public void userIsOnHomepage() {
        new HomePage().clickOnLoginLink();
        log.info("Home page displayed");

    }

    @When("User clicks on login link")
    public void userClicksOnLoginLink() {
        new HomePage().clickOnLoginLink();
        log.info("Clicked on login button");
    }

    @Then("User should navigate to login page successfully")
    public void userShouldNavigateToLoginPageSuccessfully() {
        Assert.assertEquals(new LoginPage().verifyWelcomeMsg(), "Welcome, Please Sign In!", "User is not Logged In");
        log.info("Welcome message");
    }

    @And("User enters email {string}")
    public void userEntersEmail(String email) {
        new LoginPage().enterEmailId(email);
    }


    @And("User enters password {string}")
    public void userEntersPassword(String password) {
        new LoginPage().enterPassword(password);
    }

    @And("User login button")
    public void userLoginButton() {
        new LoginPage().clickOnLoginBtn();
    }


    @Then("User should see errorMessage{string}")
    public void userShouldSeeErrorMessage(String errorMessage) {
        Assert.assertEquals(new LoginPage().verifyErrorMessage(), errorMessage, " The error message is not display");
    }

    @And("User enters valid email{string}")
    public void userEntersValidEmail(String email) {
        new LoginPage().enterEmailId(email);
    }

    @And("User enters valid password {string}")
    public void userEntersValidPassword(String password) {
        new LoginPage().enterPassword(password);
    }

    @And("User clicks on login button")
    public void userClicksOnLoginButton() {
        new LoginPage().clickOnLoginBtn();
    }

    @Then("User should see Logout link {string}")
    public void userShouldSeeLogoutLink(String logoutLink) {
        Assert.assertEquals(new HomePage().verifyThatLogOutLinkIsDisplay(), logoutLink, "User has entered incorrect details");
    }

    @And("User enters correct email{string}")
    public void userEntersCorrectEmail(String email) {
        new LoginPage().enterEmailId(email);
    }

    @And("User enters Correct password{string}")
    public void userEntersCorrectPassword(String password) {
        new LoginPage().enterPassword(password);
    }

    @And("User press the login button")
    public void userPressTheLoginButton() {
        new LoginPage().clickOnLoginBtn();
    }

    @And("User clicks on logout link")
    public void userClicksOnLogoutLink() {
        new HomePage().clickOnLogOutLink();
    }

    @Then("User should see login Link{string}")
    public void userShouldSeeLoginLink(String loginLink) {
        Assert.assertEquals(new HomePage().verifyThatLoginLinkIsDisplay(),loginLink,"User successfully logged out");
    }
}