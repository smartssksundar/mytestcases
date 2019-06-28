
@tag
Feature: Login
  I want to use this template for my feature file


  @login
  Scenario Outline: datatable
    Given Enter to the login Page
    When Enter the username "<Username>"
    And Enter the password "<Password>"
    And Click the Signin button
    Then get the home page

    Examples: 
      | Username | Password   |
      |AlexUser  |Alex@123    |
     
