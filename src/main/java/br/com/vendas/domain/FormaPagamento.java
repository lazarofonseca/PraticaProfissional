package br.com.vendas.domain;

import java.util.Date;

public class FormaPagamento {
	
	private Integer cod_pagamento;
	private Integer cod_venda;
	private String numero_cartao;
	private Date dataPagamento;
	
	public FormaPagamento() {
		
	}

	public FormaPagamento(Integer cod_pagamento, Integer cod_venda, String numero_cartao, Date dataPagamento) {
		super();
		this.cod_pagamento = cod_pagamento;
		this.cod_venda = cod_venda;
		this.numero_cartao = numero_cartao;
		this.dataPagamento = dataPagamento;
	}

	public Integer getCod_pagamento() {
		return cod_pagamento;
	}

	public void setCod_pagamento(Integer cod_pagamento) {
		this.cod_pagamento = cod_pagamento;
	}

	public Integer getCod_venda() {
		return cod_venda;
	}

	public void setCod_venda(Integer cod_venda) {
		this.cod_venda = cod_venda;
	}

	public String getNumero_cartao() {
		return numero_cartao;
	}

	public void setNumero_cartao(String numero_cartao) {
		this.numero_cartao = numero_cartao;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
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
		FormaPagamento other = (FormaPagamento) obj;
		if (cod_pagamento == null) {
			if (other.cod_pagamento != null)
				return false;
		} else if (!cod_pagamento.equals(other.cod_pagamento))
			return false;
		return true;
	}
	
	

}
