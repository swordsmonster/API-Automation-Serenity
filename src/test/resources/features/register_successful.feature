Feature: Register successful
  Register a new user

  @Post
  Scenario: Register a new user using email and password
    When I consume the endpoint with email "eve.holt@reqres.in" and password "pistol"
    Then I receive the 200 response code
    And user's schema received is according to "PostRegisterSuccessfulJsonSchema"
    And id and token are retrieved