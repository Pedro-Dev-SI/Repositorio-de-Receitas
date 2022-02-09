package com.api.backend.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.backend.model.IngredientesModel;

@Repository
public interface IngredientesRepository extends JpaRepository<IngredientesModel, UUID>{

}
