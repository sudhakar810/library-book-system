package com.assessment.spring.app.exception;

public class LibraryNotFoundException extends RuntimeException {

	public LibraryNotFoundException(String exception) {
		super(exception);
	}

}
