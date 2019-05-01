package br.com.vendas.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod_produto;
	private String nome;
	private String descricao;
	private BigDecimal valor_compra;
	private BigDecimal valor_venda;
	private Integer quantidade;
	
	public Produto() {
		
	}

	public Produto(Integer cod_produto, String nome, String descricao, BigDecimal valor_compra, BigDecimal valor_venda,
			Integer quantidade) {
		super();
		this.cod_produto = cod_produto;
		this.nome = nome;
		this.descricao = descricao;
		this.valor_compra = valor_compra;
		this.valor_venda = valor_venda;
		this.quantidade = quantidade;
	}

	public Integer getCod_produto() {
		return cod_produto;
	}

	public void setCod_produto(Integer cod_produto) {
		this.cod_produto = cod_produto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor_compra() {
		return valor_compra;
	}

	public void setValor_compra(BigDecimal valor_compra) {
		this.valor_compra = valor_compra;
	}

	public BigDecimal getValor_venda() {
		return valor_venda;
	}

	public void setValor_venda(BigDecimal valor_venda) {
		this.valor_venda = valor_venda;
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
		result = prime * result + ((cod_produto == null) ? 0 : cod_produto.hashCode());
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
		Produto other = (Produto) obj;
		if (cod_produto == null) {
			if (other.cod_produto != null)
				return false;
		} else if (!cod_produto.equals(other.cod_produto))
			return false;
		return true;
	}
	
	
}
