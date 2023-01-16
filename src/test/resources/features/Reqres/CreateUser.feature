Feature: Testing Reqres for Create New User Endpoint

  @Latihan
  Scenario: Post create new user with valid json
    Given Post create user with valid json
    When Send request post create user
    Then Should return status code 201
    And Response body name should be "Ichlasiana Amallia" and job "student"

  @Tugas
  Scenario: Verify create new user accept special character
    Given Post create user with valid json (contain special character)
    When Send request post create user
    Then Should return status code 201
    And Response body name should be "Kamisato_Ayato!" and job "Yashiro+Commisioner*"

  @Tugas
  Scenario: Verify create new user accept numeric
    Given Post create user with valid json (contain numeric)
    When Send request post create user
    Then Should return status code 201
    And Response body name should be "K43d3r4h4 K42uh4" and job "4nemo"


  @Tugas @NegativeCases
  Scenario: Post create new user with invalid json
    Given Post create user with invalid json
    When Send request post create user
    Then Should return status code 400

  @Tugas @NegativeCases
  Scenario: Post create new user with no content
    Given Post create user with no content json
    When Send request post create user
    Then Should return status code 400