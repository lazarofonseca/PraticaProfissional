package br.com.vendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vendas.domain.ItemVenda;


@Repository
public interface ItemVendaRepository extends JpaRepository<ItemVenda, Integer> {

}
