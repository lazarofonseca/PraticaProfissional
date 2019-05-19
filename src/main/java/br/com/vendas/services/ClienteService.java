package br.com.vendas.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vendas.domain.Cliente;
import br.com.vendas.repositories.ClienteRepository;
import javassist.tools.rmi.ObjectNotFoundException;


@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo; 

	public Cliente busca(Integer id) throws ObjectNotFoundException {
		
		Optional<Cliente> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrada! Id: " + id + ", Tipo: " 
		 + Cliente.class.getName()));

		
	}
	
}
