package com.amdocs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RPNCalculatorRestController {
	
	@Autowired
	private RPNCalculator rpnCalculator;
	
	@GetMapping(path="/rpnCalculator/{rpnExpression}", produces= MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public double evaluate (@PathVariable("rpnExpression") String rpnMathExpression) {
		return rpnCalculator.evaluate(rpnMathExpression);
	}
}
