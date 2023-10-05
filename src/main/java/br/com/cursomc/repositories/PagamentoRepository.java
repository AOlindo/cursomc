package br.com.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cursomc.domain.Pagamento;


public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

}