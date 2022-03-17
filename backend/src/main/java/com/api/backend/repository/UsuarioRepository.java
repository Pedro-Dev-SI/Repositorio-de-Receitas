package com.api.backend.repository;

import java.util.Optional;

import com.api.backend.model.UsuarioModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long>{

   public Optional<UsuarioModel> findByEmailContains(String email);

   public Optional<UsuarioModel> findByEmail(String email);


   
}
