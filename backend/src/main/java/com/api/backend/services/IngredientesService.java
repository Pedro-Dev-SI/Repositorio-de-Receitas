package com.api.backend.services;

import org.springframework.stereotype.Service;

import com.api.backend.repository.IngredientesRepository;

@Service
public class IngredientesService {
	
	final IngredientesRepository ingredientesRepository;
	
	public IngredientesService(IngredientesRepository ingredientesRepository) {
		
		this.ingredientesRepository = ingredientesRepository;
	}
}
