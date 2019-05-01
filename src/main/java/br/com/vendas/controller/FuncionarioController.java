package br.com.vendas.controller;


import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.vendas.domain.Funcionario;


@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionarioController {
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Funcionario> listar() {
		
		return null;

	}

}
