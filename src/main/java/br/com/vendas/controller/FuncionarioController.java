package br.com.vendas.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.vendas.domain.Funcionario;
import br.com.vendas.services.FuncionarioService;


@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Funcionario obj = service.busca(id);
		
		return ResponseEntity.ok().body(obj);

	}

}
