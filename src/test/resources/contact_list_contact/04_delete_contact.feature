@Contact
Feature: Delete Contact

  Scenario: User can delete contact via API
    Given set the url for deleting contact
    And set the expected data for deleting contact
    When send the delete request for deleting contact
    Then do assertion for deleting contact
