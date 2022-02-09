package com.api.backend.services;

import org.springframework.stereotype.Service;

import com.api.backend.repository.ModoPreparoRepository;

@Service
public class ModoPreparoService {
	
	final ModoPreparoRepository modoPreparoRepository;
	
	public ModoPreparoService(ModoPreparoRepository modoPreparoRepository) {
		this.modoPreparoRepository = modoPreparoRepository;
	}
}
