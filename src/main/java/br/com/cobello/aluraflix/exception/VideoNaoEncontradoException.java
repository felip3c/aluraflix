package br.com.cobello.aluraflix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exceção para tratar eventos de Video não encontrado
 * @author Felipe
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class VideoNaoEncontradoException extends Exception{

	private static final long serialVersionUID = 1161839313944002352L;

	public VideoNaoEncontradoException(String message) 
	{
		super(message);
	}

}
