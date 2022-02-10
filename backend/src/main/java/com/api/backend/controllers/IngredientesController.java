package com.api.backend.controllers;

import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.backend.dto.IngredientesDto;
import com.api.backend.model.IngredientesModel;
import com.api.backend.services.IngredientesService;

@RestController
@CrossOrigin(origins="*",  maxAge=3600)
@RequestMapping("/receitas/ingredientes")
public class IngredientesController {
		
		final IngredientesService ingredientesService;
		
		public IngredientesController(IngredientesService ingredientesService) {
			this.ingredientesService = ingredientesService;
		}
		
		//MÉTODO POST
		@PostMapping
		public ResponseEntity<Object> saveIngredientes(@RequestBody @Valid IngredientesDto ingredientesDto){
				
				var ingredientesModel = new IngredientesModel();
				BeanUtils.copyProperties(ingredientesDto, ingredientesModel);
				return ResponseEntity.status(HttpStatus.CREATED).body(ingredientesService.save(ingredientesModel));
		}
		
		//MÉTODO DELETE
		@DeleteMapping("/{id}")
		public ResponseEntity<Object> deleteIngredientes(@PathVariable(value = "iid") UUID iid){
				Optional<IngredientesModel> ingredientesModelOptional = ingredientesService.findById(iid);
				
				if(!ingredientesModelOptional.isPresent()) {
						return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ingrediente não encontrado");
				}
				
				ingredientesService.delete(ingredientesModelOptional.get());
				return ResponseEntity.status(HttpStatus.OK).body("Ingrediente deletado com sucesso");
		}
}
