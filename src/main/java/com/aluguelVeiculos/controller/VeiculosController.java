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
import com.aluguelVeiculos.model.Veiculos;
import com.aluguelVeiculos.repository.VeiculosRepository;
import com.aluguelVeiculos.service.veiculosService;

@RestController
@RequestMapping("/veiculo")
@CrossOrigin("*")
public class VeiculosController {

	private @Autowired VeiculosRepository repositoryVeiculo;
	private @Autowired veiculosService serviceVeiculo;

	@GetMapping
	public ResponseEntity<List<Veiculos>> getAll() {
		return ResponseEntity.ok(repositoryVeiculo.findAll());
	}
	
	@PostMapping("/disponivel")
	public ResponseEntity<?> trazerVeiculoDiponivel(@PathVariable Long idVeiculo) {
		Optional<Veiculos> dto = repositoryVeiculo.findAllUsuarioByVeiculoPlaca(idVeiculo);
		return !dto.isEmpty() ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Veiculos> getById(@PathVariable long id) {
		return repositoryVeiculo.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<?> cadastrarVeiculo(@RequestBody Veiculos novoVeiculo) {
		Optional<Veiculos> dto = serviceVeiculo.cadastrarVeiculo(novoVeiculo);
		return !dto.isEmpty() ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
	}
	
	@PutMapping("/alterar")
	public ResponseEntity<Veiculos> alterarDados(@RequestBody Veiculos veiculos) {
		return ResponseEntity.status(HttpStatus.OK).body(repositoryVeiculo.save(veiculos));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repositoryVeiculo.deleteById(id);
	}

}
