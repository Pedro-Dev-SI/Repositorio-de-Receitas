package com.api.backend.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_MODO_PREPARO")
public class ModoPreparoModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID mpid;
	@Column(nullable = false, length = 200)
	private String descricao;
	
	
	@ManyToOne
	private ReceitaModel receitaModel;
	
	//GETTERS AND SETTERS

	public UUID getMpid() {
		return mpid;
	}

	public void setMpid(UUID mpid) {
		this.mpid = mpid;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public ReceitaModel getReceitaModel() {
		return receitaModel;
	}

	public void setReceitaModel(ReceitaModel receitaModel) {
		this.receitaModel = receitaModel;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
