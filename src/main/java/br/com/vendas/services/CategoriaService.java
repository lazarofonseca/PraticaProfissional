package br.com.vendas.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vendas.domain.Categoria;
import br.com.vendas.repositories.CategoriaRepository;
import javassist.tools.rmi.ObjectNotFoundException;


@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo; 

	public Categoria busca(Integer id) throws ObjectNotFoundException {
		
		Optional<Categoria> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrada! Id: " + id + ", Tipo: " 
		 + Categoria.class.getName()));

		
	}
	
}
