package com.amdocs;

import static org.junit.Assert.assertEquals;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {
	
	private RestTemplate restTemplate;
	private String restEndpointURL;
	ResponseEntity<String> actualResponse;
	
	@Given("The Rest API is up and live")
	public void ensureRESTAPIIsLive() {
		restTemplate = new RestTemplate();
		System.out.println("given1");
	}
	
	@Given("the rest end-point is {string}")
	public void evaluateRestEndpoint(String strRestEndpointURL) {
		restEndpointURL = strRestEndpointURL;
	}

	@When("I invoke the rest end-point URL")
	public void invokeRestEndpointURL() {
		System.out.println("print");
		actualResponse = restTemplate.getForEntity(restEndpointURL, String.class);
		
	}

	@Then("I expect the result as {string}")
	public void evaluateExpectedResult(String expectedResponse) {
	    //assertEquals(expectedResponse, actualResponse);
		assertEquals(200, actualResponse.getStatusCodeValue());
		assertEquals(true, actualResponse.getBody().contains("25.0"));
	}
}
