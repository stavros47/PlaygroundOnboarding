package com.amdocs;

import java.net.URI;
import java.util.ArrayList;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class BookstoreRestController {
	
	private ArrayList<Book> listOfBooks;
	
	public BookstoreRestController() {
		listOfBooks = new ArrayList<Book>();
		listOfBooks.add(new Book("Clean Code", "Robert Martin", 43.00));
		listOfBooks.add(new Book("Automating the Boring Stuff with Python", "Robert Martin", 20.00));

	}
	
	@HystrixCommand(fallbackMethod="getLocalCatalogue")
	@GetMapping("/bookstore")
	public ArrayList<Book> getBookCatalogue(){
		RestTemplate restTemplate = new RestTemplate();
		
		URI url = URI.create("http://localhost:8081/books");
		ParameterizedTypeReference<ArrayList<Book>> latestBookCatalog = new ParameterizedTypeReference<ArrayList<Book>>() {};
		
		ResponseEntity<ArrayList<Book>> response = restTemplate.exchange(url,HttpMethod.GET, null, latestBookCatalog);
		
		listOfBooks = response.getBody();
		return listOfBooks;
	}
	
	public ArrayList<Book> getLocalCatalogue(){
		return listOfBooks;
	}
}
