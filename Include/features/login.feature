Feature: Login

  Background: 
    Given user is already on the login page

  Scenario: user can login with valid credentials
    When user input username password and click login button
    Then user can successfully login

  Scenario Outline: user cannot login with invalid credentials
    When user input <condition> in login page
    And user click login button
    Then user get pop up <result>

    Examples: 
      | condition                        | result                                                                    |
      | valid email and ivalid password  | Epic sadface: Username and password do not match any user in this service |
      | invalid email and valid password | Epic sadface: Username and password do not match any user in this service |
