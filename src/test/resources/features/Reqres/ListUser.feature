Feature: Testing Reqres API for List User Endpoint

  @Latihan
  Scenario Outline: Get list user with valid parameter page reqresAPI
    Given Get list user with page <page>
    When Send request get list user
    Then Should return status code 200
    And Response body page should be <page>
    Examples:
      | page |
      | 1    |
      | 2    |

  @Tugas @NegativeCases
  Scenario Outline: Get list user with invalid parameter page reqresAPI
    Given Get list user with page "<page>"
    When Send request get list user
    Then Should return status code 400
    # BUGS
    And Response body page should be "<page>"
    Examples:
      | page   |
      | 0!!@yp |
      | po04*  |

  @Tugas @NegativeCases
  Scenario Outline: Get list user with exceed maximum page
    Given Get list user with page <page>
    When Send request get list user
    Then Should return status code 404
    # bugs
    And Response body page should be <page>
    Examples:
      | page |
      | 90   |
      | 0    |