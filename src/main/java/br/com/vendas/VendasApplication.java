package br.com.vendas;


import java.text.SimpleDateFormat;
//import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.vendas.domain.Categoria;
import br.com.vendas.domain.Cidade;
import br.com.vendas.domain.Cliente;
import br.com.vendas.domain.Endereco;
import br.com.vendas.domain.Estado;
import br.com.vendas.domain.ItemPedido;
import br.com.vendas.domain.Pagamento;
import br.com.vendas.domain.PagamentoComBoleto;
import br.com.vendas.domain.PagamentoComCartao;
import br.com.vendas.domain.Pedido;
//import br.com.vendas.domain.Funcionario;
import br.com.vendas.domain.Produto;
import br.com.vendas.domain.enums.EstadoPagamento;
import br.com.vendas.domain.enums.Perfil;
import br.com.vendas.domain.enums.TipoCliente;
import br.com.vendas.repositories.CategoriaRepository;
import br.com.vendas.repositories.CidadeRepository;
import br.com.vendas.repositories.ClienteRepository;
import br.com.vendas.repositories.EnderecoRepository;
import br.com.vendas.repositories.EstadoRepository;
import br.com.vendas.repositories.ItemPedidoRepository;
import br.com.vendas.repositories.PagamentoRepository;
import br.com.vendas.repositories.PedidoRepository;
//import br.com.vendas.repositories.FuncionarioRepository;
import br.com.vendas.repositories.ProdutoRepository;
import br.com.vendas.services.S3Service;

@SpringBootApplication
@EntityScan(basePackages = "br.com.vendas.domain")
public class VendasApplication implements CommandLineRunner{

	@Autowired
	S3Service s3Service;
	
	@Autowired
	private BCryptPasswordEncoder passEncod;
	
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
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//s3Service.uploadFile("/home/lazaro/Área de Trabalho/Analise e Desenvolvimento de Sistemas/V SEMESTRE/PRÁTICA PROFISSIONAL/Imagens/geek.jpg");
		//s3Service.uploadFile("/home/lazaro/Área de Trabalho/Analise e Desenvolvimento de Sistemas/V SEMESTRE/PRÁTICA PROFISSIONAL/Imagens/artesmarciais.jpg");
		//s3Service.uploadFile("/home/lazaro/Área de Trabalho/Analise e Desenvolvimento de Sistemas/V SEMESTRE/PRÁTICA PROFISSIONAL/Imagens/automoveis.jpg");
		//s3Service.uploadFile("/home/lazaro/Área de Trabalho/Analise e Desenvolvimento de Sistemas/V SEMESTRE/PRÁTICA PROFISSIONAL/Imagens/camamesaebanho.jpeg");
		//s3Service.uploadFile("/home/lazaro/Área de Trabalho/Analise e Desenvolvimento de Sistemas/V SEMESTRE/PRÁTICA PROFISSIONAL/Imagens/eletroeletronicos.jpg");
		//s3Service.uploadFile("/home/lazaro/Área de Trabalho/Analise e Desenvolvimento de Sistemas/V SEMESTRE/PRÁTICA PROFISSIONAL/Imagens/escritorio.jpg");
		//s3Service.uploadFile("/home/lazaro/Área de Trabalho/Analise e Desenvolvimento de Sistemas/V SEMESTRE/PRÁTICA PROFISSIONAL/Imagens/jardinagem.jpg");
		//s3Service.uploadFile("/home/lazaro/Área de Trabalho/Analise e Desenvolvimento de Sistemas/V SEMESTRE/PRÁTICA PROFISSIONAL/Imagens/livrosculinaria.jpg");
		//s3Service.uploadFile("/home/lazaro/Área de Trabalho/Analise e Desenvolvimento de Sistemas/V SEMESTRE/PRÁTICA PROFISSIONAL/Imagens/livrosficcao.jpg");
		//s3Service.uploadFile("/home/lazaro/Área de Trabalho/Analise e Desenvolvimento de Sistemas/V SEMESTRE/PRÁTICA PROFISSIONAL/Imagens/motocicletas.jpg");
		//s3Service.uploadFile("/home/lazaro/Área de Trabalho/Analise e Desenvolvimento de Sistemas/V SEMESTRE/PRÁTICA PROFISSIONAL/Imagens/moveisprojetados.jpg");
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null	, "Escritório");
		Categoria cat3 = new Categoria(null, "Cama mesa e Banho");
		Categoria cat4 = new Categoria(null	, "Jardinagem");
		Categoria cat5 = new Categoria(null, "Serralharia");
		Categoria cat6 = new Categoria(null	, "Livros Ficção");
		Categoria cat7 = new Categoria(null, "Livros Culinaria");
		Categoria cat8 = new Categoria(null	, "Artes Marciais");
		Categoria cat9 = new Categoria(null, "Automoveis");
		Categoria cat10 = new Categoria(null	, "Motocicletas");
		Categoria cat11 = new Categoria(null, "Móveis Projetados");
		Categoria cat12 = new Categoria(null	, "Eletroeletrônicos");
		
		Produto p1 = new Produto(null, "Computador", 2500.0);
		Produto p2 = new Produto(null, "Impressora", 1200.0);
		Produto p3 = new Produto(null, "Mouse", 40.0);
		Produto p4 = new Produto(null, "Mesa de escritório", 300.00);
		Produto p5 = new Produto(null, "Toalha", 50.00);
		Produto p6 = new Produto(null, "Colcha", 200.00);
		Produto p7 = new Produto(null, "TV true color", 1200.00);
		Produto p8 = new Produto(null, "Roçadeira", 800.00);
		Produto p9 = new Produto(null, "Abajour", 100.00);
		Produto p10 = new Produto(null, "Pendente", 180.00);
		Produto p11 = new Produto(null, "Shampoo", 90.00);
		
		
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2,p4));
		cat3.getProdutos().addAll(Arrays.asList(p5, p6));
		cat4.getProdutos().addAll(Arrays.asList(p1, p2, p3, p7));
		cat5.getProdutos().addAll(Arrays.asList(p8));
		cat6.getProdutos().addAll(Arrays.asList(p9, p10));
		cat7.getProdutos().addAll(Arrays.asList(p11));
		
		p1.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2, cat4));
		p3.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p4.getCategorias().addAll(Arrays.asList(cat2));
		p5.getCategorias().addAll(Arrays.asList(cat3));
		p6.getCategorias().addAll(Arrays.asList(cat3));
		p7.getCategorias().addAll(Arrays.asList(cat4));
		p8.getCategorias().addAll(Arrays.asList(cat5));
		p9.getCategorias().addAll(Arrays.asList(cat6));
		p10.getCategorias().addAll(Arrays.asList(cat6));
		p11.getCategorias().addAll(Arrays.asList(cat7));
	
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, 
				cat5, cat6,cat7, cat8, cat9, cat10));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));
		
		
		Estado est1 = new Estado(null, "Paraíba");
		Estado est2 = new Estado(null, "Rio Grande do Norte");
		
		Cidade cid1 = new Cidade(null, "Pedra Lavrada", est1);
		Cidade cid2 = new Cidade(null, "Campina Grande", est1);
		Cidade cid3 = new Cidade(null, "Parelhas", est2);
		
		est1.getCidades().addAll(Arrays.asList(cid1, cid2));
		est2.getCidades().addAll(Arrays.asList(cid3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));
		
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));
		Cliente cliente01 = new Cliente(null, "Lázaro Nóbrega Fonseca", "07673706431", TipoCliente.PESSOAFISICA, "lazaronobrega3@gmail.com", passEncod.encode("12345"));
		cliente01.getTelefones().addAll(Arrays.asList("(83)3375-4145", "(83)98656-2311"));
		
		Cliente cliente02 = new Cliente(null, "Maria José Nóbrega Fonseca", "16027264420", TipoCliente.PESSOAFISICA, "lazaromix@hotmail.com", passEncod.encode("54321"));
		cliente02.getTelefones().addAll(Arrays.asList("(83)3375-4145", "(83)98604-4760"));
		cliente02.addPerfil(Perfil.ADMIN);
		
		
		
		Endereco e1 = new Endereco(null, "José Lins do Regô", "213", "Próximo Assémbleia", "Centro", "58180-000", cliente01, cid1);
		Endereco e2 = new Endereco(null, "Sítio Patos", "0", "Próximo ao cruzeiro", "Zona Rural", "58180-000", cliente01, cid2);
		Endereco e3 = new Endereco(null, "José Lins do regô", "213", null , "Centro", "58180-000", cliente02, cid1);
		
		cliente01.getEnderecos().addAll(Arrays.asList(e1, e2));
		cliente02.getEnderecos().addAll(Arrays.asList(e3));
		
		
		clienteRepository.saveAll(Arrays.asList(cliente01, cliente02));
		enderecoRepository.saveAll(Arrays.asList(e1, e2, e3));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido venda1 = new Pedido(null, sdf.parse("17/05/2019 15:36"), cliente01, e1);
		Pedido venda2 = new Pedido(null, sdf.parse("15/05/2019 08:36"), cliente01, e2);
		
		
		
		Pagamento pg1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, venda1, 6);
		venda1.setPagamento(pg1);
		Pagamento pg2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, venda2, sdf.parse("15/05/2019 08:36"), null);
		venda2.setPagamento(pg2);
		
		//cliente01.getNotaDeVenda().addAll(Arrays.asList(venda1, venda2));
		cliente01.getPedidos().addAll(Arrays.asList(venda1, venda2));
		
		pedidoRepository.saveAll(Arrays.asList(venda1, venda2));
		pagamentoRepository.saveAll(Arrays.asList(pg1, pg2));
		
		ItemPedido iv1 = new ItemPedido(venda1, p1, 0.0, 1, 2000.0);
		ItemPedido iv2 = new ItemPedido(venda1, p3, 0.0, 2, 80.0);
		ItemPedido iv3 = new ItemPedido(venda2, p2, 100.0, 1, 800.0);
		
		venda1.getItens().addAll(Arrays.asList(iv1, iv2));
		venda2.getItens().addAll(Arrays.asList(iv3));
		
		p1.getItens().addAll(Arrays.asList(iv1));
		p2.getItens().addAll(Arrays.asList(iv3));
		p3.getItens().addAll(Arrays.asList(iv2));
		
		itemPedidoRepository.saveAll(Arrays.asList(iv1, iv2, iv3));
			
	}

}
