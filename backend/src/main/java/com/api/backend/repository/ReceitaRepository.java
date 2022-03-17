package com.api.backend.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.backend.model.ReceitaModel;

@Repository
@Transactional
public interface ReceitaRepository extends JpaRepository<ReceitaModel, Long> {

   List<ReceitaModel> findBynomeReceitaContains(String nomeReceita);
	
}
