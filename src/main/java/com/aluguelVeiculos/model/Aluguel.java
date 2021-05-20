package com.aluguelVeiculos.model;

import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			  name = "", 
			  joinColumns = @JoinColumn(name = "aluguel_id"), 
			  inverseJoinColumns = @JoinColumn(name = "usuario_id"))
	@JsonIgnoreProperties("usuario")
	private Usuarios usuario;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			  name = "", 
			  joinColumns = @JoinColumn(name = "aluguel_id"), 
			  inverseJoinColumns = @JoinColumn(name = "veiculo_id"))
	@JsonIgnoreProperties("veiculos")
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
