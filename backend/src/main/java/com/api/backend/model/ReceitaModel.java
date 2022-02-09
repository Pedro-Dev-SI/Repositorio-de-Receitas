package com.api.backend.model;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	@Column(nullable = false, length = 10)
	private String categoria; //checkbox
	@Column(nullable = false, length = 150)
	private String nome_chef;
	@Column(nullable = false, length = 70)
	private String rendimento; //drpodown com campo de texto
	
	//Usei o CascadeType.ALL pelo motivo de quando eu salvar a receita vai salvar o modo de preparo e os ingredientes
	//do mesmo modo quando eu apagar uma receita
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "receitaModel")
	private List<IngredientesModel> ingredientes;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "receitaModel")
	private List<ModoPreparoModel> modoPreparo;
	
	
	//GETTERS AND SETTERS
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

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

	public List<IngredientesModel> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<IngredientesModel> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public List<ModoPreparoModel> getModoPreparo() {
		return modoPreparo;
	}

	public void setModoPreparo(List<ModoPreparoModel> modoPreparo) {
		this.modoPreparo = modoPreparo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
