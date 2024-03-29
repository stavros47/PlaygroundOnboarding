package com.amdocs;

import java.net.URI;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class BookstoreRestController {
	
	private ArrayList<Book> bookCatalogue;
	
	public BookstoreRestController() {
		bookCatalogue = new ArrayList<Book>();
	}
	
	@GetMapping("/bookstore")
	public ArrayList<Book> getBookCatalog(){
		RestTemplate restTemplate = new RestTemplate();
		
		URI url = URI.create("http://localhost:8081/books");
		ParameterizedTypeReference<ArrayList<Book>> latestBookCatalog = new ParameterizedTypeReference<ArrayList<Book>>() {};
		
		ResponseEntity<ArrayList<Book>> response = restTemplate.exchange(url,HttpMethod.GET, null, latestBookCatalog);
		
		return response.getBody();
	}
}
