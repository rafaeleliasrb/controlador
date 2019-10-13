package com.estudos.repositories;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.estudos.models.Usuario;

public class UsuarioRepository {

	//private static UsuarioRepository INSTANCE;
	
	private static final Map<String, Usuario> usuarios = new HashMap<>();
	private static Long maxId = 0l;
	
	static {
		Usuario usuario1 = new Usuario(maxId++, "usuario1", "12345");
		Usuario usuario2 = new Usuario(maxId++, "usuario2", "12345");
		Usuario usuario3 = new Usuario(maxId++, "usuario3", "12345");
		usuarios.put(usuario1.getLogin(), usuario1);
		usuarios.put(usuario2.getLogin(), usuario2);
		usuarios.put(usuario3.getLogin(), usuario3);
	}
	
	/*
	 * private UsuarioRepository() {}
	 * 
	 * public static synchronized UsuarioRepository getInstance() { if(INSTANCE ==
	 * null) { INSTANCE = new UsuarioRepository(); } return INSTANCE; }
	 */

	public Collection<Usuario> getUsuarios() {
		return Collections.unmodifiableCollection(usuarios.values());
	}
	
	public Optional<Usuario> findUsuarioByLogin(String login) {
		return Optional.of(usuarios.get(login));
	}
	
	public synchronized void insertUsuario(Usuario usuario) {
		usuario.setId(maxId++);
		new EntityValidator().validate(usuario);
		usuarios.put(usuario.getLogin(), usuario);
	}
}
