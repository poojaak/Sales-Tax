Feature: Addition
  In order to avoid silly mistakes
  As a math idiot 
  I want to be told the sum of two numbers

  Scenario: Add two numbers
    Given I visit the calculationOnItem page
    And I fill in '50' for 'first'
    And I fill in '70' for 'Second'
    When I press 'Add'
    Then I should see 'Answer: 120'
