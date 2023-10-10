package br.com.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cursomc.domain.Cidade;


public interface CidadeRepository extends JpaRepository<Cidade, Long> {


}