package com.asde.exception;

import java.io.IOException;

public class QuestionSQLException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public QuestionSQLException(String string, IOException e) {
		super(string);
	}

}
