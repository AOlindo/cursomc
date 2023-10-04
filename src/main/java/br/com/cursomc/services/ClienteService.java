package br.com.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cursomc.domain.Categoria;
import br.com.cursomc.domain.Cliente;
import br.com.cursomc.repositories.CategoriaRepository;
import br.com.cursomc.repositories.ClienteRepository;
import br.com.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	public Cliente buscar(Long id) {
		Cliente obj = clienteRepository.findOneById(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Id " + id + " não encontrado");
		}
		return obj;
	}

}
