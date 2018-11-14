package com.stefanini.pokemon.service;

import java.util.List;

import javax.inject.Inject;

import com.stefanini.pokemon.dtos.PokemonDTO;
import com.stefanini.pokemon.entities.Pokemon;
import com.stefanini.pokemon.parsers.PokemonParser;


public class PokemonService extends ServiceBase {

	@Inject
	private BaseDados baseDados;
	
	private PokemonParser pokemonParser = new PokemonParser();
	
	public PokemonDTO salvar(PokemonDTO dto) {
		Pokemon pokemon = baseDados.salvar(pokemonParser.toEntity(dto));
		dto.setId(pokemon.getId());
		return dto;
	}
	

	public List<PokemonDTO> listar() {
		return pokemonParser.toDTO(baseDados.listarPokemons());
	}


	public void excluir(Long id) {
		baseDados.excluirPokemon(id);
	}
	
	public PokemonDTO obter(Long id) {
		return pokemonParser.toDTO(baseDados.obterPokemon(id));
	}


	public PokemonDTO alterar(PokemonDTO dto) {
		return pokemonParser.toDTO(baseDados.alterar(dto));
	}
	
}






















