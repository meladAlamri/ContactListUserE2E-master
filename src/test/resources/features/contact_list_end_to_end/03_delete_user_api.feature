@End2End
Feature: Delete User
  Scenario: User can delete the user via API
    Given set the url for delete
    When send the delete request
    Then do assertion for delete

