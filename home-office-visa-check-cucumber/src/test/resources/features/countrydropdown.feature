Feature: Visa Confirmation functionality
  As a user, I like to verify if the visa is required for my travel

  Scenario: Verify the user is able to see the countries in the
  drop down list after starting the visa check.
    Given User is on the home page
    When User clicks on start button
    Then User can see the following counties in the drop down
      | albania                  |
      | bhutan                   |
      | british-protected-person |
      | haiti                    |
      | kazakhstan               |
      | mozambique               |
      | norway                   |
      | portugal                 |
      | russia                   |
      | zambia                   |
