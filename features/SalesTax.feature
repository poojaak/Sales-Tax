Feature: Calculation of sales tax

Scenario: Sales tax exemption
    Given the goods are among books, food and medical products
    Then the sales tax is exempted on each good

Scenario: Sales tax on goods that are exempted from tax but are imported goods
    Given the goods are among books, food and medical products
    And the goods are imported
    Then the sales tax is 5% on each good

Scenario: Sales tax on goods
    Given the goods are not among books, food and medical products
    Then the sales tax is 10% on each good

Scenario: Sales tax on goods that are imported and are not under exemption tax category
    Given the goods are not among books, food and medical products
    And the goods are imported
    Then the sales tax is 15% on each good