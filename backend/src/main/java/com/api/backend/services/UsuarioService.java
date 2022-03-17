package com.api.backend.services;

import java.util.Optional;

import javax.transaction.Transactional;

import com.api.backend.exceptions.EmailExistsException;
import com.api.backend.exceptions.UserNotFoundException;
import com.api.backend.model.UsuarioModel;
import com.api.backend.repository.UsuarioRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class UsuarioService {
   
   private final UsuarioRepository usuarioRepository;
   private final PasswordEncoder encoder;

   public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder encoder) {
      this.usuarioRepository = usuarioRepository;
      this.encoder = encoder;
   }

   

   //MÉTODO PARA SALVAR UM USUÁRIO NO BANCO DE DADOS
   @Transactional
   public ResponseEntity<Object> save(UsuarioModel usuarioModel) throws Exception{

      Optional<UsuarioModel> usuarioModelOptional = usuarioRepository.findByEmailContains(usuarioModel.getEmail());

      try {
         if(usuarioModelOptional.isPresent()) {
            throw new EmailExistsException("Email já cadastrado no sistema");
         }

      } catch (Exception e) {
         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
      }

      usuarioModel.setSenha(encoder.encode(usuarioModel.getSenha()));

      return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuarioModel)) ;

   }

   //MÉTODO QUE RETORNA TODOS OS USUÁRIOS CADASTRADOS
   public ResponseEntity<Page<UsuarioModel>> findAll(Pageable pageable) {
      return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.findAll(pageable));
   }

   //MÉTODO QUE RETORNA APENAS UM USUÁRIO POR ID

   public ResponseEntity<Object> findById(Long id) {

      Optional<UsuarioModel> usuarioModelOptional = usuarioRepository.findById(id);

      try {
         if (!usuarioModelOptional.isPresent()){
            throw new UserNotFoundException("Usuário não encontrado");
         }

         return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.findById(id));

      } catch (Exception e) {
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
      }

   }

   //MÉTODO QUE DELETA UM USUÁRIO
   @Transactional
   public ResponseEntity<Object> delete(Long id) {
      Optional<UsuarioModel> usuarioModelOptional = usuarioRepository.findById(id);

      try {
         if (!usuarioModelOptional.isPresent()){
            throw new UserNotFoundException("Usuário não encontrado");
         }

         usuarioRepository.delete(usuarioModelOptional.get());

         return ResponseEntity.status(HttpStatus.OK).body("Usuário deletado com sucesso");
         

      } catch (Exception e) {
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
      }
   }

   //MÉTODO QUE VALIDA UMA SENHA
   public ResponseEntity<Boolean> validarSenha(@RequestParam String email, @RequestParam String senha){

      Optional<UsuarioModel> usuarioModelOptional = usuarioRepository.findByEmail(email);

      if(!usuarioModelOptional.isPresent()) {
         return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
      }

      boolean valid = false;
      valid = encoder.matches(senha, usuarioModelOptional.get().getSenha());

      HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
      return ResponseEntity.status(status).body(valid);
   }

   
}
