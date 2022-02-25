package com.api.backend.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TB_USUARIO")
public class UsuarioModel implements Serializable {
   
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

   
}
