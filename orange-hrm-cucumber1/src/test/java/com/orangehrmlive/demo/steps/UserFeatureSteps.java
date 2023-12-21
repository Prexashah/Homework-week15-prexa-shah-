package com.orangehrmlive.demo.steps;

import com.orangehrmlive.demo.browserfactory.ManageBrowser;
import com.orangehrmlive.demo.pages.pages.AddUserPage;
import com.orangehrmlive.demo.pages.pages.HomePage;
import com.orangehrmlive.demo.pages.pages.LoginPage;
import com.orangehrmlive.demo.pages.pages.ViewSystemUsersPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;

import java.util.List;

public class UserFeatureSteps {

    private static final Logger log = LogManager.getLogger(ManageBrowser.class);


    @When("When User logins with valid email and password")
    public void whenUserLoginsWithValidEmailAndPassword(DataTable dataTable) {
        List<String> credentials = dataTable.asList(String.class);
        new LoginPage().loginToApplication(credentials.get(0), credentials.get(1));

    }

    @And("User clicks on Admin tab")
    public void userClicksOnAdminTab() {
        new HomePage().clickOnAdminTab();
    }

    @Then("User can view {string} text on the home page")
    public void userCanViewTextOnTheHomePage(String heading) {
        Assert.assertEquals(new ViewSystemUsersPage().getSystemUserHeadingText(), heading, "User navigated to wrong page");

    }

    @And("USer clicks on Add button")
    public void userClicksOnAddButton() {
        new ViewSystemUsersPage().clickOnAddUserButton();

    }

    @Then("User can view {string} heading text on Add User page")
    public void userCanViewHeadingTextOnAddUserPage(String text) {
        Assert.assertEquals(new AddUserPage().getAddUserHeadingText(), text, "The page heading is incorrect. ");

    }

    @When("User has logged in as Admin using the following credentials and Add User page")
    public void userHasLoggedInAsAdminUsingTheFollowingCredentialsAndAddUserPage(DataTable dataTable) {
        List<String> credentials = dataTable.asList(String.class);
        new LoginPage().loginToApplication(credentials.get(0), credentials.get(1));
        new HomePage().clickOnAdminTab();
        new ViewSystemUsersPage().clickOnAddUserButton();

    }

    @And("User adds a user with {string},{string} ,{string}, {string},{string}, {string}")
    public void userAddsAUserWith(String role, String employeeName, String userName, String status, String password, String confirmPassword) {
        //Select role
        new AddUserPage().clickUserRoleDropDown();
        new AddUserPage().selectUserRoleFromDropDown(role);

        //Enter Employee name
        new AddUserPage().clickOnEmployeeNameTextBox();
        new AddUserPage().enterHintText(employeeName);
        new AddUserPage().clickOnAutoCompleter();


        //Select status
        new AddUserPage().clickOnStatusDropDown();
        new AddUserPage().selectStatusFromDropDown(status);

        //Enter password
        new AddUserPage().enterPassword(password);

        //Enter confirm password
        new AddUserPage().enterConfirmPassword(confirmPassword);

        //Click on save button
        new AddUserPage().clickOnSaveButton();


    }

    @Then("User can view success message {string}")
    public void userCanViewSuccessMessage(String successMessage) {

        Assert.assertEquals(new AddUserPage().getSuccessToasterMessageText(), successMessage, "User is not added successfully.");
    }

    @And("User searches with {string},{string}, {string}")
    public void userSearchesWith(String userName, String role, String status) {
        new ViewSystemUsersPage().searchUser(userName, role, status);
    }
    //Using Overridden searchUser() method
    @And("User searches with {string},{string}, {string},{string}")
    public void userSearchesWith(String userName, String role,String employeeName, String status) {

        new ViewSystemUsersPage().searchUser(userName,role,employeeName,status);
    }

    @Then("User can view the searched user in the {string} list")
    public void userCanViewTheSearchedUserInTheList(String result) {
        Assert.assertTrue(new ViewSystemUsersPage().getRecordFoundLabelText().contains(result),"Record not found.");

    }

    @And("User deletes the user in the search result")
    public void userDeletesTheUserInTheSearchResult() {
        new ViewSystemUsersPage().clickOnUserNameCheckBox();
        new ViewSystemUsersPage().clickOnDeleteIcon();
        new ViewSystemUsersPage().clickOnConfirmDeleteButton();
    }


    @Then("User can view {string} message")
    public void userCanViewMessage(String successMessage) {
        Assert.assertEquals(new AddUserPage().getSuccessToasterMessageText(),successMessage,"User not deleted successfully.");

    }


    @Then("User can view the searched user in the {string} list and view the {string}")
    public void userCanViewTheSearchedUserInTheListAndViewThe(String result, String userName) {
        Assert.assertTrue(new ViewSystemUsersPage().getRecordFoundLabelText().contains(result),"Record not found.");
        Assert.assertTrue(new ViewSystemUsersPage().getUserNameInRecordText().contains(userName),"User name not found.");

    }
}
