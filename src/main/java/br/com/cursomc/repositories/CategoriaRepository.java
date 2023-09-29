package br.com.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cursomc.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
