Feature: Login feature
  As a user I am able to login using valid credentials

  Scenario: User should navigate to login page successfully
    Given  User is on homepage
    When User clicks on login link
    Then User should navigate to login page successfully

  Scenario: VerifyTheErrorMessageWithInValidCredentials
    Given   User is on homepage
    When    User clicks on login link
    And     User enters email "ltester@gmail.com"
    And     User enters password "abcd123"
    And     User login button
    Then    User should see errorMessage"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found"

  Scenario: verifyThatUserShouldLogInSuccessFullyWithValidCredentials.
    Given   User is on homepage
    When    User clicks on login link
    And     User enters valid email"ltester66@gmail.com"
    And     User enters valid password "abcd123"
    And     User clicks on login button
    Then    User should see Logout link "Log out"

  Scenario: VerifyThatUserShouldLogOutSuccessFully
    Given  User is on homepage
    When   User clicks on login link
    And    User enters correct email"ltester66@gmail.com"
    And    User enters Correct password"abcd123"
    And    User press the login button
    And    User clicks on logout link
    Then   User should see login Link"Log in"


