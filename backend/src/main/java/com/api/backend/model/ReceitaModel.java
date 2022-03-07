package com.api.backend.model;
import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "TB_RECEITA")
public class ReceitaModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@Column(nullable = false, length = 150)
	private String nome_receita;
	@Column(nullable = false, length = 40)
	private String tempo_preparo;
	@Column(nullable = false, length = 4000)
	private String categoria; //checkbox
	@Column(nullable = false, length = 70)
	private String rendimento; //drpodown com campo de texto
	@Column(nullable = false, length = 8000)
	private String ingredientes;
	@Column(nullable = false, length = 8000)
	private String modo_de_preparo;

	@ManyToOne
	@JoinColumn(name = "usuarioModel_id")
	private UsuarioModel usuarioModel;
	
	
	public ReceitaModel() {
		
	}
	
	public ReceitaModel(UUID id, String nome_receita, String tempo_preparo, String categoria,
		String rendimento, String ingredientes, String modo_de_preparo, UsuarioModel usuarioModel) {
		super();
		this.id = id;
		this.nome_receita = nome_receita;
		this.tempo_preparo = tempo_preparo;
		this.categoria = categoria;
		this.rendimento = rendimento;
		this.ingredientes = ingredientes;
		this.modo_de_preparo = modo_de_preparo;
		this.usuarioModel = usuarioModel;
	}

}
