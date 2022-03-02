package com.api.backend.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.api.backend.model.UsuarioModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, UUID>{

   Optional<UsuarioModel> findByEmailContains(String email);

   UsuarioModel findByEmail(String email);

   
}
