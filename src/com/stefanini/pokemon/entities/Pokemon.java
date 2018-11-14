package com.stefanini.pokemon.entities;

public class Pokemon extends EntityBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private TipoPokemon tipo;
	
	
	public Pokemon() {
		
	}
	
	public Pokemon(Long id, String nome, TipoPokemon tipo) {
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public TipoPokemon getTipo() {
		return tipo;
	}
	public void setTipo(TipoPokemon tipo) {
		this.tipo = tipo;
	}	
	
}
