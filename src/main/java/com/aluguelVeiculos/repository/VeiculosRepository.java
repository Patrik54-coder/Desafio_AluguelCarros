package com.aluguelVeiculos.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.aluguelVeiculos.model.Veiculos;

@Repository
public interface VeiculosRepository extends JpaRepository<Veiculos, Long> {

	public Optional<Veiculos> findAllByPlaca (String veiculo);
	
	public Optional<Veiculos> findAllByModelo (String modelo);
	
	public Optional<Veiculos> findAllById (Long idVeiculo);
	
	
	@Query(value = ""
			+ "SELECT * FROM tb_veiculos "
			+ "INNER JOIN tb_usuario "
			+ "ON tb_veiculos.id = tb_veiculos.usuario_id "
			+ "WHERE tb_veiculos.placa LIKE CONCAT('%',:veiculo,'%')", nativeQuery = true)
	public Optional<Veiculos> findAllUsuarioByVeiculoPlaca(@Param("veiculo") Long id);

}
