package br.com.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cursomc.domain.Produto;


public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}