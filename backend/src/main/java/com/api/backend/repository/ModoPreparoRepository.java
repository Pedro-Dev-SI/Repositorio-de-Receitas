package com.api.backend.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.backend.model.ModoPreparoModel;

@Repository
public interface ModoPreparoRepository extends JpaRepository<ModoPreparoModel, UUID> {

}
