package br.com.vendas.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vendas.domain.Funcionario;
import br.com.vendas.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository repo; 

	public Funcionario busca(Integer id) {
		
		Optional<Funcionario> obj = repo.findById(id);
		return obj.orElse(null);

		
	}
}
