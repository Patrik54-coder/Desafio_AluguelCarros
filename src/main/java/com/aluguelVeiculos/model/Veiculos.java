package com.aluguelVeiculos.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_veiculos")
public class Veiculos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String marca;
	
	@NotNull
	private String modelo;
	
	private String cor;
	
	@NotNull
	private String placa;
	
	protected String disponivel;
	
	@OneToMany(mappedBy = "veiculos" , cascade = CascadeType.ALL)
	@JsonIgnoreProperties("Veiculos")
	private List<Aluguel> aluguel = new ArrayList<>();
	
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

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	public String getDisponivel() {
		return disponivel;
	}

	public ResponseEntity<?> setDisponivel(String disponivel) {
		this.disponivel = disponivel;
		return null;
	}

	public List<Aluguel> getAluguel() {
		return aluguel;
	}

	public void setAluguel(List<Aluguel> aluguel) {
		this.aluguel = aluguel;
	}

	
	

}
