package com.aluguelVeiculos.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aluguelVeiculos.model.Veiculos;
import com.aluguelVeiculos.repository.VeiculosRepository;

@Service
public class veiculosService {
	
	private @Autowired VeiculosRepository repositoryVeiculo;
	
	/*Pega o veiculo pelo id verifica se ja tem o veiculo cadastrado no sistema
	 * @return caso esteja presente ele retorna vazio e se ainda não estiver no sistema ele realiza o cadastro
	 * @Author Patrik Liro
	 */
	public Optional<Veiculos> cadastrarVeiculo(Veiculos novoVeiculo) {
		Optional<Veiculos> veiculoExistente = repositoryVeiculo.findAllById(novoVeiculo.getId());
		if (veiculoExistente.isPresent()) {
			return Optional.empty();
		}
		return Optional.ofNullable(repositoryVeiculo.save(novoVeiculo));
	}
	
	
	/*public Veiculos removerCarroDeUsuario (Long idVeiculo, Long idUsuario) {
		Optional<Veiculos> veiculoExistente = repositoryVeiculo.findById(idVeiculo);
		Optional<Usuarios> usuarioExistente = repositoryUsuario.findById(idUsuario);
		
		if(usuarioExistente.isPresent() && veiculoExistente.isPresent()) {
			veiculoExistente.get().getUsuario().remove(usuarioExistente.get());
			return repositoryVeiculo.save(veiculoExistente.get());
		}
		return null;
	}

	    public void gerenciaStatusDoCarro(Long idCarro){
	        Optional<Veiculos> carroOpt = repositoryVeiculo.findById(idCarro);
	        if(carroOpt.isPresent()){
	            Veiculos veiculo = carroOpt.get();
	            veiculo.setDisponivel(false);
	            repositoryVeiculo.save(veiculo);
	        }
	    }

	    public void mudaStatusParaDisponivel(Veiculos veiculo){
	        veiculo.setDisponivel(true);
	        repositoryVeiculo.save(veiculo);
	    }*/
}
