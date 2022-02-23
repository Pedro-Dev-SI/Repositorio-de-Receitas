package com.api.backend.services;

import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.backend.exceptions.RecipeNotFoundException;
import com.api.backend.model.ReceitaModel;
import com.api.backend.repository.ReceitaRepository;

@Service
public class ReceitaService {
	
	//Ponto de injeção via construtor entre o repository e o service
	final ReceitaRepository receitaRepository;
	
	public ReceitaService(ReceitaRepository receitaRepository) {
		this.receitaRepository = receitaRepository;
	}
	
	//MÉTODO PARA SALVAR UMA RECEITA NO BANCO DE DADOS
	@Transactional
	public ResponseEntity<Object> save(ReceitaModel receitaModel) {

		return ResponseEntity.status(HttpStatus.CREATED).body(receitaRepository.save(receitaModel));
	}
	
	//MÉTODO QUE RETORNA TODAS AS RECEITAS CADASTRADAS
	public ResponseEntity<Page<ReceitaModel>> findAll(Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(receitaRepository.findAll(pageable));
	}
	
	//MÉTODO QUE RETORNA APENAS UMA RECEITA POR ID
	public ResponseEntity<Object> findById(UUID id) {
		Optional<ReceitaModel> receitaModelOptional = receitaRepository.findById(id);

		try {
			if(!receitaModelOptional.isPresent()) {
				throw new RecipeNotFoundException("Receita não encontrada");
			}

			return ResponseEntity.status(HttpStatus.OK).body(receitaRepository.findById(id));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		} 
	}
	
	//MÉTODO QUE DELETA UMA RECEITA
	@Transactional
	public ResponseEntity<Object> delete(UUID id) {
		Optional<ReceitaModel> receitaModelOptional = receitaRepository.findById(id);

		try {
			if(!receitaModelOptional.isPresent()) {
				throw new RecipeNotFoundException("Receita não encontrada");
			}

			receitaRepository.delete(receitaModelOptional.get());

			return ResponseEntity.status(HttpStatus.OK).body("Receita removida com sucesso");

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		} 
	}

	//MÉTODO QUE ATUALIZA UMA RECEITA
	public ResponseEntity<Object> update(UUID id, ReceitaModel receitaModel){

		Optional<ReceitaModel> receitaModelOptional = receitaRepository.findById(id);

		try {
			if(!receitaModelOptional.isPresent()) {
				throw new RecipeNotFoundException("Receita não encontrada");
			}

			receitaModel.setId(receitaModelOptional.get().getId());
			return ResponseEntity.status(HttpStatus.OK).body(receitaRepository.save(receitaModel));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		} 
	}
}
