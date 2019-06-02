package br.com.vendas.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vendas.domain.ItemPedido;
import br.com.vendas.domain.PagamentoComBoleto;
import br.com.vendas.domain.Pedido;
import br.com.vendas.domain.enums.EstadoPagamento;
import br.com.vendas.repositories.ItemPedidoRepository;
import br.com.vendas.repositories.PagamentoRepository;
import br.com.vendas.repositories.PedidoRepository;
import br.com.vendas.repositories.ProdutoRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;
		
	@Autowired
	private BoletoService boletoService;
	@Autowired
	private ProdutoService produtoService;
	@Autowired
	ProdutoRepository produtoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	@Autowired
	private EmailService emailService;
	@Autowired
	ClienteService clienteService;
	@Autowired
	SmtpEmailService smtpEmailService;
	

	public Pedido find(Integer id) throws ObjectNotFoundException {

		Optional<Pedido> obj = repo.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));

	}

	
	public Pedido insert(Pedido obj) throws ObjectNotFoundException {
		obj.setId(null);
		obj.setInstante(new Date());
		obj.setCliente(clienteService.find(obj.getCliente().getId()));
		obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
		obj.getPagamento().setPedido(obj);
		if (obj.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
			boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());
		}
		obj = repo.save(obj);
		pagamentoRepository.save(obj.getPagamento());
		for (ItemPedido ip : obj.getItens()) {
			ip.setDesconto(0.0);
			ip.setProduto(produtoService.find(ip.getProduto().getId()));
			ip.setPreco(produtoService.find(ip.getProduto().getId()).getValor_venda());
			ip.setPedido(obj);
		}
		itemPedidoRepository.saveAll(obj.getItens());
		//emailService.sendOrderConfirmationHtmlEmail(obj);
		smtpEmailService.sendOrderConfirmationHtmlEmail(obj);
		//Usado para simular o envio do E-mailMock
		//emailService.sendOrderConfirmationEmail(obj);
		return obj;
	}

}
