package com.hrvojematic.chess.notationparser;

/**
 * Models all exceptions thrown by NotationParser 
 * for easier parser exception handling.
 * @author Hrvoje Matić
 * @version 1.0
 */
public class NotationParserException extends RuntimeException {
	/** Serialization ID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Default constructor for NotationParserException.
	 */
	public NotationParserException() {
		super();
	}
	
	/**
	 * Constructor with exception message.
	 * @param message exception message
	 */
	public NotationParserException(String message) {
		super(message);
	}
}
