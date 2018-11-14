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

import com.stefanini.pokemon.dtos.TreinadorDTO;
import com.stefanini.pokemon.service.TreinadorService;

@Path("/treinador")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TreinadorApi extends ApiBase {

	@Inject
	private TreinadorService treinadorService;
	
	@GET
	public Response listar() {
		return Response.ok(treinadorService.listar()).build();
	}
	
	@GET
	@Path("/obter/{id}")
	public Response obter(@PathParam("id") Long id) {
		return Response.ok(treinadorService.obter(id)).build();
	}
	
	@POST
	public Response cadastrar(TreinadorDTO dto) {
		return Response.ok(treinadorService.salvar(dto)).build();
	}
	
	@PUT
	public Response alterar(TreinadorDTO dto) {
		return Response.ok(treinadorService.alterar(dto)).build();
	}
	
	@DELETE
	public Response excluir(@QueryParam("id") Long id) {
		treinadorService.excluir(id);
		return Response.ok().build();
	}
	
}
