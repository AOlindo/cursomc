package br.com.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cursomc.domain.Pedido;


public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}