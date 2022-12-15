Feature: User login,and purchase an order
  In order to be able to do purchases on the web application,
  As a valid user, I must be able to login and land on the web application

  Scenario Outline: User navigates to the webpage to login
    Given The Webpage is displayed for user
    Then User enters "<username>" and "<password>"
    And The user is logged on to the web application
    And The user adds the items to purchase
    Then The user goes to the cart
    Then The user finishes the order
    Then User enters "<firstname>", "<lastname>", "<zip>",
    And User clicks continue button
    Then User clicks finish button
    Then User goes back to home page



    Examples:
    |username      | password       | firstname | lastname  | zip  |
    |standard_user | secret_sauce   | Jabulani  | Mtungwa   | 2001 |