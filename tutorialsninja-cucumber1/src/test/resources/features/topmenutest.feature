Feature: create topmenutest.feature

  Scenario: verifyUserShouldNavigateToDesktopsPageSuccessfully
    Given   User is on homePage
    And     Mouse hover on Desktops tab and click
    When    User clicks on show all desktops from desktopmenu
    Then    User should see the text"Desktops"

    Scenario: verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully
      Given   User is on homePage
      When    User mouse hover Laptops and notebooks and click on tab
      And     Clicks on show all laptops & notebook dropdown
      Then    User should see the message"Laptops & Notebooks"

  Scenario: verifyUserShouldNavigateToComponentsPageSuccessfully
    Given   User is on homePage
    When    UserMouseHove and clicks on Components tab
    And     User clicks on show all components tab
    Then    User should see the headingtext"Components"

