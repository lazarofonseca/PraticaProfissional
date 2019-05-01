package br.com.vendas.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.util.Date;


@Entity
public class NotaDeVenda implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer cod_venda;
	private BigDecimal valor;
	@ManyToOne
	@JoinColumn(name = "cod_funcionario")
	private Funcionario funcionario;
	@ManyToOne
	@JoinColumn(name = "cod_cliente")
	private Cliente cliente;
	private Date data_venda;
	private Time hora_venda;
	
	
	
	public NotaDeVenda() {
		
	}

	public NotaDeVenda(Integer cod_venda, BigDecimal valor, Funcionario funcionario, Cliente cliente, Date data_venda,
			Time hora_venda) {
		super();
		this.cod_venda = cod_venda;
		this.valor = valor;
		this.funcionario = funcionario;
		this.cliente = cliente;
		this.data_venda = data_venda;
		this.hora_venda = hora_venda;
	}




	public Integer getCod_venda() {
		return cod_venda;
	}

	public void setCod_venda(Integer cod_venda) {
		this.cod_venda = cod_venda;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Date getData_venda() {
		return data_venda;
	}

	public void setData_venda(Date data_venda) {
		this.data_venda = data_venda;
	}

	public Time getHora_venda() {
		return hora_venda;
	}

	public void setHora_venda(Time hora_venda) {
		this.hora_venda = hora_venda;
	}
	
	

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cod_venda == null) ? 0 : cod_venda.hashCode());
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
		if (cod_venda == null) {
			if (other.cod_venda != null)
				return false;
		} else if (!cod_venda.equals(other.cod_venda))
			return false;
		return true;
	}
	
	
	
	

}
