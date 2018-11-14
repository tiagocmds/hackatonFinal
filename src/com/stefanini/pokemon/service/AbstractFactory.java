package com.stefanini.pokemon.service;

import java.util.List;

public abstract class AbstractFactory<Entity> {

	abstract List<Entity> gerar();
	abstract List<Entity> gerar(List l);
	
}
