package com.aluguelVeiculos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_veiculos", uniqueConstraints = @UniqueConstraint(columnNames = { "placa","modelo" }))
public class Veiculos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String marca;
	
	@NotNull
	@Column(unique=true)
	private String modelo;
	
	private String cor;
	
	@NotNull
	@Column(unique=true)
	private String placa;
	
	@NotNull
	private Float valorDiaria;
	
	@NotNull
	protected Boolean disponivel;
	
	@ManyToOne
	@JsonIgnoreProperties("aluguel")
	private Aluguel aluguel;
	
	@OneToOne
	@JsonIgnoreProperties("Veiculos")
	private Usuarios usuario;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		id = this.id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Float getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(Float valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	public Boolean getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(Boolean disponivel) {
		this.disponivel = disponivel;
	}
	

}
