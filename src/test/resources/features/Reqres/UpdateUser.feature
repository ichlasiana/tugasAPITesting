Feature: Testing Reqres API for Update User Endpoint

@Latihan
Scenario: Put update user with valid json
  Given Put update user with valid json with id 2
  When Send request put update user
  Then Should return status code 200
  And Response body name should be "Hitori Gotoh" and job "Guitarist"
  And Validate json schema update user


@Tugas
  Scenario: Put update user with add more variable
    Given Put update user with valid json that contain more variable with id 5
    When Send request put update user
    Then Should return status code 200
    And Response body name should be "Asuka Langley Soryu",job should be "EVA Pilot", suit should be "Red" and EVA should be "Unit 02"
    And Validate json schema update user with more variable

@Tugas @NegativeCases
Scenario: Put update user with invalid json
  Given Put update user with invalid json with id 2
  When Send request put update user
  Then Should return status code 400

@Tugas @NegativeCases
Scenario Outline: Put update user with invalid path
  Given Put update user with valid json with invalid "<id>"
  When Send request put update user
  Then Should return status code 400
  #BUGS

  Examples:
    | id     |
    | 8%^&09 |

