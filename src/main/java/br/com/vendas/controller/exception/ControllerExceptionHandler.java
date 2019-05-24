package br.com.vendas.controller.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.vendas.services.exception.DataIntegrityException;
import javassist.tools.rmi.ObjectNotFoundException;

//Classe auxiliar que intercepta as exceções

@ControllerAdvice
public class ControllerExceptionHandler {
	
	
	//Metodo captura a exceção e as informações da requisição respectivamente 1º e 2º parametros
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e,HttpServletRequest request){
	
			StandardError error = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), 
					System.currentTimeMillis());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

	}
	
	@ExceptionHandler(DataIntegrityException.class)
	public ResponseEntity<StandardError> DataIntegrity(DataIntegrityException e,HttpServletRequest request){
	
			StandardError error = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), 
					System.currentTimeMillis());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);

	}
	
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> Validation(MethodArgumentNotValidException e,HttpServletRequest request){
	
			ValidationError err = new ValidationError(HttpStatus.BAD_REQUEST.value(), "Erro de validação", 
					System.currentTimeMillis());
			for(FieldError x : e.getBindingResult().getFieldErrors()) {
				err.addError(x.getField(), x.getDefaultMessage());
			}
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);

	}
	

}
