package com.stefanini.pokemon.entities;
import java.util.List;
import java.util.ArrayList;

public class Treinador extends EntityBase {
private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String senha;
	private List<Pokemon> pokemonsCapturados = new ArrayList<Pokemon>;
	
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
