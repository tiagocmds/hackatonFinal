package com.stefanini.pokemon.service;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;

import com.stefanini.pokemon.dtos.PokemonDTO;
import com.stefanini.pokemon.entities.Pokemon;
import com.stefanini.pokemon.entities.TipoPokemon;
import com.stefanini.pokemon.entities.Usuario;
import com.stefanini.pokemon.enums.EnumTipoPokemon;

@Singleton
public class BaseDados {
	Set<Usuario> usuarios = new HashSet<>();
	Set<Pokemon> pokemons = new HashSet<>();
	
	@PostConstruct
	public void init() {
		TipoPokemon tipoPokemonRaio = EnumTipoPokemon.RAIO.getTipo();
		TipoPokemon tipoPokemonAgua = EnumTipoPokemon.AGUA.getTipo();
		pokemons.add(new Pokemon(1l, "Pikachu", tipoPokemonRaio));
		pokemons.add(new Pokemon(2l, "Squirtle", tipoPokemonAgua));
	}
	
	
	public Pokemon salvar(Pokemon pokemon) {
		pokemon.setId((long)pokemons.size()+1);
		pokemons.add(pokemon);
		return pokemon;
	}
	
	public void salvar(Usuario user) {
		user.setId((long)usuarios.size()+1);		
		usuarios.add(user);
	}
	
	public Usuario obter(Long id) {
		for (Usuario usuario : usuarios) {
			if (id.equals(usuario.getId())) {
				return usuario;
			}
		}
		
		return null;
	}

	public void excluir(Long id) {
		usuarios.remove(obter(id));
	}
	
	public void alterar(Usuario user) {
		Usuario usuario = obter(user.getId());
		usuario.setEmail(user.getEmail());
		usuario.setSenha(user.getSenha());
	}

	public Set<Usuario> listar() {
		return usuarios;
	}
	
	public Set<Pokemon> listarPokemons() {
		return pokemons;
	}


	public void excluirPokemon(Long id) {
		pokemons.remove(obterPokemon(id));
		
	}


	public Pokemon obterPokemon(Long id) {
		for (Pokemon pokemon : pokemons) {
			if (id.equals(pokemon.getId())) {
				return pokemon;
			}
		}
		
		return null;
	}


	public Pokemon alterar(PokemonDTO dto) {
		Pokemon pokemon = obterPokemon(dto.getId());
		pokemon.setNome(dto.getNome());
		pokemon.setTipo(new TipoPokemon(dto.getTipo()));
		return pokemon;
	}
	
}
