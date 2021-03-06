package br.com.vendas.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.vendas.controller.exception.FieldMessage;
import br.com.vendas.domain.Cliente;
import br.com.vendas.domain.enums.TipoCliente;
import br.com.vendas.dto.ClienteNewDTO;
import br.com.vendas.repositories.ClienteRepository;
import br.com.vendas.services.validation.utils.MascarasDocs;

public class ClientInsertValidator implements ConstraintValidator<ClientInsert, ClienteNewDTO> {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Override
	public void initialize(ClientInsert ann) {
	}

	@Override
	public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();

		if(objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) && !MascarasDocs.isValidCPF(objDto.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj", "CPF inválido"));
			
		}
		if(objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod()) && !MascarasDocs.isValidCNPJ(objDto.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj", "CNPJ inválido"));
			
		}
		
		Cliente aux = clienteRepository.findByEmail(objDto.getEmail());
		if (aux != null) {
			list.add(new FieldMessage("email", "Email já existente"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldNome()).addConstraintViolation();
		}
		return list.isEmpty();
	}
}
