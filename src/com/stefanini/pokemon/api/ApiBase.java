package com.stefanini.pokemon.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Context;


public class ApiBase {

	@Context
	private HttpServletRequest request;
	
	@Context
	private HttpServletResponse response;
	
	
	protected HttpSession getSession() {
		return request.getSession();
	}
	
}
