Feature: Get single user
  Retrieve one user using the id

  @GetSingle
  Scenario: Get one user using the id
    When I consume the endpoint with the user id 4
    Then the 200 response code received
    And schema received is according to "GetSingleUserJsonSchema"
    And data values are not empty