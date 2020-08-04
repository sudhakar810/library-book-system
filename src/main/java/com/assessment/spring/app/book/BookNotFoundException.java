package com.assessment.spring.app.book;

public class BookNotFoundException extends RuntimeException {

	public BookNotFoundException(String exception) {
		super(exception);
	}

}
