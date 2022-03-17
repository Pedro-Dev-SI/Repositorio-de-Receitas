package com.api.backend.controllers;

import com.api.backend.model.UsuarioModel;
import com.api.backend.services.UsuarioService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*", maxAge = 3600)
@RequestMapping("/api/v1/user") // http://localhost:8080/api/v1/user
public class UsuarioController {
   
   final UsuarioService usuarioService;

   public UsuarioController(UsuarioService usuarioService) {
      this.usuarioService = usuarioService;
   }

   //MÉTODO POST
   @PostMapping("/new-user")
   public ResponseEntity<Object> salvarUsuario(@RequestBody UsuarioModel usuarioModel) throws Exception{

      return usuarioService.save(usuarioModel);
   }

   // MÉTODO GET
   @GetMapping
   public ResponseEntity<Page<UsuarioModel>> getAllUsuarios(@PageableDefault(page=0, size=10, sort="id", direction=Sort.Direction.ASC)Pageable pageable){

      return usuarioService.findAll(pageable);
   }

   //MÉTODO GET ONE
   @GetMapping("/{id}")
   public ResponseEntity<Object> getOneUsuario(@PathVariable(value="id") Long id){
      
      return usuarioService.findById(id);
   }

   //MÉTODO DELETE
   @DeleteMapping("/{id}")
   public ResponseEntity<Object> deletarUsuario(@PathVariable(value="id") Long id){

      return usuarioService.delete(id);
   }

   //VERIFICA EMAIL EXISTENTE
   @GetMapping("/verify-email")
   public Boolean verificaEmail(@RequestParam String email){
         
      return usuarioService.verificaEmail(email);
   }
   
   //VALIDAR SENHA
   @GetMapping("valid-password")
   public ResponseEntity<Boolean> validarSenha(@RequestParam String email, @RequestParam String senha){

      return usuarioService.validarSenha(email, senha);
   }

}
