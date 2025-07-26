@one
Feature: Testing featue file one

  @ScenarioOne
  Scenario: Test scenario One
    Given Chrome browser is launched
    When Navigate to OrangeHRM page
    And Enter username and password
    And User clicks on Login button
    Then User navigated to OrangeHRM Home page
    
  @ScenarioTwo
  Scenario: Test scenario One
    Given Chrome browser is launched
    When Navigate to OrangeHRM page
    And Enter username and password
    
    @SearchMobile
    Scenario Outline: Search Mobile in flipkart site
    Given Chrome browser is launched
    When  Navigate to flipkart site
    And   User enter "<Item>" in search box in flipkart site
    And   User stores all the "<Item>" in a list
    
    
    Examples:
    |Item|
    |Mobile|