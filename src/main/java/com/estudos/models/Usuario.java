package com.estudos.models;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Usuario implements Serializable{

	private static final long serialVersionUID = -5103193082697517355L;

	@NotNull(message = "Id não pode ser vazio")
	@Min(value = 1, message = "O id não pode ser menor que 1")
	private Long id;
	
	@NotEmpty(message = "Login não pode ser vazio")
	private String login;
	
	@NotEmpty(message = "Senha não pode ser vazia")
	private String senha;
	
	public Usuario(Long id, String login, String senha) {
		this.id = id;
		this.login = login;
		this.senha = senha;
	}
	
	public Usuario(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getLogin() {
		return login;
	}
	
	public String getSenha() {
		return senha;
	}
}
