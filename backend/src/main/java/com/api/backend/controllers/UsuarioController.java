package com.api.backend.controllers;

import java.util.Optional;
import java.util.UUID;

import com.api.backend.model.UsuarioModel;
import com.api.backend.services.UsuarioService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*", maxAge = 3600)
@RequestMapping("/usuarios")
public class UsuarioController {
   
   final UsuarioService usuarioService;

   public UsuarioController(UsuarioService usuarioService) {
      this.usuarioService = usuarioService;
   }

   //GET ONE BY EMAIL
   @GetMapping("/filter")
   public ResponseEntity<Object> findUserByEmail(@PathVariable(value="email") String email){

      Optional<UsuarioModel> usuarioModelOptional = usuarioService.findUserByEmail(email);

      if(!usuarioModelOptional.isPresent()) {
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
      }

      return ResponseEntity.status(HttpStatus.OK).body(usuarioModelOptional.get());
   }

   //MÉTODO POST
   @PostMapping
   public ResponseEntity<Object> saveUsuario(@RequestBody UsuarioModel usuarioModel){

      Optional<UsuarioModel> usuarioModelOptional = usuarioService.findUserByEmail(usuarioModel.getEmail());

      if(usuarioModelOptional.isPresent()) {
         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email já cadastrado no sistema");
      }

      return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuarioModel));
   }

   // MÉTODO GET
   public ResponseEntity<Page<UsuarioModel>> getAllUsuarios(@PageableDefault(page=0, size=10, sort="id", direction=Sort.Direction.ASC)Pageable pageable){
      return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findAll(pageable));
   }

   //MÉTODO GET ONE
   @GetMapping("/{id}")
   public ResponseEntity<Object> getOneUsuario(@PathVariable(value="id") UUID id){
      Optional<UsuarioModel> usuarioModelOptional = usuarioService.findById(id);

      if(!usuarioModelOptional.isPresent()) {
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
      }

      return ResponseEntity.status(HttpStatus.OK).body(usuarioModelOptional.get());
   }

   //MÉTODO DELETE
   @DeleteMapping("/{id}")
   public ResponseEntity<Object> deleteUsuario(@PathVariable(value="id") UUID id){
      Optional<UsuarioModel> usuarioModelOptional = usuarioService.findById(id);

      if(!usuarioModelOptional.isPresent()) {
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
      }

      usuarioService.delete(usuarioModelOptional.get());

      return ResponseEntity.status(HttpStatus.OK).body("Usuário deletado com sucesso");
   }

   //MÉTODO UPDATE
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateUsuario(@PathVariable(value="id") UUID id, 
			@RequestBody  UsuarioModel usuarioModel){
		
		Optional<UsuarioModel> usuarioModelOptional = usuarioService.findById(id);
		
		if(!usuarioModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
		}
		
		usuarioModel.setId(usuarioModelOptional.get().getId());
		return ResponseEntity.status(HttpStatus.OK).body(usuarioService.save(usuarioModel));
	}

   



}
