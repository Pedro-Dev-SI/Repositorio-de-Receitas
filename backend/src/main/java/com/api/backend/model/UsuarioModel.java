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

   // GETTERS AND SETTERS
   public UUID getId() {
      return id;
   }

   public void setId(UUID id) {
      this.id = id;
   }

   public String getPrimeiro_nome() {
      return primeiro_nome;
   }

   public void setPrimeiro_nome(String primeiro_nome) {
      this.primeiro_nome = primeiro_nome;
   }

   public String getUltimo_nome() {
      return ultimo_nome;
   }

   public void setUltimo_nome(String ultimo_nome){
      this.ultimo_nome = ultimo_nome;
   }

   public String getEmail(){
      return email;
   }

   public void setEmail(String email){
      this.email = email;
   }

   public String getSenha(){
      return senha;
   }

   public void setSenha(String senha){
      this.senha = senha;
   }

}
