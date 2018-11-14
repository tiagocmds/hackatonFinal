package com.stefanini.pokemon.parsers;

import com.stefanini.pokemon.dtos.TreinadorDTO;
import com.stefanini.pokemon.entities.Treinador;


public class TreinadorParser extends AbstractParser<TreinadorDTO, Treinador> {
	
	@Override
	public TreinadorDTO toDTO(Treinador entity) {
		TreinadorDTO dto = new TreinadorDTO();
		dto.setId(entity.getId());
		dto.setNome(entity.getNome());
		dto.setSenha(entity.getSenha());
		return dto;
	}

	@Override
	public Treinador toEntity(TreinadorDTO dto) {
		Treinador user = new Treinador();
		user.setId(dto.getId());
		user.setNome(dto.getNome());
		user.setSenha(dto.getSenha() );
		return user;
	}

}
