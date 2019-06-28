
@tag
Feature: Search
  I want to use this template for my feature file


  @Search
  Scenario Outline: searchitem
   Given Enter the "<username>" and "<password>"
    When search the product "head"
   When click the item
    Then check the product is here

    Examples: 
      | username  | password   | 
      |AlexUser   |Alex@123    |
   
