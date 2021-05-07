package com.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.model.usuario;

public interface usuarioRepository extends JpaRepository<usuario, Long>{
	
}
