package com.api.backend.controllers;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.api.backend.model.ReceitaModel;
import com.api.backend.services.ReceitaService;

@RestController
@CrossOrigin(origins="*", maxAge = 3600)
@RequestMapping("/api/v1/dashboard")// http://localhost:8080/api/v1/dashboard
public class ReceitaController {
	
	//Ponto de injeção entre o o controller e service
	final ReceitaService receitaService;
	
	public ReceitaController(ReceitaService receitaService) {
		this.receitaService = receitaService;
	}
	
	//MÉTODO POST
	@PostMapping("/new-recipe")
	public ResponseEntity<Object> saveReceita(@RequestBody ReceitaModel receitaModel){
		
		return receitaService.save(receitaModel);
	}
	
	// MÉTODO GET
	@GetMapping
	public ResponseEntity<Page<ReceitaModel>> getAllReceitas(@PageableDefault(page=0, size=10, sort="id", direction=Sort.Direction.ASC)Pageable pageable){

		return receitaService.findAll(pageable);
	}
	
	//MÉTODO GET ONE
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneReceita(@PathVariable(value="id") UUID id){
		
		return receitaService.findById(id);
	}
	
	//MÉTODO DELETE
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deletarReceita(@PathVariable(value="id") UUID id){
		
		return receitaService.delete(id);
		
	}
	
	//MÉTODO UPDATE
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateReceita(@PathVariable(value="id") UUID id, 
			@RequestBody ReceitaModel receitaModel){
		
		return receitaService.update(id, receitaModel);
	}

}
