package com.amdocs;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookCatalogueRestController {
	
	private static ArrayList<Book> listOfBooks;
	
	static {
		listOfBooks = new ArrayList<Book>();
		
		listOfBooks.add(new Book("Working effectively with legacy code","Martin fowler",49.00));
		listOfBooks.add(new Book("Master C++","Martin fowler",29.00));
		listOfBooks.add(new Book("Testing","Martin fowler",59.00));
		
	}
	
	public BookCatalogueRestController() {
		
	}
	
	@GetMapping("/books")
	public ArrayList<Book> getAllBooks(){
		return listOfBooks;
	}
}
