package com.stefanini.pokemon.dtos;

import java.io.Serializable;

public class TreinadorDTO implements Serializable {

	
	private Long id;
	private String nome;
	private String senha;
	private List<PokemonDTO> pokemonsCapturados = new ArrayList<PokemonDTO>;
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setPokemonsCapturados(List lista){
		this.pokemonsCapturados = lista;
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
	public List getPokemonsCapturados(){
		return this.pokemonsCapturados;
	}
	public Pokemon getPokemonCapturado(Long id){
		for(Pokemon pokemon : pokemonsCapturados){
			if(id.equals(pokemon.getId())){
				return pokemon;
			}
		}
		return null;
	}
}

