package com.assessment.spring.app.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.assessment.spring.app.exception.BookNotFoundException;
import com.assessment.spring.app.model.Book;
import com.assessment.spring.app.repository.BookRepository;

@RestController
@CrossOrigin(origins = "*")
public class BookController {

	@Autowired
	private BookRepository bookRepository;

	@GetMapping("/books")
	public Iterable<Book> retrieveAllStudents() {
		return bookRepository.findAll();
	}

	@GetMapping("/books/{id}")
	public Book retrieveBook(@PathVariable long id) {
		Optional<Book> book = bookRepository.findById(id);

		if (!book.isPresent())
			throw new BookNotFoundException("id-" + id);

		return book.get();
	}

	@DeleteMapping("/books/{id}")
	public void deleteBook(@PathVariable long id) {
		bookRepository.deleteById(id);
	}

	@PostMapping("/books")
	public ResponseEntity<Boolean> createBook(@RequestBody Book book) {
		Book savedBook = bookRepository.save(book);
        Boolean result = false;
		if(!ObjectUtils.isEmpty(savedBook)) {
			result = true;
		}

		return ResponseEntity.ok(result);

	}
	
	@PutMapping("/books/{id}")
	public ResponseEntity<Boolean> updateBook(@RequestBody Book book, @PathVariable long id) {

		Optional<Book> bookOptional = bookRepository.findById(id);

		if (!bookOptional.isPresent())
			return ResponseEntity.notFound().build();

		book.setBid(id);
		bookRepository.save(book);
		return ResponseEntity.ok(true);
	}
}
