package com.amdocs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {
	
	@Autowired
	private Hello hello;

	@GetMapping("/hello")
	public String sayHello() {
		return hello.sayHello();
	}
}
