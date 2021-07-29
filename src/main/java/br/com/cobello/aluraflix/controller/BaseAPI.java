package br.com.cobello.aluraflix.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

/**
 * Class Base para as APIs, onde é feito o tratamento de erro das validações
 * @author Felipe
 *
 */
public class BaseAPI {

	/**
	 * Handler para falha na validação dos argumentos de um Request
	 * @param ex
	 * @return
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	    
	    ex.getBindingResult().getFieldErrors().forEach(fieldError -> {
	        errors.put("error", "Campo [" + 
                    fieldError.getField() + "] " + fieldError.getDefaultMessage());
	    });
	    return errors;
	}
	
	/**
	 * Handler para falha na validação do formato dos argumentos de um Request
	 * @param ex
	 * @return
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidFormatException.class)
	public Map<String, String> handleFormatExceptions(InvalidFormatException ex) {
	    Map<String, String> errors = new HashMap<>();
	    errors.put("message", ex.getCause().getMessage());
	    return errors;
	}
}