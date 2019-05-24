package br.com.vendas.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;


import br.com.vendas.domain.Categoria;

public class CategoriaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id_categoria;
	
	@NotEmpty(message = "Campo nome obrigatório!")
	@Length(min = 5, max = 80, message = "O campo deve ter entre 5 e 80 caracteres")
	private String nome;
	
	
	public CategoriaDTO() {
		
	}
	
	public CategoriaDTO(Categoria obj) {
		id_categoria = obj.getId_categoria();
		nome = obj.getNome();
	}


	public Integer getId_categoria() {
		return id_categoria;
	}


	public void setId_categoria(Integer id_categoria) {
		this.id_categoria = id_categoria;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}
	

}
