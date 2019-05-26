package br.com.vendas.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import br.com.vendas.controller.exception.FieldMessage;
import br.com.vendas.domain.Cliente;
import br.com.vendas.dto.ClienteDTO;
import br.com.vendas.repositories.ClienteRepository;

public class ClientUpDateValidator implements ConstraintValidator<ClientUpDate, ClienteDTO> {
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Override
	public void initialize(ClientUpDate ann) {
	}

	@Override
	public boolean isValid(ClienteDTO objDto, ConstraintValidatorContext context) {

		//Pegar a o código que vem na URI para comparar o email
		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		
		List<FieldMessage> list = new ArrayList<>();
		Integer uriId = Integer.parseInt(map.get("id"));

		Cliente aux = clienteRepository.findByEmail(objDto.getEmail());
		if (aux != null && !aux.getId().equals(uriId)) {
			list.add(new FieldMessage("email", "Email já existente"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldNome()).addConstraintViolation();
		}
		return list.isEmpty();
	}
}
