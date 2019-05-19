package br.com.vendas.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ItemVendaPK implements Serializable{

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "notaVenda_id")
	private NotaDeVenda notaDeVenda;
	
	@ManyToOne
	@JoinColumn(name = "Produto_id")
	private Produto produto;
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public NotaDeVenda getNotaDeVenda() {
		return notaDeVenda;
	}
	public void setNotaDeVenda(NotaDeVenda notaDeVenda) {
		this.notaDeVenda = notaDeVenda;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((notaDeVenda == null) ? 0 : notaDeVenda.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
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
		ItemVendaPK other = (ItemVendaPK) obj;
		if (notaDeVenda == null) {
			if (other.notaDeVenda != null)
				return false;
		} else if (!notaDeVenda.equals(other.notaDeVenda))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		return true;
	}
	
	

}
