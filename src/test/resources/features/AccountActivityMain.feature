@regression
Feature: Account Activity pages features
  Background:
    Given the user is logged in
    Then the user navigate to "Account Activity" tab


    Scenario: Account Activity Title
      Then "Account Activity" has the title "Zero - Account Activity"


    Scenario: In the Account drop down default option should be Savings
      Then In the "Account" drop down default option should be "Savings"

    Scenario: Account drop down should have the following options: Savings, Checking, Loan, Credit Card, Brokerage
      Then "Account" drop down should have the following options:
    |Savings|
    |Checking|
    |Loan    |
    |Credit Card|
    |Brokerage  |