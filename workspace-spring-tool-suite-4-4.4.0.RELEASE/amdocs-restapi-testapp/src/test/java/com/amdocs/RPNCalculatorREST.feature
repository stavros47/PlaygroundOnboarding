Feature: Develop a RPNCalculator REST API

This RPN Calculator REST API will accept a math expression in
post-fix a.k.a Reverse Polish Notation and it will calculate the result.

	Scenario: Simple Addition
		
		Given The Rest API is up and live
		And the rest end-point is "http://localhost:8080/rpnCalculator/10 15 +"
		When I invoke the rest end-point URL
		Then I expect the result as "25.0"
