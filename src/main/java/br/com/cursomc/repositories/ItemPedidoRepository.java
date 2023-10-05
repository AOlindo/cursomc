package br.com.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cursomc.domain.ItemPedido;


public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {

}