package com.example.frameworkMvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class resourceNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public resourceNotFoundException(String message) {
		super(message);
	}

}
