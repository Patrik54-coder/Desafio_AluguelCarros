package com.aluguelVeiculos.controller;

import java.util.List;
import java.util.Optional;
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
import com.aluguelVeiculos.repository.VeiculosRepository;
import com.aluguelVeiculos.service.veiculosService;


@RestController
@RequestMapping("/veiculo")
@CrossOrigin("*")
public class VeiculosController {

	private @Autowired VeiculosRepository repositoryVeiculo;
	private @Autowired veiculosService serviceVeiculo;
	private @Autowired UsuarioRepository repositoryUsuario;
	
	
	@GetMapping
	public ResponseEntity<List<Veiculos>> getAll(){
		return ResponseEntity.ok(repositoryVeiculo.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Veiculos> getById(@PathVariable long id){
		return repositoryVeiculo.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	@PostMapping("/cadastrar")
	public ResponseEntity<?> cadastrarVeiculo(@RequestBody Veiculos novoVeiculo){
		Optional<Veiculos> dto = serviceVeiculo.cadastrarVeiculo(novoVeiculo);
		return !dto.isEmpty() ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
	}
	
	/*@PostMapping("/aluguel/usuario/{veiculo_id}/{usuario_id}")
	public ResponseEntity<?> alugarVeiculo(
			@PathVariable(value = "veiculo_id") Long idVeiculo,
			@PathVariable(value = "usuario_id") Long idUsuario){
		Usuarios aluguel = serviceVeiculo.AlugarVeiculo(idUsuario, idVeiculo);
		if(aluguel == null) {
			return new ResponseEntity<String>("Veiculo ou Cliente inválido", HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Usuarios>(aluguel, HttpStatus.CREATED);
	}*/
	
	@PutMapping("/alterar")
	public ResponseEntity<Veiculos> alterarDados (@RequestBody Veiculos veiculos){	
		return ResponseEntity.status(HttpStatus.OK).body(repositoryVeiculo.save(veiculos));
	}
	
	@DeleteMapping("/{id}")
	public void delete (@PathVariable long id) {
		repositoryVeiculo.deleteById(id);
	}
	
}
