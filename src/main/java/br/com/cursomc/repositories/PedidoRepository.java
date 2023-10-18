package br.com.cursomc.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cursomc.domain.Cliente;
import br.com.cursomc.domain.Pedido;


public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	Pedido findOneById(Long id);
	
	Page<Pedido> findByCliente(Cliente cliente, Pageable pageRequest);
	
}