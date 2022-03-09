package com.api.backend.repository;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.backend.model.ReceitaModel;

@Repository
@Transactional
public interface ReceitaRepository extends JpaRepository<ReceitaModel, UUID> {

   List<ReceitaModel> findBynomeReceitaContains(String nomeReceita);
	
}
