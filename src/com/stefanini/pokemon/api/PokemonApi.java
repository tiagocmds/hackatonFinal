package com.stefanini.pokemon.api;

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

import com.stefanini.pokemon.dtos.PokemonDTO;
import com.stefanini.pokemon.service.PokemonService;

@Path("/pokemon")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PokemonApi extends ApiBase {

	@Inject
	private PokemonService pokemonService;
	
	@GET
	public Response listar() {
		return Response.ok(pokemonService.listar()).build();
	}
	
	@GET
	@Path("/obter/{id}")
	public Response obter(@PathParam("id") Long id) {
		return Response.ok(pokemonService.obter(id)).build();
	}
	
	@POST
	public Response cadastrar(PokemonDTO dto) {
		return Response.ok(pokemonService.salvar(dto)).build();
	}
	
	@PUT
	public Response alterar(PokemonDTO dto) {
		return Response.ok(pokemonService.alterar(dto)).build();
	}
	
	@DELETE
	public Response excluir(@QueryParam("id") Long id) {
		pokemonService.excluir(id);
		return Response.ok().build();
	}
	
}


















