package com.aluguelVeiculos.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aluguelVeiculos.model.Usuarios;
import com.aluguelVeiculos.repository.UsuarioRepository;
import br.com.caelum.stella.validation.CPFValidator;

@Service
public class usuariosService {

	private @Autowired UsuarioRepository repositoryUsuario;

	public Optional<Usuarios> cadastrarUsuario(Usuarios novoUsuario) {
		Optional<Usuarios> usuarioExistente = repositoryUsuario.findAllById(novoUsuario.getId());
		if (usuarioExistente.isPresent()) {
			return Optional.empty();
		}
		return Optional.ofNullable(repositoryUsuario.save(novoUsuario));
	}

	public Optional<Usuarios> validaCpf(Usuarios usuario){
		CPFValidator cpfValidator = new CPFValidator();
		String cpf = usuario.getCpf(); 
		cpfValidator.assertValid(cpf);
		return usuario.setCpf(cpf);
	}
	
	
	
	
	
}
