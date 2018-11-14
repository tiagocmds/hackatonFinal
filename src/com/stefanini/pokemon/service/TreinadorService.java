package com.stefanini.pokemon.service;

import java.util.List;

import javax.inject.Inject;

import com.stefanini.pokemon.dtos.TreinadorDTO;
import com.stefanini.pokemon.entities.Treinador;
import com.stefanini.pokemon.parsers.TreinadorParser;


public class TreinadorService extends ServiceBase {

	@Inject
	private BaseDados baseDados;
	
	private TreinadorParser treinadorParser = new TreinadorParser();
	
	public TreinadorDTO salvar(TreinadorDTO dto) {
		Treinador treinador = baseDados.salvar(treinadorParser.toEntity(dto));
		dto.setId(treinador.getId());
		return dto;
	}
	

	public List<TreinadorDTO> listar() {
		return treinadorParser.toDTO(baseDados.listarTreinadores());
	}


	public void excluir(Long id) {
		baseDados.excluirTreinador(id);
	}
	
	public TreinadorDTO obter(Long id) {
		return treinadorParser.toDTO(baseDados.obterTreinador(id));
	}


	public TreinadorDTO alterar(TreinadorDTO dto) {
		return treinadorParser.toDTO(baseDados.alterar(dto));
	}
	
}