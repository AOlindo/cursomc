package br.com.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cursomc.domain.Categoria;
import br.com.cursomc.domain.Cliente;
import br.com.cursomc.domain.Endereco;


public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
	
}