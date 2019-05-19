package br.com.vendas.domain;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//private Integer cod_usuario;
	private String nome;
	private String cpf;
	private Character sexo;
	private Date data_cadastro;
	
	
	public Usuario() {}
	

	public Usuario(String nome, String cpf, Character sexo, Date data_cadastro) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.sexo = sexo;
		this.data_cadastro = data_cadastro;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public Character getSexo() {
		return sexo;
	}


	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}


	public Date getData_cadastro() {
		return data_cadastro;
	}


	public void setData_cadastro(Date data_cadastro) {
		this.data_cadastro = data_cadastro;
	}

		

}
