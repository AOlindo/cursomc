package br.com.cursomc.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import br.com.cursomc.domain.Categoria;
import javax.validation.constraints.NotEmpty;

public class CategoriaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 5, max  = 80, message = "O tamanho deve ser entre 5 e 80 caracteres")
	private String nome;

	public CategoriaDTO() {

	}

	public CategoriaDTO (Categoria categoria) {
		this.id = categoria.getId();
		this.nome = categoria.getNome();
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
