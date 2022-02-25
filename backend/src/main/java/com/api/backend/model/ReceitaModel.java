package com.api.backend.model;
import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
	@Column(nullable = false, length = 8000)
	private String ingredientes;
	@Column(nullable = false, length = 8000)
	private String modo_de_preparo;
	
	
	public ReceitaModel() {
		
	}
	
	public ReceitaModel(UUID id, String nome_receita, String tempo_preparo, String categoria, String nome_chef,
			String rendimento ) {
			super();
			this.id = id;
			this.nome_receita = nome_receita;
			this.tempo_preparo = tempo_preparo;
			this.categoria = categoria;
			this.nome_chef = nome_chef;
			this.rendimento = rendimento;
	}

	

}
