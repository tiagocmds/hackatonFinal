package com.stefanini.pokemon.entities;

import com.stefanini.pokemon.dtos.TipoPokemonDTO;

public class TipoPokemon extends EntityBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer codigo;
	private String descricao;
	
	public TipoPokemon() {
		
	}
	
	public TipoPokemon(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public TipoPokemon(TipoPokemonDTO tipo) {
		this.codigo = tipo.getCodigo();
		this.descricao = tipo.getDescricao();
	}

	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
