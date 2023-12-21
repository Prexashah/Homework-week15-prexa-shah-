Feature: My Accounts
  As a user, I would like to use all the options from My Account

  Background:   Background: User is on Home page
    Given User navigates to homepage

  Scenario: Verify the user is able to navigate to register page successfully
    When User clicks on My Account link
    And User selects "Register" from the drop down
    Then User should be able to view "Register Account" heading in the navigated page

  Scenario: Verify the user is able to navigate to Login page successfully
    When User clicks on My Account link
    And User selects "Login" from the drop down
    Then User should be able to view "Returning Customer" sub heading in the navigated page

  Scenario: Verify the user is able to navigate to register page and register successfully
    When User clicks on My Account link
    And User selects "Register" from the drop down
    And User enters the following details in the register account page and submits
      | Maria       |
      | Roshan      |
      | 0771558867  |
      | Password1   |
      | Password1   |
      | Yes         |
    Then User can view "Your Account Has Been Created!" message in Account Success page

  Scenario: Verify the user is able to register and logout successfully.
    When User clicks on My Account link
    And User selects "Register" from the drop down
    And User enters the following details in the register account page and submits
      | Maria       |
      | Roshan      |
      | 0771558867 |
      | Password1   |
      | Password1   |
      | Yes         |
    And User clicks on Continue button on account Register Success page
    And User clicks on My Account link
    And User selects "Logout" from the drop down
    Then User can view "Account Logout" text in the heading

  Scenario: Verify the user is able to login with valid credentials successfully.
    When User clicks on My Account link
    And User selects "Login" from the drop down
    And User logs in with the following credentials
      | ltester9@gmail.com   |
      | Password1            |
    Then User is able to view "My Account" message












