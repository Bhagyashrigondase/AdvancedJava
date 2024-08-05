package com.blogs.custom_exceptions;

public class InvalidCredentialException extends RuntimeException {
	
	public InvalidCredentialException(String msg) {
		super(msg);
	}

}
