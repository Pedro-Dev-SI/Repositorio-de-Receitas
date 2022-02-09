package com.api.backend.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ModoPreparo implements Serializable {
	
	private static final long serialVersionUID = 1L;
   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID mpid;
	private String descricao;
	
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
