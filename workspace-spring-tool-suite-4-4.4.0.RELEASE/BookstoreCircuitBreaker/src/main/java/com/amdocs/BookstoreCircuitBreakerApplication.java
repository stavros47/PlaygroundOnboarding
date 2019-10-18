package com.amdocs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@EnableCircuitBreaker
@SpringBootApplication
public class BookstoreCircuitBreakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreCircuitBreakerApplication.class, args);
	}

}