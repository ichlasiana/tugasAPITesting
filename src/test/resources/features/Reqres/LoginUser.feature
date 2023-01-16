Feature: Testing Reqres for Login User Endpoint

  @Tugas
  Scenario: Post login user with valid json
    Given Post login user with valid json
    When Send request post login user
    Then Should return status code 200


# negative TC
  @Tugas
  Scenario: Post login user with invalid json
    Given Post login user with invalid json
    When Send request post login user
    Then Should return status code 400

  @Tugas
  Scenario: Post login user with invalid email
    Given Post login user with invalid email
    When Send request post login user
    Then Should return status code 400

  @Tugas
  Scenario: Post login user with only email
    Given Post login user with only email
    When Send request post login user
    Then Should return status code 400

  @Tugas
  Scenario: Post login user with only password
    Given Post login user with only password
    When Send request post login user
    Then Should return status code 400

  @Tugas
  Scenario: Post login user with invalid account
    Given Post login user with invalid account
    When Send request post login user
    Then Should return status code 400