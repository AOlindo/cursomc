package br.com.cursomc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cursomc.domain.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
	
	//Retorna todos os estados, ordenados por nome
	public List<Estado> findAllByOrderByNome();

}