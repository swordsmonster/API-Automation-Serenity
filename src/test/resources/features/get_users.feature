Feature: Get users
  Get all registered users list by pages to be able to identify each user

  Scenario: Get page number from user's list
    When I consume the endpoint to get the page 2 from the user's list
    Then I get the 200 response code
    And user's schema is according to "GetUsersJsonSchema"
    And user's fields exist for each user