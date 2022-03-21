package com.api.backend.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_USUARIO")
public class UsuarioModel implements Serializable{
   
   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(nullable = false, length = 150)
   private String primeiroNome;

   @Column(nullable = false, length = 150)
   private String ultimoNome;

   @Email
   @Column(nullable = false, length = 254, unique = true)
   private String email;

   @Column(nullable = false, length = 254)
   @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
   private String senha;

   // @OneToMany(mappedBy="usuarioModel")
   // private List<ReceitaModel> receitasModels;



}
