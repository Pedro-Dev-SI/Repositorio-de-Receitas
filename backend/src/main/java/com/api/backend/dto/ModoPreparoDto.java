package com.api.backend.dto;

import javax.validation.constraints.NotBlank;

public class ModoPreparoDto {
	
	@NotBlank
	private String descricao;

	//GETTERS AND SETTERS
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
}
