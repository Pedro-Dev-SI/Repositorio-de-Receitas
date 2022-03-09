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
	private String nomeReceita;
	@Column(nullable = false, length = 40)
	private String tempoPreparo;
	@Column(nullable = false, length = 4000)
	private String categoria; //checkbox
	@Column(nullable = false, length = 70)
	private String rendimentoDescricao;
	@Column(nullable = false, length = 70)
	private String rendimentoUnidade; //drpodown com campo de texto
	@Column(nullable = false, length = 8000)
	private String ingredientes;
	@Column(nullable = false, length = 8000)
	private String modoDePreparo;

	@ManyToOne
	@JoinColumn(name = "usuarioModel_id")
	private UsuarioModel usuarioModel;
	
	
	public ReceitaModel() {
		
	}
	
	public ReceitaModel(UUID id, String nomeReceita, String tempoPreparo, String categoria,
		String rendimentoDescricao, String rendimentoUnidade, String ingredientes, String modoDePreparo, UsuarioModel usuarioModel) {
		super();
		this.id = id;
		this.nomeReceita = nomeReceita;
		this.tempoPreparo = tempoPreparo;
		this.categoria = categoria;
		this.rendimentoDescricao = rendimentoDescricao;
		this.rendimentoUnidade = rendimentoUnidade;
		this.ingredientes = ingredientes;
		this.modoDePreparo = modoDePreparo;
		this.usuarioModel = usuarioModel;
	}

}
