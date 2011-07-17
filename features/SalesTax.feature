Feature: Calculation of sales tax

Scenario: Input1
    Given the price of 1 book is 12.49
    And the price of 1 music CD is 14.99
    And the price of 1 chocolate bar is 0.85
    Then the cost of book becomes 12.49
    And the cost of music CD becomes 16.49
    And the cost of chocolate bar becomes 0.85
    And the Sales Tax becomes 1.5
    And the Total Amount becomes 29.83

Scenario: Input2
    Given the price of 1 imported box of chocolates is 10.00
    And the price of 1 imported bottle of perfume is 47.50
    Then the cost of box of chocolates becomes 10.50
    And the cost of bottle of perfume becomes 54.65
    And the Sales Tax becomes 7.65
    And the Total Amount becomes 65.15

Scenario: Input3
   Given the price of 1 imported bottle of perfume is 27.99
   And the price of 1 bottle of perfume is 18.99
   And the price of 1 packet of headache pills is 9.75
   And the price of 1 box of imported chocolates is 11.25
   Then the cost of imported bottle of perfumes becomes 32.19
   And the cost of bottle of perfume becomes 20.89
   And the cost of packet of headache pills becomes 9.75
   And the cost of box of chocolates becomes 11.85 
   And the Sales Tax becomes 6.70
   And the Total Amount becomes 74.68


