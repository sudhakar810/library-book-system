package com.assessment.spring.app.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.assessment.spring.app.exception.LibraryNotFoundException;
import com.assessment.spring.app.model.Library;
import com.assessment.spring.app.repository.LibraryRepository;

@RestController
@CrossOrigin(origins = "*")
public class LibraryController {

	@Autowired
	private LibraryRepository libraryRepository;

	@GetMapping("/libraries")
	public List<Library> retrieveAllStudents() {
		return libraryRepository.findAll();
	}

	@GetMapping("/libraries/{id}")
	public Library retrieveStudent(@PathVariable long id) {
		Optional<Library> libraries = libraryRepository.findById(id);

		if (!libraries.isPresent())
			throw new LibraryNotFoundException("id-" + id);

		return libraries.get();
	}

	@DeleteMapping("/libraries/{id}")
	public void deleteStudent(@PathVariable long id) {
		libraryRepository.deleteById(id);
	}

	@PostMapping("/libraries")
	public ResponseEntity<Object> createStudent(@RequestBody Library library) {
		Library saveLibraries = libraryRepository.save(library);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(saveLibraries.getLid()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/libraries/{id}")
	public ResponseEntity<Object> updateStudent(@RequestBody Library book, @PathVariable long id) {

		Optional<Library> studentOptional = libraryRepository.findById(id);

		if (!studentOptional.isPresent())
			return ResponseEntity.notFound().build();

		book.setLid(id);
		libraryRepository.save(book);
		return ResponseEntity.noContent().build();
	}
}
