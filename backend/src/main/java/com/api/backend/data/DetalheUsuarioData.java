package com.api.backend.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import com.api.backend.model.UsuarioModel;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class DetalheUsuarioData implements UserDetails{

   private final Optional<UsuarioModel> usuarioModel;

   public DetalheUsuarioData(Optional<UsuarioModel> usuarioModel) {
      this.usuarioModel = usuarioModel;
   }

   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {

      return new ArrayList<>();
   }

   @Override
   public String getPassword() {

      return usuarioModel.orElse(new UsuarioModel()).getSenha();
   }

   @Override
   public String getUsername() {

      return usuarioModel.orElse(new UsuarioModel()).getEmail();
   }

   @Override
   public boolean isAccountNonExpired() {

      return true;
   }

   @Override
   public boolean isAccountNonLocked() {

      return true;
   }

   @Override
   public boolean isCredentialsNonExpired() {

      return true;
   }

   @Override
   public boolean isEnabled() {

      return true;
   }
   
}
