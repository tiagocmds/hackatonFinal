package com.stefanini.pokemon.parsers;

import com.stefanini.pokemon.dtos.PokemonDTO;
import com.stefanini.pokemon.dtos.TipoPokemonDTO;
import com.stefanini.pokemon.entities.Pokemon;
import com.stefanini.pokemon.entities.TipoPokemon;

public class PokemonParser extends AbstractParser<PokemonDTO, Pokemon>{

	@Override
	public PokemonDTO toDTO(Pokemon entity) {
		PokemonDTO dto = new PokemonDTO();
		dto.setId(entity.getId());
		dto.setNome(entity.getNome());
		dto.setTipo(new TipoPokemonDTO());
		dto.getTipo().setCodigo(entity.getTipo().getCodigo());
		dto.getTipo().setDescricao(entity.getTipo().getDescricao());
		return dto;
	}

	@Override
	public Pokemon toEntity(PokemonDTO dto) {
		Pokemon pokemon = new Pokemon();
		pokemon.setId(dto.getId());
		pokemon.setNome(dto.getNome());
		pokemon.setTipo(new TipoPokemon());
		pokemon.getTipo().setCodigo(dto.getTipo().getCodigo());
		pokemon.getTipo().setDescricao(dto.getTipo().getDescricao());
		return pokemon;
	}

}
