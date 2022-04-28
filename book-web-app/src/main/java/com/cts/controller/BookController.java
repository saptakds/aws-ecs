package com.cts.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cts.model.Book;

@RestController
public class BookController {

	private static Book[] books = { new Book(1, "Nemesis", "Issac Asimov"),
			new Book(2, "Great Expectations", "Charles Dickens"),
			new Book(3, "The Chronicles of Narnia", "C. S. Lewis") };

	@GetMapping("/books")
	public Book[] books() {
		return books;
	}

	@GetMapping("/books/{id}")
	public Book book(@PathVariable int id) {
		for (Book b : books) {
			if (b.getId() == id) {
				return b;
			}
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity not found");
	}
}
