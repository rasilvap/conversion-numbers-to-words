package com.numbers.conversion.exception;

/**
 *The class NumbersToWordsException is a custom exception that indicates conditions that a reasonable
 * application might want to catch with parametrizable error messages.
 *  *
 */
public class NumbersToWordsException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * NumbersToWordsException constructor class.
	 * @param msg input message to show errors.
	 */
	public NumbersToWordsException(String msg) {
		super(msg);
	}
}
