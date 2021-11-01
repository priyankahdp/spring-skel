package com.cepheid.cloud.skel.exception;

public class NotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public NotFoundException(String exceptionMessage) {
		super(exceptionMessage);
	}
}