package br.etec.sebrae.academico.dto;

import java.io.Serializable;

public class Login implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String login;
	private String password;
	private String tipo;
	private String nome;
	
	public Login() {		
	}

	public Login(String login, String password, String tipo, String nome) {
		super();
		this.login = login;
		this.password = password;
		this.tipo = tipo;
		this.nome = nome;
	}
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}	

}
