
Feature: Demo Test Online Banking

    @PayeesPageValidation
  Scenario: Navigate to Payees page using navigation menu
    Given I have navigated to DemoQA
    When the user clicks the Menu button
    And the user clicks the Payees link
    Then the Payees page is loaded

  @PayeesPageAddPayee
  Scenario Outline: Verify you can add new payee in the Payees page
    Given I have navigated to DemoQA
    When the user clicks the Menu button
    And the user clicks the Payees link
    Then the Payees page is loaded
    When the user clicks the Add button on the payees page
    Then the Add Payee pop up form is displayed
    When the user enters the "<Payee Name>"
    And the user clicks the text wrapper with text "<Payee Name>"
    And the user enters the "<Account Bank>" "<Account Branch>" "<Account Number>" "<Account Suffix>" number
    And the user clicks the Add button on the form
    Then the Payee Added mesage is displayed
    And the Payee with the name "<Payee Name>" is added in the list of payees

    Examples:
      |Payee Name         |Account Bank  |Account Branch|Account Number|Account Suffix|
      |Khayalethu Mqikela |01            |0001          |0000001       |001           |

  @PayeesPageValidateErrors
  Scenario Outline: Verify you can add new payee in the Payees page
    Given I have navigated to DemoQA
    When the user clicks the Menu button
    And the user clicks the Payees link
    Then the Payees page is loaded
    When the user clicks the Add button on the payees page
    Then the Add Payee pop up form is displayed
    When the user clicks the Add button on the form
    Then the validation error "A problem was found. Please correct the field highlighted below." is displayed
    When the user enters the "<Payee Name>"
    And the user clicks the text wrapper with text "<Payee Name>"
    And the user enters the "<Account Bank>" "<Account Branch>" "<Account Number>" "<Account Suffix>" number
    And the user clicks the Add button on the form
    Then the Payee Added mesage is displayed
    And the Payee with the name "<Payee Name>" is added in the list of payees
    Then the validation error "A problem was found. Please correct the field highlighted below." is not displayed

    Examples:
      |Payee Name         |Account Bank  |Account Branch|Account Number|Account Suffix|
      |Khayalethu Mqikela |01            |0001          |0000001       |001           |

  @PayeesAlphabeticalOrder
  Scenario Outline: Verify you can add new payee in the Payees page
    Given I have navigated to DemoQA
    When the user clicks the Menu button
    And the user clicks the Payees link
    Then the Payees page is loaded
    When the user clicks the Add button on the payees page
    Then the Add Payee pop up form is displayed
    When the user enters the "<Payee Name>"
    And the user clicks the text wrapper with text "<Payee Name>"
    And the user enters the "<Account Bank>" "<Account Branch>" "<Account Number>" "<Account Suffix>" number
    And the user clicks the Add button on the form
    Then the Payee Added mesage is displayed
    And the Payee with the name "<Payee Name>" is added in the list of payees
   And the list of Payees is sorted in Ascending order
    When the user clicks the Name header
    And the list of Payees is sorted in Descending order

    Examples:
      |Payee Name         |Account Bank  |Account Branch|Account Number|Account Suffix|
      |Khayalethu Mqikela |01            |0001          |0000001       |001           |

  @PayTransfer
  Scenario Outline: Verify you can add new payee in the Payees page
    Given I have navigated to DemoQA
    When the user clicks the Menu button
    And the user clicks the Pay or Transfer link
    When the user clicks on the Choose Account from list card
    And the user selects "Everyday" from the list of accounts
    When the user clicks on the Choose Account to card
    And the user selects the accounts tab
    And the user selects "Bills " from the list of accounts to pay to
    And the user inputs "<Amount>" for amount
    Then the user clicks the Transfer button
    And the "<Account>" account decreases by the "<Amount>"

    Examples:
      |Amount         |Account |
      |500            |Everyday|

