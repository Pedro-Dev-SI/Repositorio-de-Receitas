package com.api.backend.dto;

import javax.validation.constraints.NotBlank;

public class IngredientesDto {
	
	@NotBlank
	private String nome_ingrediente;
	@NotBlank
	private String quantidade; //drpodown com campo de texto
	
	//GETTERS AND SETTERS
	public String getNome_ingrediente() {
		return nome_ingrediente;
	}
	public void setNome_ingrediente(String nome_ingrediente) {
		this.nome_ingrediente = nome_ingrediente;
	}
	public String getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}
	
	
	
	
}
