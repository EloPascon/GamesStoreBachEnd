package com.generation.lojadegames.model;

	import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

    
   
	@Entity
	@Table(name = "tb_categorias")
	public class Categorias {
		
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO INCREMENTE
		private Long id;
		
		@NotBlank(message = "tipo é obrigatório prencher")
		@Size(min = 5 , max = 100)
		private String tipo;
		
		@NotBlank(message = "console é obrigatório")
		@Size(min = 1, max = 30)
		private String console;
		
		@OneToMany(mappedBy = "categorias", cascade = CascadeType.REMOVE)
		@JsonIgnoreProperties("categorias")
		private List <Produtos> produtos;


		public String getTipo() {
			return tipo;
		}

		public void setTipo(String tipo) {
			this.tipo = tipo;
		}

		public String getConsole() {
			return console;
		}

		public void setConsole(String console) {
			this.console = console;
		}

		public List<Produtos> getProdutos() {
			return produtos;
		}

		public void setProdutos(List<Produtos> produtos) {
			this.produtos = produtos;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getId() {
			// TODO Auto-generated method stub
			return null;
		}
}
