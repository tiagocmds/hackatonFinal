package com.stefanini.pokemon.parsers;

import com.stefanini.pokemon.dtos.UsuarioDTO;
import com.stefanini.pokemon.entities.Usuario;

public class UsuarioParser extends AbstractParser<UsuarioDTO, Usuario> {

	@Override
	public UsuarioDTO toDTO(Usuario entity) {
		UsuarioDTO dto = new UsuarioDTO();
		dto.setEmail(entity.getEmail());
		return dto;
	}

	@Override
	public Usuario toEntity(UsuarioDTO dto) {
		Usuario user = new Usuario();
		user.setEmail(dto.getEmail());
		return user;
	}

}
