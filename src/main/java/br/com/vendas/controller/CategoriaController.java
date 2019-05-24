package br.com.vendas.controller;



import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.vendas.domain.Categoria;
import br.com.vendas.dto.CategoriaDTO;
import br.com.vendas.services.CategoriaService;
import br.com.vendas.services.exception.DataIntegrityException;
import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService; 
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Categoria> find(@PathVariable Integer id) throws ObjectNotFoundException{
		
		Categoria obj = categoriaService.find(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody CategoriaDTO objDto){
		Categoria obj = categoriaService.fromDTO(objDto);
		obj = categoriaService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId_categoria()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody CategoriaDTO objDto, @PathVariable Integer id) throws ObjectNotFoundException{
		Categoria obj = categoriaService.fromDTO(objDto);
		obj.setId_categoria(id);
		obj = categoriaService.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) throws ObjectNotFoundException{
		
		try {
		categoriaService.delete(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir a categoria com produtos relacionados");
		}
		return ResponseEntity.noContent().build();
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CategoriaDTO>> findAll(){
		
		List<Categoria> list = categoriaService.findAll();
		//Converte a lista de Categorias para categoriaDTO
		List<CategoriaDTO> listDto = list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<CategoriaDTO>> findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24")Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "nome")String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC")String direction){
		
		Page<Categoria> list = categoriaService.findPage(page, linesPerPage, orderBy, direction);
		//Converte a lista de Categorias para categoriaDTO
		Page<CategoriaDTO> listDto = list.map(obj -> new CategoriaDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}
	

}
