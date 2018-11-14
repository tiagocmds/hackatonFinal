package com.stefanini.pokemon.enums;

import com.stefanini.pokemon.entities.TipoPokemon;

public enum EnumTipoPokemon {
	RAIO(1, "Raio") {
		@Override
		public TipoPokemon getTipo() {
			return new TipoPokemon(this.getCodigo(), 
					this.getDescricao());
		}
	},
	FOGO(2, "Fogo") {
		@Override
		public TipoPokemon getTipo() {
			return new TipoPokemon(this.getCodigo(), 
					this.getDescricao());
		}
	},
	AGUA(3, "Água") {
		@Override
		public TipoPokemon getTipo() {
			return new TipoPokemon(this.getCodigo(), 
					this.getDescricao());
		}
	};
	
	private Integer codigo;
	private String descricao;
	
	private EnumTipoPokemon(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public TipoPokemon getTipo() {
		return null;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
