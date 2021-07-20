package com.asde.exception;

import java.io.IOException;

public class PropertyFileNotFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PropertyFileNotFoundException(String string, IOException e) {
		super(string);
	}

}
