package br.com.vendas.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class ItemDeVenda implements Serializable{
	private static final long serialVersionUID = 1L;

	
	private Integer cod_item_venda;
	private Integer cod_venda;
	private BigDecimal valor_item;
	private Integer quantidade;
	
	
	public ItemDeVenda() {
		
	}


	public ItemDeVenda(Integer cod_item_venda, Integer cod_venda, BigDecimal valor_item, Integer quantidade) {
		super();
		this.cod_item_venda = cod_item_venda;
		this.cod_venda = cod_venda;
		this.valor_item = valor_item;
		this.quantidade = quantidade;
	}


	public Integer getCod_item_venda() {
		return cod_item_venda;
	}


	public void setCod_item_venda(Integer cod_item_venda) {
		this.cod_item_venda = cod_item_venda;
	}


	public Integer getCod_venda() {
		return cod_venda;
	}


	public void setCod_venda(Integer cod_venda) {
		this.cod_venda = cod_venda;
	}


	public BigDecimal getValor_item() {
		return valor_item;
	}


	public void setValor_item(BigDecimal valor_item) {
		this.valor_item = valor_item;
	}


	public Integer getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cod_item_venda == null) ? 0 : cod_item_venda.hashCode());
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
		ItemDeVenda other = (ItemDeVenda) obj;
		if (cod_item_venda == null) {
			if (other.cod_item_venda != null)
				return false;
		} else if (!cod_item_venda.equals(other.cod_item_venda))
			return false;
		return true;
	}
	
	

}
