package com.api.backend.config;

import com.api.backend.model.UsuarioModel;
import com.api.backend.repository.UsuarioRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public class ImplementsUserDetailsService implements UserDetailsService{


   final UsuarioRepository usuarioRepository;

   public ImplementsUserDetailsService(UsuarioRepository usuarioRepository) {
      this.usuarioRepository = usuarioRepository;
   }


   @Override
   public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

      UsuarioModel usuarioModel = usuarioRepository.findByEmail(email);

      if(usuarioModel == null) {
         throw new UsernameNotFoundException("Email não cadastrado");
      }
      return usuarioModel;
   }
   
}
