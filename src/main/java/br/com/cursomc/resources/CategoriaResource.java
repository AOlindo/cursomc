package br.com.cursomc.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.cursomc.domain.Categoria;
import br.com.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping("/{id}")
	public ResponseEntity<Categoria> find(@PathVariable Long id) {
		Categoria obj = categoriaService.buscar(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<?> inserir(@RequestBody Categoria categoria) {
		categoria = categoriaService.inserir(categoria);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(categoria.getId())
				.toUri();// Gera a URL da categoria cadastrada.

		return ResponseEntity.created(uri).build();

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizarCategoria(@RequestBody Categoria categoria, @PathVariable Long id){
		categoria.setId(id);
		categoria = categoriaService.atualiza(categoria);
		return ResponseEntity.noContent().build();
	}

}
