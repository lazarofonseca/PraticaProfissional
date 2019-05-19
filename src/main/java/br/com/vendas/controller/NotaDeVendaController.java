package br.com.vendas.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.vendas.domain.NotaDeVenda;
import br.com.vendas.services.NotaDeVendaService;
import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/vendas")
public class NotaDeVendaController {
	
	@Autowired
	private NotaDeVendaService notaDeVendaService; 
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) throws ObjectNotFoundException{
		
		NotaDeVenda obj = notaDeVendaService.busca(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	

}
