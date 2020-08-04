package com.assessment.spring.app.exception;

public class BookNotFoundException extends RuntimeException {

	public BookNotFoundException(String exception) {
		super(exception);
	}

}
