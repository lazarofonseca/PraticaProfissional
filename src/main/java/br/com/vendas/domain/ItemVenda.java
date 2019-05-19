package br.com.vendas.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ItemVenda implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	//Anotação feita para um tipo auxiliar
	@JsonIgnore
	@EmbeddedId
	private ItemVendaPK cod_IdItem = new ItemVendaPK();
	
	private Double desconto;
	private Integer quantidade;
	private Double preco;
	
	public ItemVenda() {
		
	}

	public ItemVenda(NotaDeVenda notaDeVenda, Produto produto, Double desconto, Integer quantidade, Double preco) {
		super();
		cod_IdItem.setNotaDeVenda(notaDeVenda);
		cod_IdItem.setProduto(produto);
		this.desconto = desconto;
		this.quantidade = quantidade;
		this.preco = preco;
	}

	@JsonIgnore
	public NotaDeVenda getNotaDeVenda() {
		return cod_IdItem.getNotaDeVenda();
	}
	
	
	public Produto getProduto() {
		return cod_IdItem.getProduto();
	}
	
	
	public ItemVendaPK getCod_IdItem() {
		return cod_IdItem;
	}

	public void setCod_IdItem(ItemVendaPK cod_IdItem) {
		this.cod_IdItem = cod_IdItem;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cod_IdItem == null) ? 0 : cod_IdItem.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemVenda other = (ItemVenda) obj;
		if (cod_IdItem == null) {
			if (other.cod_IdItem != null)
				return false;
		} else if (!cod_IdItem.equals(other.cod_IdItem))
			return false;
		return true;
	}
	
	
}
