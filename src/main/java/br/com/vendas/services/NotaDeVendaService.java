package br.com.vendas.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vendas.domain.NotaDeVenda;
import br.com.vendas.repositories.NotaDeVendaRepository;
import javassist.tools.rmi.ObjectNotFoundException;


@Service
public class NotaDeVendaService {

	@Autowired
	private NotaDeVendaRepository repo; 

	public NotaDeVenda busca(Integer id) throws ObjectNotFoundException {
		
		Optional<NotaDeVenda> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrada! Id: " + id + ", Tipo: " 
		 + NotaDeVenda.class.getName()));

		
	}
	
}
