package com.generation.lojadegames.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "tb_produtos")
public class Produtos {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO INCREMENTE
	private Long id;
	
	@NotBlank(message = "nome é obrigatório prencher")
	@Size(min = 5 , max = 100)
	private String Nome;
	
	@NotBlank(message = "descrição é obrigatório")
	@Size(min = 15, max = 1000)
	private String descricao;
	
	@NotNull(message = "foto do produto é obrigatório")
	@Size(min = 1, max = 1000)
	private String foto;
	
    @NotNull(message = "valor é obrigatório")
    @Digits(integer = 4, fraction = 2, message = "aceita no maximo 4 casa de numero antes do ponto e duas casas apos o ponto")
	private BigDecimal valor;
    
    @ManyToOne
	@JsonIgnoreProperties("produtos")
	private Categorias categorias;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Categorias getCategorias() {
		return categorias;
	}

	public void setCategorias(Categorias categorias) {
		this.categorias = categorias;
	}

    
    
    
}
