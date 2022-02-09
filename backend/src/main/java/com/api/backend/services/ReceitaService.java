package com.api.backend.services;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
	public ReceitaModel save(ReceitaModel receitaModel) {
		return receitaRepository.save(receitaModel);
	}
	
	//MÉTODO QUE RETORNA TODAS AS RECEITAS CADASTRADAS
	public Page<ReceitaModel> findAll(Pageable pageable) {
		return receitaRepository.findAll(pageable);
	}
}
