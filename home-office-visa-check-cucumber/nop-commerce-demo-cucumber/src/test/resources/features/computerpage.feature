Feature: checking computer feature

  Scenario: verifyUserShouldNavigateToComputerPageSuccessfully
    Given   User is on homepage
    When    User Clicks on Computer tab
    Then    User should see the text"Computers"


  Scenario: verifyUserShouldNavigateToDesktopsPageSuccessfully
    Given   User is on homepage
    When    User Clicks on Computer tab
    And     User clicks on Desktop link
    Then    User should verify the text"Desktops"
@onlytest
  Scenario Outline: : verifyThatUserShouldBuildYouOwnComputerAndAddThemToCartSuccessfully
    Given   User is on homepage
    And     User Clicks on Computer tab
    And     User clicks on Desktop link
    And     User click on Product Build your own computer
    And     User select products "<processor>","<ram>","<hdd>","<os>","<software>" on build your computer page
    And     clicks on Add to cart button
    Then    user should see the message"The product has been added to your shopping cart"
    Examples:
      | processor                                       | ram           | hdd               | os                      | software                   |
      | 2.2 GHz Intel Pentium Dual-Core E2200           | 2 GB          | 320 GB            | Vista Home [+$50.00]    | Microsoft Office [+$50.00] |
      | 2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00] | 4GB [+$20.00] | 400 GB [+$100.00] | Vista Premium [+$60.00] | Acrobat Reader [+$10.00]   |
      | 2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00] | 8GB [+$60.00] | 320 GB            | Vista Home [+$50.00]    | Total Commander [+$5.00]   |

