package com.aluguelVeiculos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aluguelVeiculos.model.Usuarios;
import com.aluguelVeiculos.model.Veiculos;
import com.aluguelVeiculos.repository.AluguelRepository;
import com.aluguelVeiculos.repository.UsuarioRepository;
import com.aluguelVeiculos.repository.VeiculosRepository;

@Service
public class aluguelService {

	private @Autowired AluguelRepository repositoryAluguel;
	private @Autowired VeiculosRepository repositoryVeiculos;
	private @Autowired UsuarioRepository repositoryUsuario;
	
	/*Seleciona todos os veiculos que estão ligados a usuario por id, Caso o campo seja vazio 
	 * @Return veiculo disponivel caso esteja preenchido retorno vazio.
	 * @Author Patrik Liro
	 */
	public Optional<Veiculos> verificarDisponibilidade(Veiculos veiculo)	{
		Optional<Veiculos> veiculoDisponivel = repositoryVeiculos.findAllUsuarioByVeiculoPlaca(veiculo.getUsuario());
		if(veiculoDisponivel.isEmpty()) {
			return veiculoDisponivel;
		}
		return Optional.empty();
	}
	
	/*Verifica se o usuario esta cadastrado
	 * verifica se o veiculo esta disponivel
	 * @return o usuario com os dados do veiculo salvos
	 * @Author Patrik Liro
	 */
	public Usuarios AlugarVeiculo(Long idUsuario, Long idVeiculo) {
		Optional<Usuarios> usuarioExistente = repositoryUsuario.findAllById(idUsuario);
		Optional<Veiculos> veiculoDisponivel = repositoryVeiculos.findAllById(idVeiculo);
		if(veiculoDisponivel.isPresent() && usuarioExistente.isPresent()) {
			usuarioExistente.get().setId(idVeiculo);
			return repositoryUsuario.save(usuarioExistente.get());
		}
		return null;
	}
}
