@End2End
Feature: Create User

  Scenario: Create User Selenium
    Given user goes to "https://thinking-tester-contact-list.herokuapp.com/"
    When user clicks on sign up button
    And User enters firstname, lastname, email, password
    And user clicks on submit button
    And user closes browser
    Then verify the user via API request