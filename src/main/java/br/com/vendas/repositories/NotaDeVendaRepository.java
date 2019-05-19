package br.com.vendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vendas.domain.NotaDeVenda;;


@Repository
public interface NotaDeVendaRepository extends JpaRepository<NotaDeVenda, Integer> {

}
