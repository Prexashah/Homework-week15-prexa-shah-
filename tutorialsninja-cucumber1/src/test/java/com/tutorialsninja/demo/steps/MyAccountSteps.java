package com.tutorialsninja.demo.steps;

import com.tutorialsninja.demo.browserfactory.ManageBrowser;
import com.tutorialsninja.demo.pages.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class MyAccountSteps {
    private static final Logger log = Logger.getLogger(ManageBrowser.class);

    @When("User clicks on My Account link")
    public void userClicksOnMyAccountLink() {
        new HomePage().clickOnMyAccountLink();

    }

    @And("User selects {string} from the drop down")
    public void userSelectsFromTheDropDown(String dropDownOption) {
        List<WebElement> allMyAccountOptions = new HomePage().getMyAccountOptions();
        for (WebElement e : allMyAccountOptions) {
            System.out.println("Options in dropdown: " + e.getText());//Debug purpose
            if (e.getText().equalsIgnoreCase(dropDownOption)) {
                e.click();
                break;
            }
        }
    }

    @Then("User should be able to view {string} heading in the navigated page")
    public void userShouldBeAbleToViewHeadingInTheNavigatedPage(String heading) {
        Assert.assertEquals(new RegisterPage().getRegisterPageHeadingText(), heading, "Navigated to wrong page.");

    }

    @Then("User should be able to view {string} sub heading in the navigated page")
    public void userShouldBeAbleToViewSubHeadingInTheNavigatedPage(String subHeading) {
        Assert.assertEquals(new LoginPage().getReturningCustomerHeadingText(), subHeading, "Navigated to wrong page.");

    }

    @And("User enters the following details in the register account page and submits")
    public void userEntersTheFollowingDetailsInTheRegisterAccountPageAndSubmits(DataTable dataTable) {

        List<String> userAccountDetails = dataTable.asList(String.class);
        new RegisterPage().enterFirstName(userAccountDetails.get(0));
        new RegisterPage().enterLastName(userAccountDetails.get(1));
        String randomEmail = new RegisterPage().getRandomString() + "ltester9@gmail.com";
        new RegisterPage().enterEmail(randomEmail);
        new RegisterPage().enterPhone(userAccountDetails.get(2));
        new RegisterPage().enterPassword(userAccountDetails.get(3));
        new RegisterPage().enterConfirmPassword(userAccountDetails.get(4));
        new RegisterPage().clickOnNewsLetterRadioButton(userAccountDetails.get(5));
        new RegisterPage().clickOnPrivacyPolicyCheckBox();
        log.info("Clicking on continue button....");
        new RegisterPage().clickOnContinueButton();
    }


    @Then("User can view {string} message in Account Success page")
    public void userCanViewMessageInAccountSuccessPage(String message) {
        Assert.assertEquals(new YourAccountCreatedPage().getRegisterSuccessMessageText(), message, "Account is not created successfully.");

    }

    @And("User clicks on Continue button on account Register Success page")
    public void userClicksOnContinueButtonOnAccountRegisterSuccessPage() {
        new YourAccountCreatedPage().clickOnContinueButton();
    }

    @Then("User can view {string} text in the heading")
    public void userCanViewTextInTheHeading(String logoutLink) {
        Assert.assertEquals(new LogOutPage().getLogOutHeadingText(), logoutLink, "User is navigated to wrong page.");

    }

    @And("User logs in with the following credentials")
    public void userLogsInWithTheFollowingCredentials(DataTable dataTable) {
        List<String> loginCredentials = dataTable.asList(String.class);
        new ReturningCustomerPage().enterEmail(loginCredentials.get(0));
        new ReturningCustomerPage().enterPassword(loginCredentials.get(1));
        new ReturningCustomerPage().clickOnLoginButton();
    }

    public void userIsAbleToViewTextHeading(String accountHeading) {
        log.info("Verifying page heading after log in....");
        Assert.assertEquals(new AccountPage().getMyAccountHeadingText(), accountHeading, "User is not logged in.");
    }

    public void userSelectsFromMyAccount(String accountOption) {
        log.info("Selecting drop down option from My Account....");
        new HomePage().clickOnMyAccountLink();

    }

    @Then("User is able to view {string} message")
    public void userIsAbleToViewMessage(String accountLogOutText) {
        Assert.assertEquals(new LogOutPage().getLogOutHeadingText(), accountLogOutText, "The logout is not successful.");


    }
}