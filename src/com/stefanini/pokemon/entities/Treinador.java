package com.stefanini.pokemon.entities;

public class Treinador extends EntityBase {
private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String senha;
	
	public Treinador() {
		
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return this.nome;
	}
	public String getSenha() {
		return this.senha;
	}
	public Long getId() {
		return this.id;
	}
}
