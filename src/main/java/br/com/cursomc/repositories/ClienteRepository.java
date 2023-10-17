package br.com.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cursomc.domain.Cliente;
import javax.transaction.Transactional;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	Cliente findOneById(Long id);
	
	@Transactional
	Cliente findByEmail(String email);
}