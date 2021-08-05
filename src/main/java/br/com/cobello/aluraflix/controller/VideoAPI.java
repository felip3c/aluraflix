package br.com.cobello.aluraflix.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.cobello.aluraflix.entity.Video;
import br.com.cobello.aluraflix.exception.NaoEncontradoException;
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
	 * @throws NaoEncontradoException 
	 */
	@PutMapping("/videos/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Video atualizar(@PathVariable long id, @Valid @RequestBody VideoRequest request) throws NaoEncontradoException {
		
		log.info("Atualizar um Video [{}]", request);

		return service.atualizar(id, request);
	}
	
	/**
	 * Metodo responsavel pelo tratamento das requisições do tipo
	 * {@link DeleteMapping} para deletar um Video
	 * 
	 * @param request
	 * @throws NaoEncontradoException 
	 */
	@DeleteMapping("/videos/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Video deletar(@PathVariable long id) throws NaoEncontradoException {
		
		log.info("Deletar um Video [{}]", id);

		return service.deletar(id);
	}

	/**
	 * Metodo responsavel pelo tratamento das requisições do tipo
	 * {@link GetMapping} para buscar um vide pelo seu id
	 * 
	 * @param conta
	 * @return {@link Video}
	 * @throws Exception
	 * @throws ClienteException
	 * @throws NaoEncontradoException
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
	 * @throws NaoEncontradoException
	 */
	@GetMapping("/videos")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Video> buscar(@PageableDefault(page = 0, size=5) Pageable pageable, @RequestParam(required = false) final String search) throws NaoEncontradoException {
		
		log.info("Consulta de Videos");

		try {
			return service.buscar(search, pageable);
		} 
		catch (NaoEncontradoException e) {
			log.error(e.getMessage());
			throw e;
		}
	}
	
	/**
	 * Metodo responsavel pelo tratamento das requisições do tipo
	 * {@link GetMapping} para buscar todos os videos
	 * 
	 * @param id
	 * @return {@link List} de {@link Video}
	 * @throws NaoEncontradoException
	 */
	@GetMapping("/videos/free")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Video> buscarFree() throws NaoEncontradoException {
		
		log.info("Consulta de Videos");

		try {
			return service.buscar(null, PageRequest.of(0, 5));
		} 
		catch (NaoEncontradoException e) {
			log.error(e.getMessage());
			throw e;
		}
	}


}
