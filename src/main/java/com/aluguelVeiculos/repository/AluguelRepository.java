package com.aluguelVeiculos.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aluguelVeiculos.model.Aluguel;

@Repository
public interface AluguelRepository extends JpaRepository<Aluguel, Long> {

	public Optional<Aluguel> findAllById(Long id);
}
