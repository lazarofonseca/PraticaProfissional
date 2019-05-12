package br.com.vendas.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vendas.domain.Categoria;
import br.com.vendas.repositories.CategoriaRepository;


@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo; 

	public Categoria busca(Integer id) {
		
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null);

		
	}
	
}
