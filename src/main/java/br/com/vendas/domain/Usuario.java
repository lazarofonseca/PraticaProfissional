package br.com.vendas.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod_usuario;
	private String nome;
	private String senha;
	private Integer tipo_permissao;
	private Integer func_cod_funcionario;
	private Integer cli_cod_cliente;
	private String endereco;
	private Integer numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String cpf;
	private Character sexo;
	private String email;
	private String telefone;
	private String celular;
	private Date data_cadastro;
	
	
	public Usuario() {}
	
	
	public Usuario(Integer cod_usuario, String nome, String senha, Integer tipo_permissao, Integer func_cod_funcionario,
			Integer cli_cod_cliente, String endereco, Integer numero, String bairro, String cidade, String estado,
			String cpf, Character sexo, String email, String telefone, String celular, Date data_cadastro) {
		
		this.cod_usuario = cod_usuario;
		this.nome = nome;
		this.senha = senha;
		this.tipo_permissao = tipo_permissao;
		this.func_cod_funcionario = func_cod_funcionario;
		this.cli_cod_cliente = cli_cod_cliente;
		this.endereco = endereco;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cpf = cpf;
		this.sexo = sexo;
		this.email = email;
		this.telefone = telefone;
		this.celular = celular;
		this.data_cadastro = data_cadastro;
	}


	public Integer getCod_usuario() {
		return cod_usuario;
	}


	public void setCod_usuario(Integer cod_usuario) {
		this.cod_usuario = cod_usuario;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public Integer getTipo_permissao() {
		return tipo_permissao;
	}


	public void setTipo_permissao(Integer tipo_permissao) {
		this.tipo_permissao = tipo_permissao;
	}


	public Integer getFunc_cod_funcionario() {
		return func_cod_funcionario;
	}


	public void setFunc_cod_funcionario(Integer func_cod_funcionario) {
		this.func_cod_funcionario = func_cod_funcionario;
	}


	public Integer getCli_cod_cliente() {
		return cli_cod_cliente;
	}


	public void setCli_cod_cliente(Integer cli_cod_cliente) {
		this.cli_cod_cliente = cli_cod_cliente;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public Integer getNumero() {
		return numero;
	}


	public void setNumero(Integer numero) {
		this.numero = numero;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getCelular() {
		return celular;
	}


	public void setCelular(String celular) {
		this.celular = celular;
	}


	public Date getData_cadastro() {
		return data_cadastro;
	}


	public void setData_cadastro(Date data_cadastro) {
		this.data_cadastro = data_cadastro;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cod_usuario == null) ? 0 : cod_usuario.hashCode());
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
		Usuario other = (Usuario) obj;
		if (cod_usuario == null) {
			if (other.cod_usuario != null)
				return false;
		} else if (!cod_usuario.equals(other.cod_usuario))
			return false;
		return true;
	}
	
	
	

}
