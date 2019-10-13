package com.estudos.autenticate;

import java.util.Optional;

import com.estudos.exceptions.SenhaErradaException;
import com.estudos.exceptions.UsuarioNaoEncontradoException;
import com.estudos.models.Usuario;
import com.estudos.repositories.UsuarioRepository;

public class Autenticador {

	private static UsuarioRepository usuarioRepository = new UsuarioRepository();
	
	private Autenticador() {
		throw new IllegalStateException("Utility class");
	}
	
	public static Optional<Usuario> autenticarUsuario(String login, String senha) throws UsuarioNaoEncontradoException, SenhaErradaException {
		Optional<Usuario> usuario = usuarioRepository.findUsuarioByLogin(login);
		if(usuario.isPresent()) {
			verificarSenhaDo(usuario.get(), senha);
		} else {
			throw new UsuarioNaoEncontradoException("Usuário não encontrado.");
		}
		return usuario;
	}
	
	private static void verificarSenhaDo(Usuario usuario, String senha) throws SenhaErradaException {
		if(!usuario.getSenha().equals(senha))
			throw new SenhaErradaException("Senha inválida");
	}
}
