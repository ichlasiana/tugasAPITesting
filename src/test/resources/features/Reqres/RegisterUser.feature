Feature: Testing Reqres for Register User Endpoint

  @Tugas
  Scenario: Post register user with valid json
    Given Post register user with valid json
    When Send request post register user
    Then Should return status code 200
    And Validate showing id and token as json schema register user


  @Tugas @NegativeCases
  Scenario: Post register user with invalid json
    Given Post register user with invalid json
    When Send request post register user
    Then Should return status code 400

  @Tugas @NegativeCases
  Scenario: Post register user with different email and password from example
    Given Post register user with different email and password
    When Send request post register user
    Then Should return status code 400
    And Validate showing error message as json schema register user

  @Tugas @NegativeCases
  Scenario: Post register user with only email
    Given Post register user with only email
    When Send request post register user
    Then Should return status code 400
    And Validate showing error message as json schema register user

  @Tugas @NegativeCases
  Scenario: Post register user with only password
    Given Post register user with only password
    When Send request post register user
    Then Should return status code 400
    And Validate showing error message as json schema register user

  @Tugas @NegativeCases
  Scenario: Post register user with invalid data
    Given Post register user with invalid data
    When Send request post register user
    Then Should return status code 400
    And Validate showing error message as json schema register user