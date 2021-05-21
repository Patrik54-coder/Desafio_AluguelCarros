package com.aluguelVeiculos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aluguelVeiculos.model.Aluguel;
import com.aluguelVeiculos.model.Usuarios;
import com.aluguelVeiculos.model.Veiculos;
import com.aluguelVeiculos.repository.UsuarioRepository;
import com.aluguelVeiculos.repository.VeiculosRepository;

@Service
public class aluguelService {
	
	private @Autowired VeiculosRepository repositoryVeiculo;
	private @Autowired UsuarioRepository repositoryUsuario;
	
	public Optional<Aluguel> aluguel (Aluguel dto, Long idUsuario, Long idVeiculo) {
		Optional<Veiculos> veiculoExistente = repositoryVeiculo.findAllById(idVeiculo);
		Optional<Usuarios> usuarioExistente = repositoryUsuario.findAllById(idUsuario);
		
		if(veiculoExistente.isPresent() && usuarioExistente.isPresent()) {
        Aluguel aluguel = new Aluguel();
        aluguel.setDataRetirada(dto.getDataRetirada());
        aluguel.setDataDevolucao(dto.getDataDevolucao());
        aluguel.setQtDias(dto.getQtDias());
        aluguel.setValorDiaria(dto.getValorDiaria());
        aluguel.setUsuario(dto.getUsuario());
        aluguel.setVeiculos(dto.getVeiculos());
        return Optional.ofNullable(aluguel);
    }
		return Optional.empty();
	}
	
	public float valorAluguel(Long qtDias, Float valorDiaria) {
		Aluguel aluguel = new Aluguel();
		float valor = qtDias*valorDiaria;
		return valor;
	}
	
	
}
