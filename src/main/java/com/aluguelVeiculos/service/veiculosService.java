package com.aluguelVeiculos.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aluguelVeiculos.model.Veiculos;
import com.aluguelVeiculos.repository.VeiculosRepository;

@Service
public class veiculosService {
	
	private @Autowired VeiculosRepository repositoryVeiculos;
	
	/*Pega o veiculo pelo id verifica se ja tem o veiculo cadastrado no sistema
	 * @return caso esteja presente ele retorna vazio e se ainda não estiver no sistema ele realiza o cadastro
	 * @Author Patrik Liro
	 */
	public Optional<Veiculos> cadastrarVeiculo(Veiculos novoVeiculo) {
		Optional<Veiculos> veiculoExistente = repositoryVeiculos.findAllById(novoVeiculo.getId());
		if (veiculoExistente.isPresent()) {
			return Optional.empty();
		}
		return Optional.ofNullable(repositoryVeiculos.save(novoVeiculo));
	}
	
	
	
	/*public Optional<Veiculos> valorAluguel(Long idVeiculo, Long idUsuario){
		Optional<Veiculos> veiculoExistente = repositoryVeiculos.findAllById(idVeiculo);
		Optional<Usuarios> usuarioExistente = repositoryUsuario.findAllById(idUsuario);
			veiculoExistente.get().getValorDiaria();
			usuarioExistente.get().getQtDias();	
			
		}*/
}
