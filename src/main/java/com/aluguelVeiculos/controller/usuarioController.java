package com.aluguelVeiculos.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aluguelVeiculos.model.Usuarios;
import com.aluguelVeiculos.model.Veiculos;
import com.aluguelVeiculos.repository.UsuarioRepository;
import com.aluguelVeiculos.service.usuariosService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin("*")
public class usuarioController {

	private @Autowired UsuarioRepository repository;
	private @Autowired usuariosService serviceUsuario;
	
	
	@GetMapping
	public ResponseEntity<List<Usuarios>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuarios> getById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<?> cadastrarVeiculo(@Valid @RequestBody Usuarios novoUsuario){
		Optional<Usuarios> validaCpf = serviceUsuario.validaCpf(novoUsuario);
		Optional<Usuarios> dto = serviceUsuario.cadastrarUsuario(novoUsuario);
		return !dto.isEmpty() ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
	}
	
	@PutMapping
	public ResponseEntity<Usuarios> alterarDados (@RequestBody Usuarios usuario){	
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(usuario));
	}
	
	@DeleteMapping("/{id}")
	public void delete (@PathVariable long id) {
		repository.deleteById(id);
	}
}
