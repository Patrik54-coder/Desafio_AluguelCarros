package com.aluguelVeiculos.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aluguelVeiculos.model.Aluguel;
import com.aluguelVeiculos.repository.AluguelRepository;
import com.aluguelVeiculos.repository.VeiculosRepository;
import com.aluguelVeiculos.service.aluguelService;

@RestController
@RequestMapping("/aluguel")
@CrossOrigin("*")
public class aluguelController {

	private @Autowired aluguelService serviceAluguel;
	private @Autowired AluguelRepository repositoryAluguel;
	
	@PostMapping("/valor")
	public ResponseEntity<?> valorAluguel(@RequestBody Long qtDia, Float valorDiaria) {
		float dto = serviceAluguel.valorAluguel(qtDia,valorDiaria);
		return ResponseEntity.ok(dto);
	}
	
	@PostMapping("/alugar/{id_usuario:.*}/{id:.*}")
	public ResponseEntity<?> alugarVeiculo(
			@RequestBody Aluguel novoAluguel,
			@PathVariable(value= "id_usuario")long idUsuario,
			@PathVariable(value= "id")long id){
		Optional<Optional<Aluguel>> dto = Optional.ofNullable(serviceAluguel.aluguel(novoAluguel,idUsuario,id));
		return !dto.isEmpty() ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repositoryAluguel.deleteById(id);
	}
	
	
	
}
