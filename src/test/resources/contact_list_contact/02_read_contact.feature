@Contact
Feature: Read Contact

  Scenario: User can Read contact via API
    Given set the url for reading contact
    And set the expected data for reading contact
    When send the get request for reading contact
    Then do assertion for reading contact
