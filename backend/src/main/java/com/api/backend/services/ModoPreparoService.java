package com.api.backend.services;

import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

import com.api.backend.model.ModoPreparoModel;
import com.api.backend.repository.ModoPreparoRepository;

@Service
public class ModoPreparoService {
	
	final ModoPreparoRepository modoPreparoRepository;
	
	public ModoPreparoService(ModoPreparoRepository modoPreparoRepository) {
		this.modoPreparoRepository = modoPreparoRepository;
	}


	//MÉTODO QUE SALVA UM MODO DE PREPARO NA BASE DE DADOS
	public ModoPreparoModel save(ModoPreparoModel modoPreparoModel) {
		return modoPreparoRepository.save(modoPreparoModel);
	}

	//MÉTODO QUE RETORNA APENAS UM MODO DE PREPARO
	public Optional<ModoPreparoModel> findById(UUID mpid){
		return modoPreparoRepository.findById(mpid);
	}

	//MÉTODO PARA DELETAR UM MODO DE PREPARO DA BASE DE DADOS
	public void delete(ModoPreparoModel modoPreparoModel) {
		modoPreparoRepository.delete(modoPreparoModel);
	}
}
