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

@Entity
@Table(name = "TB_INGREDIENTES")
public class IngredientesModel implements Serializable {
	
		private static final long serialVersionUID = 1L;
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private UUID iid;
		@Column(nullable = false, length = 130)
		private String nome_ingrediente;
		@Column(nullable = false, length = 70)
		private String quantidade; //drpodown com campo de texto
		
		@ManyToOne
		@JoinColumn(name = "receitaModel_id")
		private ReceitaModel receitaModel;
		
		
		public IngredientesModel() {
			
		}
		
		public IngredientesModel(UUID iid, String nome_ingrediente, String quantidade, ReceitaModel receitaModel) {
				super();
				this.iid = iid;
				this.nome_ingrediente = nome_ingrediente;
				this.quantidade = quantidade;
				this.receitaModel = receitaModel;
		}

		//GETTERS AND SETTERS
	
		public UUID getIid() {
			return iid;
		}
	
		public void setIid(UUID iid) {
			this.iid = iid;
		}
	
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
