Feature:register.feature

  Scenario:verifyUserShouldNavigateToRegisterPageSuccessfully
    Given User is on the homepage
    When User clicks on register Link
    Then User should see the message"Register"

  Scenario: Mandatory fields validation on registration form
    Given   User is on homepage
    And    User click on register link
    When   User clicks on RegisterButton
    Then   User can see error messages for required fields
      | First name is required. |
      | Last name is required.  |
      | Email is required.      |
      | Password is required.   |
      | Password is required.   |

  Scenario: verifyThatUserShouldCreateAccountSuccessfully
    Given   User is on homepage
    When    User click on register link
    And     Select gender as female
    And     User enter FirstName "Alice"
    And     User enter lastname "Smith"
    And     User select day of birth"6"
    And     user select month of birth"June"
    And     User select year of birth"1986"
    And     User enter email"alice@gmail.com"
    And     User enter password"abcd123"
    And     User enter confirm Password"abcd123"
    And     User click on the Register button
    Then    User should verify the message"Your registration completed"






