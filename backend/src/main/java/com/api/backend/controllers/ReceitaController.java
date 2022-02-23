package com.api.backend.controllers;

import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
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
@RequestMapping("/receitas")// http://localhost:8080/receitas
public class ReceitaController {
	
	//Ponto de injeção entre o o controller e service
	final ReceitaService receitaService;
	
	public ReceitaController(ReceitaService receitaService) {
		this.receitaService = receitaService;
	}
	
	//MÉTODO POST
	@PostMapping
	public ResponseEntity<Object> saveReceita(@RequestBody @Valid ReceitaModel receitaModel){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(receitaService.save(receitaModel));
		
	}
	
	// MÉTODO GET
	@GetMapping
	public ResponseEntity<Page<ReceitaModel>> getAllReceitas(@PageableDefault(page=0, size=10, sort="id", direction=Sort.Direction.ASC)Pageable pageable){
		return ResponseEntity.status(HttpStatus.OK).body(receitaService.findAll(pageable));
	}
	
	//MÉTODO GET ONE
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneReceita(@PathVariable(value="id") UUID id){
		
		Optional<ReceitaModel> receitaModelOptional = receitaService.findById(id);
		
		if(!receitaModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Receita não encontrada");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(receitaModelOptional.get());
	}
	
	//MÉTODO DELETE
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteReceita(@PathVariable(value="id") UUID id){
		Optional<ReceitaModel> receitaModelOptional = receitaService.findById(id);
		
		if(!receitaModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Receita não encontrada");
		}
		
		receitaService.delete(receitaModelOptional.get());
		
		return ResponseEntity.status(HttpStatus.OK).body("Receita deletada com sucesso!!");
	}
	
	//MÉTODO UPDATE
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateReceita(@PathVariable(value="id") UUID id, 
			@RequestBody @Valid ReceitaModel receitaModel){
		
		Optional<ReceitaModel> receitaModelOptional = receitaService.findById(id);
		
		if(!receitaModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Receita não encontrada");
		}
		
		receitaModel.setId(receitaModelOptional.get().getId());
		return ResponseEntity.status(HttpStatus.OK).body(receitaService.save(receitaModel));
	}

}
