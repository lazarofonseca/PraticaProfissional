package br.com.vendas.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.vendas.domain.enums.EstadoPagamento;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pagamento implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer cod_pagamento;
	private Integer estado;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "cod_nota")
	@MapsId
	private NotaDeVenda notaVenda;

	
	
	public Pagamento() {
		
	}

	public Pagamento(Integer cod_pagamento, EstadoPagamento estado,
		NotaDeVenda notaVenda) {
		super();
		this.cod_pagamento = cod_pagamento;
		this.estado = (estado ==null) ? null : estado.getCod();
		this.notaVenda = notaVenda;
		
	}

	public Integer getCod_pagamento() {
		return cod_pagamento;
	}

	public void setCod_pagamento(Integer cod_pagamento) {
		this.cod_pagamento = cod_pagamento;
	}

	public EstadoPagamento getEstado() {
		return EstadoPagamento.toEnum(estado);
	}

	public void setEstado(EstadoPagamento estado) {
		this.estado = estado.getCod();
	}

	public NotaDeVenda getNotaVenda() {
		return notaVenda;
	}

	public void setNotaVenda(NotaDeVenda notaVenda) {
		this.notaVenda = notaVenda;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cod_pagamento == null) ? 0 : cod_pagamento.hashCode());
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
		Pagamento other = (Pagamento) obj;
		if (cod_pagamento == null) {
			if (other.cod_pagamento != null)
				return false;
		} else if (!cod_pagamento.equals(other.cod_pagamento))
			return false;
		return true;
	}
	
	
	
	

}
