package br.com.vendas;

//import java.util.ArrayList;
import java.util.Arrays;
//import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.vendas.domain.Categoria;
//import br.com.vendas.domain.Funcionario;
import br.com.vendas.domain.Produto;
import br.com.vendas.repositories.CategoriaRepository;
//import br.com.vendas.repositories.FuncionarioRepository;
import br.com.vendas.repositories.ProdutoRepository;

@SpringBootApplication
public class VendasApplication implements CommandLineRunner{

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		/*
		Funcionario funcionario01 = new Funcionario();	
		funcionario01.setNome("LÁZARO NÓBREGA");
		funcionario01.setCpf("000.111.222-33");
		funcionario01.setSalario(1000.0);
		funcionario01.setSexo('M');
		funcionario01.setData_cadastro(new Date());
		
		Funcionario funcionario02 = new Funcionario();	
		funcionario02.setNome("MARIA JOSÉ");
		funcionario02.setCpf("111.333.444-56");
		funcionario02.setSalario(2000.0);
		funcionario02.setSexo('F');
		funcionario02.setData_cadastro(new Date());
		*/
	
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto prod1 = new Produto(null, "Computador", "Laptop", 2500.0, 3000.0, 3);
		Produto prod2 = new Produto(null, "Impressora", "Laser", 1200.0, 1800.0, 2);
		Produto prod3 = new Produto(null, "Mouse", "USB", 40.0, 60.0, 10);
		
		cat1.getProdutos().addAll(Arrays.asList(prod1, prod2, prod3));
		cat2.getProdutos().addAll(Arrays.asList(prod2));
		
		prod1.getCategorias().addAll(Arrays.asList(cat1));
		prod2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		prod3.getCategorias().addAll(Arrays.asList(cat1));
		/*
		funcionarioRepository.saveAll(Arrays.asList(funcionario01,
				funcionario02));
		*/
		
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3));
		
	}

}
