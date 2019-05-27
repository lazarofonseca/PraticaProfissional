package br.com.vendas.services;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;

import br.com.vendas.domain.Pedido;

public class MockEmailService extends AbstractEmailService{

	private static final Logger LOG = LoggerFactory.getLogger(MockEmailService.class);

	@Override
	public void sendEmail(SimpleMailMessage msg) {
		LOG.info("Simulando envio de e-mal.....");
		LOG.info(msg.toString());
		LOG.info("E-mail enviado com sucesso!");
	}


	@Override
	public void sendHtmlEmail(MimeMessage msg) {
		LOG.info("Simulando envio de e-mal HTML.....");
		LOG.info(msg.toString());
		LOG.info("E-mail enviado com sucesso!");
		
	}
	
}
