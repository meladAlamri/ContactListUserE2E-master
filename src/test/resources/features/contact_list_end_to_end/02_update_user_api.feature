@End2End
Feature: Update User

  Scenario: User can update the user via API
    Given set the url for update
    And set the expected data for update
    When send the patch request for update
    Then do assertion for update
