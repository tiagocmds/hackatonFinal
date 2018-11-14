package com.stefanini.pokemon.service;

import java.util.Set;

import javax.inject.Inject;

import com.stefanini.pokemon.entities.Usuario;


public class UsuarioService extends ServiceBase {

	@Inject
	private BaseDados baseDados;
	
	
	public void salvar(Usuario user) {
		baseDados.salvar(user);
	}
	
	public Usuario obter(Long id) {
		return baseDados.obter(id);
	}

	public void alterar(Usuario user) {
		baseDados.alterar(user);
	}
	
	public void excluir(Long id) {
		baseDados.excluir(id);
	}

	public Set<Usuario> listar() {
		return baseDados.listar();
	}
	
}






















