package com.api.backend.services;

import java.util.Optional;

import com.api.backend.data.DetalheUsuarioData;
import com.api.backend.model.UsuarioModel;
import com.api.backend.repository.UsuarioRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class DetalheUsuarioServiceImpl implements UserDetailsService{

   private final UsuarioRepository usuarioRepository;

   public DetalheUsuarioServiceImpl(UsuarioRepository usuarioRepository) {
      this.usuarioRepository = usuarioRepository;
   }

   @Override
   public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

      Optional<UsuarioModel> usuarioModel = usuarioRepository.findByEmail(email);

      if(usuarioModel.isEmpty()){
         throw new UsernameNotFoundException("Usuário [" + email + "] não encontrado");
      }

      return new DetalheUsuarioData(usuarioModel);
   }
   
}
