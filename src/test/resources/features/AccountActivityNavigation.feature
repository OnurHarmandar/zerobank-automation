@regression
Feature: Navigating to specific accounts in Accounts Activity

  Scenario: Savings account redirect
    Given the user is logged in
    When the user clicks on "Savings" link on the Account Summary page
    Then the "Account Activity" page should be displayed
    And In the "Account" drop down default option should be "Savings"

  Scenario: Brokerage account redirect
    Given the user is logged in
    When the user clicks on "Brokerage" link on the Account Summary page
    Then the "Account Activity" page should be displayed
    And In the "Account" drop down default option should be "Brokerage"

  Scenario: Checking account redirect
    Given the user is logged in
    When the user clicks on "Checking" link on the Account Summary page
    Then the "Account Activity" page should be displayed
    And In the "Account" drop down default option should be "Checking"

  Scenario: Credit Card account redirect
    Given the user is logged in
    When the user clicks on "Credit Card" link on the Account Summary page
    Then the "Account Activity" page should be displayed
    And In the "Account" drop down default option should be "Credit Card"

  Scenario: Loan account redirect
    Given the user is logged in
    When the user clicks on "Loan" link on the Account Summary page
    Then the "Account Activity" page should be displayed
    And In the "Account" drop down default option should be "Loan"



