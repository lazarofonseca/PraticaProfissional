package br.com.vendas.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.vendas.domain.Usuario;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Usuario> listar() {
		
		Usuario user1 = new Usuario(1, "Lázaro", "123", 1, 2, 5, "José Lins", 213, "Centro", 
				"Pedra Lavrada", "PB", "000.111.222-34", 'M', "lazaronobrega3@gmail.com",
				"(83)98877-2233", "(83)99878-3355", new Date());
		Usuario user2 = new Usuario(2, "Lázaro", "123", 1, 2, 5, "José Lins", 213, "Centro", 
				"Pedra Lavrada", "PB", "000.111.222-34", 'M', "lazaronobrega3@gmail.com",
				"(83)98877-2233", "(83)99878-3355", new Date());
		
		
		List<Usuario> lista = new ArrayList<Usuario>();
		lista.add(user1);
		lista.add(user2);
		return lista;
	}

}
