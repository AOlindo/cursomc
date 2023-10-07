package br.com.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cursomc.domain.Pedido;
import br.com.cursomc.repositories.PedidoRepository;
import br.com.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	public PedidoService(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}

	public Pedido buscar(Long id) {
		Pedido obj = pedidoRepository.findOneById(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Id " + id + " não encontrado");
		}
		return obj;
	}

}
