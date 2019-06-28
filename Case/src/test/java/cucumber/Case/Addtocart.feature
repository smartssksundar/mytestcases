
@tag
Feature: AddtoCart
  I want to use this template for my feature file

  

  @Addtocart
  Scenario Outline: Fails
    Given Signin the page "<username>" and "<password>"
    When search the products <head>
    And Try to pay withour add that item
    Then Testme didn't display that icon
    Examples:
    |username   |password   |
    |AlexUser   |Alex@123   |
   

   @Passthat
   Scenario Outline: pass
    Given Signin the pages "<usernames>" and "<passwords>"
    When search the product <head>
    And add the product in the cart
    Then find the cart icon
    Examples:
    |usernames   |passwords   |
    |AlexUser    |Alex@123    |
  