package com.estudos.exceptions;

public class SenhaErradaException extends Exception {

	private static final long serialVersionUID = 1L;

	public SenhaErradaException(String errorMessage) {
		super(errorMessage);
	}
}
