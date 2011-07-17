Scenario: See all vendors
    Given I am logged in as a user in the administrator role
    And There are 3 vendors
    When I go to the manage vendors page
    Then I should see the first 3 vendor names
