package com.tourism.canada.exception;

import java.io.IOException;

public class FileStorageException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param arg0
	 * @param ex 
	 */
	public FileStorageException(String message) {
		super(message);
		
		// TODO Auto-generated constructor stub
	}

	public FileStorageException(String string, Exception ex) {
		// TODO Auto-generated constructor stub
		super(string, ex);
	}


	
}
