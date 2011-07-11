Feature: Adding

	Scenario: Add two numbers
		Given the following input:
			"""
			hello
			"""
		When the calculationOnItem is run
		Then the output should be 4
