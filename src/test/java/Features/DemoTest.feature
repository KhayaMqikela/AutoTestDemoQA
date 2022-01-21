@DemoTest
Feature: Demo Test Forms
  Scenario Outline: Go To Forms on DemoQA
    #Given that I navigated to the RTFE "PD4" page

    Given I have navigated to DemoQA
    When the user clicks the Forms button
    Then the forms page is displayed
    When the user clicks the forms tab
    Then the practice form tab is displayed
    When the user clicks the practice form tab
    Then the student registration form is displayed
    When the user enters "<first name>" "<last name>" "<email>" "<gender>" "<mobile>" "<date of birth>" "<subjects>" "<hobbies>" "<current address>" "<state>" "<city>"
    And clicks the submit button

    Examples:
      |first name   |last name |email            |gender    |mobile     |date of birth  |subjects         |hobbies |current address|state|city  |
      |Khaya        |Mqikela   |k.mqiks@gmail.com|Male      |0402239445 |11 April 1991  |Commerce         |Sports  |4 Dexter Road  |NCR  |Delhi |

