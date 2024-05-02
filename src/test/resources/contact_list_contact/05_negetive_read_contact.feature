@Contact
Feature: Negative raed Contact

  Scenario: User can check if contact delete via API
    Given set the url for reading contact
    And set the expected data for reading contact
    When send the get request for reading contact
    Then do assertion for negative reading contact
