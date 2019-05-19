package br.com.vendas.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

//CLASSE QUE REPRESENTA O PEDIDO DOS CLIENTES
@Entity
public class NotaDeVenda implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod_nota;
	private Date instante;
	
	//Mapeamento um para um
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "notaVenda")
	private Pagamento pagamento;
	
	@ManyToOne
	@JoinColumn(name = "clienete_id")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "endereco_entrega_id")
	private Endereco enderecoDeEntrega;
	
	
	public NotaDeVenda() {
		
	}


	public NotaDeVenda(Integer cod_nota, Date instante, Cliente cliente,
			Endereco enderecoDeEntrega) {
		super();
		this.cod_nota = cod_nota;
		this.instante = instante;
		this.cliente = cliente;
		this.enderecoDeEntrega = enderecoDeEntrega;
	}


	public Integer getCod_nota() {
		return cod_nota;
	}


	public void setCod_nota(Integer cod_nota) {
		this.cod_nota = cod_nota;
	}


	public Date getInstante() {
		return instante;
	}


	public void setInstante(Date instante) {
		this.instante = instante;
	}


	public Pagamento getPagamento() {
		return pagamento;
	}


	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Endereco getEnderecoDeEntrega() {
		return enderecoDeEntrega;
	}


	public void setEnderecoDeEntrega(Endereco enderecoDeEntrega) {
		this.enderecoDeEntrega = enderecoDeEntrega;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cod_nota == null) ? 0 : cod_nota.hashCode());
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
		NotaDeVenda other = (NotaDeVenda) obj;
		if (cod_nota == null) {
			if (other.cod_nota != null)
				return false;
		} else if (!cod_nota.equals(other.cod_nota))
			return false;
		return true;
	}
	
	

}
