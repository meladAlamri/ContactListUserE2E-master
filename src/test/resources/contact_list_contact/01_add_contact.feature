@Contact
Feature: Add Contact

  Scenario: User can add contact via API
    Given set the url for adding contact
    And set the expected data for adding contact
    When send the post request for adding contact
    Then do assertion for adding contact
