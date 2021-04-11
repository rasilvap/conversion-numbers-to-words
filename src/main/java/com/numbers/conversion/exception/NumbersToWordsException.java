package com.numbers.conversion.exception;

public class NumbersToWordsException extends Exception {

	private static final long serialVersionUID = 1L;

	public NumbersToWordsException(String msg) {
		super(msg);
	}

	public NumbersToWordsException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
