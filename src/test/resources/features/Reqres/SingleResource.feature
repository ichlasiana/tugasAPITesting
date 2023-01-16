Feature: Testing Reqres API for Single Resource Endpoint

  @Tugas
  Scenario Outline: Get single resource with valid id
    Given Get single resource with id <id>
    When Send request get single resource
    Then Should return status code 200
    And Validate json schema single resource
    Examples:
      | id |
      | 1 |
      | 2 |

  @Tugas @NegativeCase
  Scenario Outline: Get list user with invalid parameter page
    Given Get single resource with invalid id "<id>"
    When Send request get single resource
    Then Should return status code 404
    Examples:
      | id       |
      | asdaasd# |
      | 121212   |