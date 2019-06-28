
@tag
Feature: Register
  I want to use this template for my feature file

  @register
  Scenario: PassTheData
   Given open the testMe Application
    When  Enter the details 
    |username    | firstname|lastname|password  |conformpsd|mail          |mobile     |address               |
    | AlexUser   |Alex      |Pandian |Alex@123  |Alex@123  |Alex@gmail.com|9595959595 | dubai main road,Dubai| 
    And   click the Register Button
    Then  get the login Page
  
