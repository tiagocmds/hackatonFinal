package com.stefanini.pokemon.dtos;

import java.io.Serializable;

public class PokemonDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private TipoPokemonDTO tipo;
	
	
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
	public TipoPokemonDTO getTipo() {
		return tipo;
	}
	public void setTipo(TipoPokemonDTO tipo) {
		this.tipo = tipo;
	}	
	
}
