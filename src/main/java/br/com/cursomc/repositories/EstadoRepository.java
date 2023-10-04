package br.com.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cursomc.domain.Estado;


public interface EstadoRepository extends JpaRepository<Estado, Long> {

}