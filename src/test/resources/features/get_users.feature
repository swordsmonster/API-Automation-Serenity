@Get
Feature: Get users
  Get registered single users and lists by pages to be able to identify each user

  Scenario: Get page number from user's list
    When I consume the endpoint to get the "page" 2 from the user's list
    Then I get the 200 response code
    And user's schema is according to "GetUsersJsonSchema"
    And user's fields exist for each user

  Scenario: Get one user using the id
    When I consume the endpoint to get the user "id" 4
    Then I get the 200 response code
    And user's schema is according to "GetSingleUserJsonSchema"
    And user fields are not empty