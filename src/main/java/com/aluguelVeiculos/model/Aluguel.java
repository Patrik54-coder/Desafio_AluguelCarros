package com.aluguelVeiculos.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_aluguel")
public class Aluguel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private LocalDate dataRetirada;

	@NotNull
	private LocalDate dataDevolucao;
	
	@NotNull
	private Long qtDias;
	
	@NotNull
	private Float valorDiaria;
	
	@ManyToOne
	private Usuarios usuario;
	
	@ManyToOne
	private Veiculos veiculos;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataRetirada() {
		return dataRetirada;
	}

	public void setDataRetirada(LocalDate dataRetirada) {
		this.dataRetirada = dataRetirada;
	}

	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public Long getQtDias() {
		return qtDias;
	}

	public void setQtDias(Long qtDias) {
		this.qtDias = qtDias;
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

	public Veiculos getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(Veiculos veiculos) {
		this.veiculos = veiculos;
	}

}
