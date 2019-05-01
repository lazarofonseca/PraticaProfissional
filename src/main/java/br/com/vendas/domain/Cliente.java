package br.com.vendas.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cliente extends Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod_cliente;
	private String cpf;
	
	//Relacionamento um para muitos um cliente tem várias notas
	@OneToMany(mappedBy = "cliente", targetEntity = NotaDeVenda.class, 
			fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<NotaDeVenda> notaDeVenda = new ArrayList<NotaDeVenda>();
	
	public Cliente() {
		super();
	}
	
	

	public Cliente(Integer cod_cliente, String cpf) {
		
		this.cod_cliente = cod_cliente;
		this.cpf = cpf;
	
	}



	public Integer getCod_cliente() {
		return cod_cliente;
	}

	public void setCod_cliente(Integer cod_cliente) {
		this.cod_cliente = cod_cliente;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	

	public List<NotaDeVenda> getNotaDeVenda() {
		return notaDeVenda;
	}



	public void setNotaDeVenda(List<NotaDeVenda> notaDeVenda) {
		this.notaDeVenda = notaDeVenda;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cod_cliente == null) ? 0 : cod_cliente.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (cod_cliente == null) {
			if (other.cod_cliente != null)
				return false;
		} else if (!cod_cliente.equals(other.cod_cliente))
			return false;
		return true;
	}
	
	

}
