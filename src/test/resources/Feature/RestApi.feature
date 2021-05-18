Feature: There is some description need to be added later

  Scenario: As a user I expect to get authorisation error when I request data with wrong credentials
    Given I have REST API
    And I am authorized with "wrong_auth.data"
    When request record by "60815eae56c62a0c0e8a68d5"
    Then response status is 401

  Scenario: As a user I want to be able to get data from the REST API
    Given I have REST API
    And I am authorized with "auth.data"
    When request record by "60815eae56c62a0c0e8a68d5"
    Then response status is 200
    And I got a data from the REST API which is looks like "location.json"

  Scenario: As a user I expect to get "not found" error when I request data from the REST API with wrong id
    Given I have REST API
    And I am authorized with "auth.data"
    When request record by "60815eae56c62a0c0e8a6834"
    Then response status is 404

  Scenario: As a user I expect to get "wrong format" error when I request data from the REST API with wrong id format
    Given I have REST API
    And I am authorized with "auth.data"
    When request record by "60815eae56c62a0c0e8a6"
    Then response status is 422
