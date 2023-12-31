package br.com.cursomc.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.cursomc.domain.Categoria;
import br.com.cursomc.domain.Produto;
import javax.transaction.Transactional;


public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	Produto findOneById(Long id);

	@Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.categoria cat WHERE obj.nome LIKE %:nome% AND cat IN :categorias")
	Page<Produto> findDistinctByNomeContainingAndCategoriasIn(@Param("nome") String nome, @Param("categorias") List<Categoria> categorias, Pageable pageRequest);
	
}