@regression
Feature: Account Summary pages

  Background:
    Given the user is logged in
    When the user navigate to "Account Summary" tab


  Scenario: Account summary title
    Then "Summary Page" has the title "Zero - Account Summary"

  Scenario: Account types
    Then the page should have following account types
    |Cash Accounts      |
    |Investment Accounts|
    |Credit Accounts    |
    |Loan Accounts      |


    Scenario Outline: "<Account type>" tables should have features
      Then "<Account type>" should have "<column1>" "<column2>" "<column3>"
      Examples:
        | Account type      | column1 | column2    | column3 |
        |Cash Accounts      |Account  |Balance     |         |
        |Investment Accounts|Account |Balance     |         |
        |Credit Accounts    |Account |Credit Card |Balance  |
        |Loan Accounts      |Account |Balance     |         |

  Scenario Outline: "<Account type>" tables should have procedure
    Then "<Account type>" should have "<row1>" "<row2>"
    Examples:
      | Account type      | row1      | row2       |
      |Cash Accounts      |Savings    |Savings     |
      |Investment Accounts|Brokerage  |            |
      |Credit Accounts    |Checking   |Credit Card |
      |Loan Accounts      |Loan       |            |
