package com.api.backend.services;

import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import com.api.backend.model.UsuarioModel;
import com.api.backend.repository.UsuarioRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class UsuarioService {
   
   final UsuarioRepository usuarioRepository;

   public UsuarioService(UsuarioRepository usuarioRepository) {
      this.usuarioRepository = usuarioRepository;
   }

   //MÉTODO PARA SALVAR UM USUÁRIO NO BANCO DE DADOS
   @Transactional
   public UsuarioModel save(UsuarioModel usuarioModel){
      return usuarioRepository.save(usuarioModel);
   }

   //MÉTODO QUE RETORNA TODOS OS USUÁRIOS CADASTRADOS
   public Page<UsuarioModel> findAll(Pageable pageable) {
      return usuarioRepository.findAll(pageable);
   }

   //MÉTODO QUE RETORNA APENAS UM USUÁRIO POR ID
   public Optional<UsuarioModel> findById(UUID id) {
      return usuarioRepository.findById(id);
   }

   //MÉTODO QUE DELETA UM USUÁRIO
   @Transactional
   public void delete(UsuarioModel usuarioModel) {
      usuarioRepository.delete(usuarioModel);
   }

   //MÉTODO QUE RETORNA UM USUÁRIO POR EMAIL
   public Optional<UsuarioModel> findUserByEmail(@RequestParam("email") String email){

      return this.usuarioRepository.findByEmailContains(email);
   }

   
}
