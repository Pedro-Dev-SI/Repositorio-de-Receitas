package com.api.backend.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "TB_USUARIO")
public class UsuarioModel implements Serializable, UserDetails {
   
   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private UUID id;

   @Column(nullable = false, length = 150)
   private String primeiro_nome;

   @Column(nullable = false, length = 150)
   private String ultimo_nome;

   @Email
   @Column(nullable = false, length = 254)
   private String email;

   @Column(nullable = false, length = 254)
   private String senha;

   @OneToMany(mappedBy="usuarioModel")
   private List<ReceitaModel> receitasModels;

   public UsuarioModel() {
   }

   public UsuarioModel(UUID id, String primeiro_nome, String ultimo_nome, String email,
         String senha) {
      super();
      this.id = id;
      this.primeiro_nome = primeiro_nome;
      this.ultimo_nome = ultimo_nome;
      this.email = email;
      this.senha = senha;
   }

   @Override
   public Collection<? extends GrantedAuthority> getAuthorities(){
      return null;
   }

   @Override
   public String getPassword() {
      return this.senha;
   }

   @Override
   public String getUsername() {
      return this.email;
   }

   @Override
   public boolean isAccountNonExpired() {
      return true;
   }
   
   @Override
   public boolean isAccountNonLocked(){
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
