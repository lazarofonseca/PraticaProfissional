package br.com.vendas.dto;

import java.io.Serializable;

import br.com.vendas.domain.Produto;

public class ProdutoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	private String nome;
	private Double valor_venda;
	public ProdutoDTO(Integer id, String nome, Double valor_venda) {
		super();
		this.id = id;
		this.nome = nome;
		this.valor_venda = valor_venda;
	}
	
	public ProdutoDTO() {
		
	}
	
	public ProdutoDTO(Produto obj) {
		id = obj.getId();
		nome = obj.getNome();
		valor_venda = obj.getValor_venda();
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor_venda() {
		return valor_venda;
	}

	public void setValor_venda(Double valor_venda) {
		this.valor_venda = valor_venda;
	}
	
	
	

}
