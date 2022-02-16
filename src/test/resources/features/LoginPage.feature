@regression
Feature: Login with Valid Credentials but Can Not Login with invalid credentials


  Scenario: Login with clicking on Sign in button
    When user enters "username" as username
    And user enters "password" as password
    And user clicks on Sign in button
    Then verify that user successfully loged in

  Scenario: Login with clicking on Enter button on keyboard
    When user enters "username" as username
    And user enters "password" as password
    And user clicks on Enter button on keyboard
    Then verify that user successfully loged in

  Scenario Outline: Can Not login with valid credentials
    Given user enters invalid "<userName>" as username
    And user enters invalid "<Password>" as password
    When user clicks on Sign in button
    Then "Login and/or password are wrong." message is displayed
    And header change as "Troubles entering the site?"

    Examples:
      |userName  |Password|
      |username  |        |
      |          |password|
      |user      |pass    |
      |          |        |


  Scenario Outline: User forgets password
    Given the user navigate to "Forgot your password ?" tab
    Then "So you forgot your password? Give us your email address and we will email it to you." message dissappears
    Then user enters a valid "<email>"
    And user clicks on Send Password button
    Then "Your password will be sent to the following email:" "<email>" message dissappears

    Examples:
      | email |
      |mike@smith.com|





