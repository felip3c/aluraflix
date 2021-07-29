package br.com.cobello.aluraflix.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.cobello.aluraflix.entity.Video;
import br.com.cobello.aluraflix.exception.VideoNaoEncontradoException;
import br.com.cobello.aluraflix.pojo.VideoRequest;
import br.com.cobello.aluraflix.service.VideoService;
import lombok.extern.slf4j.Slf4j;

/**
 * API de Operaões de Videos
 * 
 * <p>
 * Trata os endpoints
 * <p>
 * <b>/videos</b><br>
 * <b>/videos/{id}</b><br>
 * 
 * @author Felipe
 *
 */
@RestController
@Slf4j
@Validated
public class VideoAPI extends BaseAPI {
	
	@Autowired
	VideoService service;

	/**
	 * Metodo responsavel pelo tratamento das requisições do tipo
	 * {@link PostMapping} para inserir um novo Video
	 * 
	 * @param request
	 * @throws ClienteException
	 */
	@PostMapping("/videos")
	@ResponseStatus(HttpStatus.CREATED)
	public Video cadastrar(@Valid @RequestBody VideoRequest request) {
		
		log.info("Cadastrar um Video [{}]", request);

		return service.registrar(request);
	}
	
	/**
	 * Metodo responsavel pelo tratamento das requisições do tipo
	 * {@link PutMapping} para atualizar um novo Video
	 * 
	 * @param request
	 * @throws VideoNaoEncontradoException 
	 */
	@PutMapping("/videos/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Video atualizar(@PathVariable long id, @Valid @RequestBody VideoRequest request) throws VideoNaoEncontradoException {
		
		log.info("Atualizar um Video [{}]", request);

		return service.atualizar(id, request);
	}

	/**
	 * Metodo responsavel pelo tratamento das requisições do tipo
	 * {@link GetMapping} para buscar um vide pelo seu id
	 * 
	 * @param conta
	 * @return {@link Video}
	 * @throws Exception
	 * @throws ClienteException
	 * @throws VideoNaoEncontradoException
	 */
	@GetMapping("/videos/{id}")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Video buscar(@PathVariable long id) throws Exception {
		
		log.info("Consulta de Video por ID [{}]", id);

		return service.buscar(id);
	}

	/**
	 * Metodo responsavel pelo tratamento das requisições do tipo
	 * {@link GetMapping} para buscar todos os videos
	 * 
	 * @param id
	 * @return {@link List} de {@link Video}
	 * @throws VideoNaoEncontradoException
	 */
	@GetMapping("/videos")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Video> buscar() throws VideoNaoEncontradoException {
		
		log.info("Consulta de Videos");

		try {
			return service.buscar();
		} 
		catch (VideoNaoEncontradoException e) {
			log.error(e.getMessage());
			throw e;
		}
	}

//	/**
//	 * Metodo responsavel pelo tratamento das requisi��es do tipo
//	 * {@link PostMapping} realizar uma transferencia
//	 * 
//	 * @param conta
//	 * @param request
//	 * @throws Exception
//	 * @throws SaldoInsuficienteException
//	 * @throws VideoNaoEncontradoException
//	 * @throws ClienteException
//	 */
//	@PostMapping("/cliente/{conta}/transferir")
//	@ResponseStatus(HttpStatus.CREATED)
//	@ResponseBody
//	public void transferir(@PathVariable @Size(min = 1, max = 36) String conta,
//			@Valid @RequestBody ClienteTransferenciaRequest request) throws Exception {
//		
//		log.info("Realizar Transferencia da Conta [{}] [{}]", conta, request);
//
//		try {
//			service.transferir(conta, request);
//		} 
//		catch (ClienteException | VideoNaoEncontradoException | SaldoInsuficienteException e) {
//			log.error(e.getMessage());
//			throw e;
//		}
//	}
//
//	/**
//	 * Metodo responsavel pelo tratamento das requisi��es do tipo
//	 * {@link GetMapping} para buscar as movimenta��es de um cliente pela sua
//	 * conta
//	 * 
//	 * @param conta
//	 * @return {@link List} de {@link Movimentacao}
//	 * @throws MovimentacaoNaoEncontradaException
//	 */
//	@GetMapping("/cliente/{conta}/movimentacao")
//	@ResponseStatus(HttpStatus.OK)
//	@ResponseBody
//	public List<Movimentacao> movimentacao(@PathVariable @Size(min = 1, max = 36) String conta) throws MovimentacaoNaoEncontradaException {
//		
//		log.info("Consultar Movimentacaoes da Conta [{}]", conta);
//
//		try {
//			return service.movimentacoes(conta);
//		} 
//		catch (MovimentacaoNaoEncontradaException e) {
//			log.error(e.getMessage());
//			throw e;
//		}
//	}
}
