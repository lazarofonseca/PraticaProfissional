package br.com.vendas.services;

import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import br.com.vendas.domain.Cliente;
import br.com.vendas.domain.Pedido;
import br.com.vendas.repositories.ClienteRepository;

public abstract class AbstractEmailService implements EmailService{
	
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	TemplateEngine templeteEngine;
	@Autowired
	private JavaMailSender javaMailSender;

	@Value("${default.sender}")
	private String sender;
	
	@Override
	public void sendOrderConfirmationEmail(Pedido obj) {
		SimpleMailMessage sm = prepareSimpleMailMessageFromPedido(obj);
		sendEmail(sm);
	}

	// Metódo para envio de e-mail
	protected SimpleMailMessage prepareSimpleMailMessageFromPedido(Pedido obj) {
		
		Cliente cli = new Cliente(null, null, null, null, null);
		String email = obj.getCliente().getEmail();
		
		
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(email); // Setando o destinatario
		sm.setFrom(sender); // Setando o remetente
		sm.setSubject("Pedido confirmado " + obj.getId()); // Setando o assunto do e-mail
		sm.setSentDate(new Date(System.currentTimeMillis())); // Data
		sm.setText(obj.toString()); // Dados do pedido
		return sm;
	}

	protected String htmlFromTemplatePedido(Pedido obj) {
		Context context = new Context();
		context.setVariable("pedido", obj);
		return templeteEngine.process("email/confirmacaopedido", context);
	}
	
	@Override
	public void sendOrderConfirmationHtmlEmail(Pedido obj) {
		
		try {
			MimeMessage mm = prepareMimeMassageFromPedido(obj);
			sendHtmlEmail(mm);
			
		} catch (MessagingException e) {
			sendOrderConfirmationEmail(obj);
		}
		
	}

	private MimeMessage prepareMimeMassageFromPedido(Pedido obj) throws MessagingException {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mmh = new MimeMessageHelper(mimeMessage, true);
		mmh.setTo(obj.getCliente().getEmail());
		mmh.setFrom(sender);
		mmh.setSubject("Pedido confirmado! Código: " + obj.getId());
		mmh.setSentDate(new Date(System.currentTimeMillis()));
		mmh.setText(htmlFromTemplatePedido(obj), true);
		
		return mimeMessage;
	}
}
