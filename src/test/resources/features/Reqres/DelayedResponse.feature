Feature: Testing Reqres API for Delayed Response Endpoint

  @Tugas
  Scenario Outline: Get delayed response for example seconds
    Given Get delayed response with delay <delay>
    When Send request get delayed response
    Then Should return status code 200
    Examples:
      | delay |
      | 3     |
      | 5     |

  @Tugas @NegativeCase
  Scenario Outline: Get delayed response with String input
    Given Get delayed response with String delay "<delay>"
    When Send request get delayed response
    Then Should return status code 400
    #BUGS
    Examples:
      | delay    |
      | asdaasd# |
      | @345     |