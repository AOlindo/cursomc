package br.com.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cursomc.domain.Categoria;
import br.com.cursomc.domain.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	Cliente findOneById(Long id);
}