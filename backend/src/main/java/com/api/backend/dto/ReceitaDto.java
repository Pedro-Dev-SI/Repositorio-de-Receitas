package com.api.backend.dto;

import javax.validation.constraints.NotBlank;

//Valições dos dados da Receita

public class ReceitaDto {
	
	@NotBlank
	private String nome_receita;
	@NotBlank
	private String tempo_preparo;
	@NotBlank
	private String categoria; //checkbox
	@NotBlank
	private String nome_chef;
	@NotBlank
	private String rendimento; //drpodown com campo de texto
	
	//GETTERS AND SETTERS
	public String getNome_receita() {
		return nome_receita;
	}
	public void setNome_receita(String nome_receita) {
		this.nome_receita = nome_receita;
	}
	public String getTempo_preparo() {
		return tempo_preparo;
	}
	public void setTempo_preparo(String tempo_preparo) {
		this.tempo_preparo = tempo_preparo;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getNome_chef() {
		return nome_chef;
	}
	public void setNome_chef(String nome_chef) {
		this.nome_chef = nome_chef;
	}
	public String getRendimento() {
		return rendimento;
	}
	public void setRendimento(String rendimento) {
		this.rendimento = rendimento;
	}
	
	

}
