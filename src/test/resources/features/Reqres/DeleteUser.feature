Feature: Testing Reqres API for Delete Endpoint

  @Latihan
  Scenario Outline: Delete users with valid id
    Given Delete user with valid id <id>
    When Send request delete user
    Then Should return status code 204
    Examples:
      | id |
      | 1  |
      | 2  |


  @Tugas @NegativeCases
  Scenario Outline: Delete users with invalid id
    Given Delete user with invalid name "<id>"
    When Send request delete user
    Then Should return status code 400
    # BUGS
    Examples:
      | id      |
      | @@!01  |
      | 2*+3ab |
