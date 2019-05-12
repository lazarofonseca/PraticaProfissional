package br.com.vendas.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Funcionario extends Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod_funciconario;
	private Double salario;
	
	//Relacionamento um para muitos um cliente tem várias notas
		@OneToMany(mappedBy = "cliente", targetEntity = NotaDeVenda.class, 
				fetch = FetchType.LAZY, cascade = CascadeType.ALL)
		private List<NotaDeVenda> notaDeVenda = new ArrayList<NotaDeVenda>();
	
	public Funcionario() {
		super();
	}
	
	


	public Funcionario(Integer cod_funciconario, Double salario) {
		super();
		this.cod_funciconario = cod_funciconario;
		this.salario = salario;
	}

	public Funcionario(String nome, String cpf, Character sexo, Date data_cadastro, Integer cod_funciconario,
			Double salario, List<NotaDeVenda> notaDeVenda) {
		super(nome, cpf, sexo, data_cadastro);
		this.cod_funciconario = cod_funciconario;
		this.salario = salario;
		this.notaDeVenda = notaDeVenda;
	}




	public Integer getCod_funciconario() {
		return cod_funciconario;
	}


	public void setCod_funciconario(Integer cod_funciconario) {
		this.cod_funciconario = cod_funciconario;
	}


	public Double getSalario() {
		return salario;
	}


	public void setSalario(Double salario) {
		this.salario = salario;
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
		result = prime * result + ((cod_funciconario == null) ? 0 : cod_funciconario.hashCode());
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
		Funcionario other = (Funcionario) obj;
		if (cod_funciconario == null) {
			if (other.cod_funciconario != null)
				return false;
		} else if (!cod_funciconario.equals(other.cod_funciconario))
			return false;
		return true;
	}
	
	

}
