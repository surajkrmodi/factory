package com.asde.exception;

import java.io.IOException;

public class QuestionNotFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public QuestionNotFoundException(String string, IOException e) {
		super(string);
	}


}
