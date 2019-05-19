package br.com.vendas;


import java.text.SimpleDateFormat;
//import java.util.ArrayList;
import java.util.Arrays;
//import java.util.Date;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.vendas.domain.Categoria;
import br.com.vendas.domain.Cidade;
import br.com.vendas.domain.Cliente;
import br.com.vendas.domain.Endereco;
import br.com.vendas.domain.Estado;
import br.com.vendas.domain.ItemVenda;
import br.com.vendas.domain.NotaDeVenda;
import br.com.vendas.domain.Pagamento;
import br.com.vendas.domain.PagamentoComBoleto;
import br.com.vendas.domain.PagamentoComCartao;
//import br.com.vendas.domain.Funcionario;
import br.com.vendas.domain.Produto;
import br.com.vendas.domain.enums.EstadoPagamento;
import br.com.vendas.domain.enums.TipoCliente;
import br.com.vendas.repositories.CategoriaRepository;
import br.com.vendas.repositories.CidadeRepository;
import br.com.vendas.repositories.ClienteRepository;
import br.com.vendas.repositories.EnderecoRepository;
import br.com.vendas.repositories.EstadoRepository;
import br.com.vendas.repositories.ItemVendaRepository;
import br.com.vendas.repositories.NotaDeVendaRepository;
import br.com.vendas.repositories.PagamentoRepository;
//import br.com.vendas.repositories.FuncionarioRepository;
import br.com.vendas.repositories.ProdutoRepository;

@SpringBootApplication
public class VendasApplication implements CommandLineRunner{

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private NotaDeVendaRepository notaDeVendaRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemVendaRepository itemVendaRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
			
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null	, "Escritório");
		
		Produto prod1 = new Produto(null, "Computador", "Laptop", 2500.0);
		Produto prod2 = new Produto(null, "Impressora", "Laser", 1200.0);
		Produto prod3 = new Produto(null, "Mouse", "USB", 40.0);
		
		cat1.getProdutos().addAll(Arrays.asList(prod1, prod2, prod3));
		cat2.getProdutos().addAll(Arrays.asList(prod2));
		
		prod1.getCategorias().addAll(Arrays.asList(cat1));
		prod2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		prod3.getCategorias().addAll(Arrays.asList(cat1));
	
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3));
		
		
		Estado est1 = new Estado(null, "Paraíba");
		Estado est2 = new Estado(null, "Rio Grande do Norte");
		
		Cidade cid1 = new Cidade(null, "Pedra Lavrada", est1);
		Cidade cid2 = new Cidade(null, "Nova Palmeira", est1);
		Cidade cid3 = new Cidade(null, "Parelhas", est2);
		
		est1.getCidades().addAll(Arrays.asList(cid1, cid2));
		est2.getCidades().addAll(Arrays.asList(cid3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));
		
		Cliente cliente01 = new Cliente("Lázaro Nóbrega", "000.111.222-12", 'M', new Date(), null, TipoCliente.PESSOAFISICA);
		
		cliente01.getTelefones().addAll(Arrays.asList("(83)3375-4145", "(83)98656-2311"));
		
		Endereco e1 = new Endereco(null, "José Lins do Regô", 213, "Próximo Assembléias", "Centro", "58180-000", cliente01, cid1);
		Endereco e2 = new Endereco(null, "Sítio Patos", 0, "Próximo ao cruzeiro", "Zona Rural", "58180-000", cliente01, cid2);
	
		cliente01.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll(Arrays.asList(cliente01));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		NotaDeVenda venda1 = new NotaDeVenda(null, sdf.parse("17/05/2019 15:36"), cliente01, e1);
		NotaDeVenda venda2 = new NotaDeVenda(null, sdf.parse("15/05/2019 08:36"), cliente01, e2);
		
		Pagamento pg1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, venda1, 6);
		venda1.setPagamento(pg1);
		
		Pagamento pg2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, venda2, sdf.parse("21/05/2019 00:00"), null );
		venda2.setPagamento(pg2);
		
		cliente01.getNotaDeVenda().addAll(Arrays.asList(venda1, venda2));
		
		notaDeVendaRepository.saveAll(Arrays.asList(venda1, venda2));
		pagamentoRepository.saveAll(Arrays.asList(pg1, pg2));
		
		ItemVenda iv1 = new ItemVenda(venda1, prod1, 0.0, 1, 2000.0);
		ItemVenda iv2 = new ItemVenda(venda1, prod3, 0.0, 2, 80.0);
		ItemVenda iv3 = new ItemVenda(venda2, prod2, 100.0, 1, 800.0);
		
		venda1.getItens().addAll(Arrays.asList(iv1, iv2));
		venda2.getItens().addAll(Arrays.asList(iv3));
		
		prod1.getItens().addAll(Arrays.asList(iv1));
		prod2.getItens().addAll(Arrays.asList(iv3));
		prod3.getItens().addAll(Arrays.asList(iv2));
		
		itemVendaRepository.saveAll(Arrays.asList(iv1, iv2, iv3));
		
	}

}
