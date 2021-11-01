package com.cepheid.cloud.skel.exception;

public class IncorrectStateException extends Exception {

	private static final long serialVersionUID = 1L;

	public IncorrectStateException(String exceptionMessage) {
		super(exceptionMessage);
	}
}