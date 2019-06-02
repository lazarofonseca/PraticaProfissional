package br.com.vendas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.security.authentication.AuthenticationManager;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.vendas.domain.PagamentoComBoleto;
import br.com.vendas.domain.PagamentoComCartao;
import br.com.vendas.services.EmailService;
import br.com.vendas.services.MockEmailService;
import br.com.vendas.services.SmtpEmailService;

@Configuration
public class JackconConfig {
	
	
	@Bean
	public Jackson2ObjectMapperBuilder objectMapperBuilder() {
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder() {
			public void configure(ObjectMapper objectMapper) {
				objectMapper.registerSubtypes(PagamentoComCartao.class);
				objectMapper.registerSubtypes(PagamentoComBoleto.class);
				super.configure(objectMapper);
			}
		};
		return builder;
	}
	
	@Bean
	public EmailService emailService() {
		return (EmailService) new MockEmailService();
	}
	
	@Bean
	public SmtpEmailService smtpEmailService() {
		return new SmtpEmailService();
	}
	
	

}
