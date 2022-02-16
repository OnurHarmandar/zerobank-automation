@regression
Feature: Find Transactions in Account Activity Scenario: Search date range
  Background: the user logged in
    Given the user is logged in
    When the user navigate to "Pay Bills" tab

  Scenario: Pay Bills Title
    Then "Pay Biils" has the title "Zero - Pay Bills"

  Scenario: When user completes a successful Pay operation, The payment was successfully submitted. should be displayed.
  Given the user selects "Sprint" for "Payee"
  And the user selects "Savings" for "Account"
  And the user adds "100" to "Amount" inputbox
  And the user adds "2012-09-06" to "Date" inputbox
  And the user adds "ONLINE TRANSFER" to "Description" inputbox
  And clicks search
  Then message "The payment was successfully submitted." should be displayed


  Scenario: When user tries to make a payment without entering all fields, Please fill out this field message! should be displayed.
    Then the user adds "2012-09-06" to "Date" inputbox
    Then the user adds "ONLINE TRANSFER" to "Description" inputbox
    And clicks search
    Then "Please fill out this field." alert should displayed on "Amount"

  Scenario: When user tries to make a payment without entering all fields, Please fill out this field message! should be displayed.
    Then the user adds "100" to "Amount" inputbox
    Then the user adds "ONLINE TRANSFER" to "Description" inputbox
    And clicks search
    Then "Please fill out this field." alert should displayed on "Date"


  Scenario: Amount field should not accept alphabetical or special characters
    Then the user adds "User ?#$½" to "Amount" inputbox
    And the user adds "2012-09-06" to "Date" inputbox
    And the user adds "ONLINE TRANSFER" to "Description" inputbox
    And clicks search
    Then message "The payment was successfully submitted." should NOT be displayed


  Scenario: Date field should not accept alphabetical or special characters
    Then the user adds "User é!'^^+" to "Amount" inputbox and cuts the value
    Then the user adds "100" to "Amount" inputbox
    And the user adds the firs input of amount to Date inputbox by cut+paste fromkeyboard
    And the user adds "ONLINE TRANSFER" to "Description" inputbox
    And clicks search
    Then message "The payment was successfully submitted." should NOT be displayed