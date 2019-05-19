package br.com.vendas.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Produto implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod_produto;
	private String nome;
	private String descricao;
	private Double valor_venda;
	
	
	//A volta da referência no tratamento para exibir o Json
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "PRODUTO_CATEGORIA",
	joinColumns = @JoinColumn(name = "produto_id"),
	inverseJoinColumns = @JoinColumn(name = "categoria_id"))
	private List<Categoria> categorias = new ArrayList<Categoria>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "cod_IdItem.produto")
	private Set<ItemVenda> itens = new HashSet<ItemVenda>();
	
	
	
	public Produto() {
		
	}

	public Produto(Integer cod_produto, String nome, String descricao,Double valor_venda) {
		super();
		this.cod_produto = cod_produto;
		this.nome = nome;
		this.descricao = descricao;
		this.valor_venda = valor_venda;
		
	}
	
	@JsonIgnore
	public List<NotaDeVenda> GetnotaDeVendas(){
		List<NotaDeVenda> lista = new ArrayList<NotaDeVenda>();
		for(ItemVenda x : itens) {
			lista.add(x.getNotaDeVenda());
		}
		return lista;
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

	public Double getValor_venda() {
		return valor_venda;
	}

	public void setValor_venda(Double valor_venda) {
		this.valor_venda = valor_venda;
	}
	
	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	public Set<ItemVenda> getItens() {
		return itens;
	}

	public void setItens(Set<ItemVenda> itens) {
		this.itens = itens;
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
