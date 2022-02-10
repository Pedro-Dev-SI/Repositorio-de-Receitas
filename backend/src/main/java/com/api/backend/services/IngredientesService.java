package com.api.backend.services;

import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.api.backend.model.IngredientesModel;
import com.api.backend.repository.IngredientesRepository;

@Service
public class IngredientesService {
	
		final IngredientesRepository ingredientesRepository;
	
		public IngredientesService(IngredientesRepository ingredientesRepository) {
		
				this.ingredientesRepository = ingredientesRepository;
		}
	
		//MÉTODO PARA ADICIONAR UM INGREDIENTE
		@Transactional
		public IngredientesModel save(IngredientesModel ingredientesModel) {
			
				return ingredientesRepository.save(ingredientesModel);
		}
		
		//MÉTODO PARA ACHAR APENA UM INGREDIENTE PELO ID
		public Optional<IngredientesModel> findById(UUID iid){
				return ingredientesRepository.findById(iid);
		}
		
		// MÉTODO PARA DELETAR UM INGREDIENTE
		@Transactional
		public void delete(IngredientesModel ingredientesModel) {
			ingredientesRepository.delete(ingredientesModel);
		}
}
