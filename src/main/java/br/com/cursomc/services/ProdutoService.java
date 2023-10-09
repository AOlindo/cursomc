package br.com.cursomc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cursomc.domain.Produto;
import br.com.cursomc.repositories.ProdutoRepository;
@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	
	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	

	public Produto buscar(Long id) {
		Produto produto = produtoRepository.findOneById(id);
		return produto;
	}


	public List<Produto> buscarTodos() {
		return produtoRepository.findAll();
	}

}
