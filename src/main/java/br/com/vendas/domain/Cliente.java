package br.com.vendas.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.vendas.domain.enums.TipoCliente;

@Entity
public class Cliente extends Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod_cliente;
	private Integer tipo;
	
	
	@OneToMany(mappedBy = "cliente")
	private List<Endereco> enderecos = new ArrayList<Endereco>();
	
	@ElementCollection
	@CollectionTable(name = "TELEFONE")
	private Set<String> telefones = new HashSet<String>();
	
	//Relacionamento um para muitos um cliente tem várias notas
	
	@JsonIgnore
	@OneToMany(mappedBy = "cliente")
	private List<NotaDeVenda> notaDeVenda = new ArrayList<NotaDeVenda>();
	
	//Construtor padrão
	public Cliente() {
		super();
	}
	
	//Construtor da super classe
	public Cliente(String nome, String cpf, Character sexo, Date data_cadastro, Integer cod_cliente,
			TipoCliente tipo) {
		super(nome, cpf, sexo, data_cadastro);
		this.cod_cliente = cod_cliente;
		this.tipo = tipo.getCod();
	}

	//Construtor cliente
	public Cliente(Integer cod_cliente) {
		
		this.cod_cliente = cod_cliente;
		
	
	}



	public Integer getCod_cliente() {
		return cod_cliente;
	}

	public void setCod_cliente(Integer cod_cliente) {
		this.cod_cliente = cod_cliente;
	}


	public List<NotaDeVenda> getNotaDeVenda() {
		return notaDeVenda;
	}



	public void setNotaDeVenda(List<NotaDeVenda> notaDeVenda) {
		this.notaDeVenda = notaDeVenda;
	}

	//Pegando o código com o metódo toEnum que é statico
	public TipoCliente getTipo() {
		return TipoCliente.toEnum(tipo);
	}

	public void setTipo(TipoCliente tipo) {
		this.tipo = tipo.getCod();
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
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
