package com.aluguelVeiculos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aluguelVeiculos.model.Usuarios;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios, Long> {

	public Optional<Usuarios> findAllByEmail(String email);

	public Optional<Usuarios> findAllByCpf(Long idUsuario);

	public Optional<Usuarios> findAllById(Long id);
}
