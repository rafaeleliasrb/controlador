package com.estudos.exceptions;

public class UsuarioNaoEncontradoException extends Exception {

	private static final long serialVersionUID = 1L;

	public UsuarioNaoEncontradoException(String errorMessage) {
		super(errorMessage);
	}
}
