package com.stefanini.pokemon.api.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.stefanini.pokemon.api.LoginApi;
import com.stefanini.pokemon.api.PokemonApi;
import com.stefanini.pokemon.api.UsuarioApi;

@ApplicationPath("/rest")
public class JaxrsActivator extends Application {

	Set<Class<?>> classes = new HashSet<>();

	public JaxrsActivator() {
		classes.add(LoginApi.class);
		classes.add(UsuarioApi.class);
		classes.add(PokemonApi.class);
		
	}
	
	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}
	
}
