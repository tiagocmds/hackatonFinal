package com.stefanini.pokemon.api;

import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.stefanini.pokemon.dtos.UsuarioDTO;
import com.stefanini.pokemon.entities.Usuario;
import com.stefanini.pokemon.parsers.UsuarioParser;
import com.stefanini.pokemon.service.UsuarioService;

@Path("/usuario")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioApi extends ApiBase {
	
	@Inject
	private UsuarioService usuarioService;
	
	@GET
	public Response listar() {
		Set<Usuario> listaUsuario = usuarioService.listar();
		List<UsuarioDTO> listaUsuarioRetorno = null;
		UsuarioParser usuarioParser = new UsuarioParser();
		listaUsuarioRetorno = usuarioParser.toDTO(listaUsuario);
		
		return Response.ok(listaUsuarioRetorno).build();
	}
	
	@GET
	@Path("/obter/{id}")
	public Response obter(@PathParam("id") Long id) {
		UsuarioParser usuarioParser = new UsuarioParser();
		Usuario user = usuarioService.obter(id);
		UsuarioDTO userDTO = null;
		
		if (user != null) {
			userDTO = usuarioParser.toDTO(user);
		}
		
		return Response.ok(userDTO).build();
	}

	
	@POST
	public Response cadastrar(UsuarioDTO dto) {
		
		Usuario user = new Usuario();
		user.setEmail(dto.getEmail());
		user.setSenha(dto.getSenha());
		
		usuarioService.salvar(user);
		
		return Response.ok().build();
	}
	
	
	@PUT
	public Response alterar(UsuarioDTO dto) {
		
		Usuario user = new Usuario();
		user.setId(dto.getId());
		user.setEmail(dto.getEmail());
		user.setSenha(dto.getSenha());
		
		
		usuarioService.alterar(user);
		
		return Response.ok().build();
	}
	
	@DELETE
	public Response excluir(@QueryParam("id") Long id) {
		usuarioService.excluir(id);
		return Response.ok().build();
	}
	
}
