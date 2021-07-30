package br.com.cobello.aluraflix.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cobello.aluraflix.entity.Categoria;
import br.com.cobello.aluraflix.entity.Video;
import br.com.cobello.aluraflix.exception.NaoEncontradoException;
import br.com.cobello.aluraflix.pojo.VideoRequest;
import br.com.cobello.aluraflix.repository.CategoriaRepository;
import br.com.cobello.aluraflix.repository.VideoRepository;

@Service
public class VideoService {

	@Autowired
	private VideoRepository videoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	public List<Video> buscar() throws NaoEncontradoException {
		List<Video> videos = videoRepository.findAll();

		if (videos.isEmpty()) {
			throw new NaoEncontradoException("Sem Videos");
		}

		return videos;
	}

	public Video buscar(long id) throws NaoEncontradoException {
		final Optional<Video> video;

		video = videoRepository.findById(id);

		if (!video.isPresent()) {
			throw new NaoEncontradoException("Video [" + id + "] não encontrado");
		}

		return video.get();
	}

	/**
	 * Registra um Video
	 * 
	 * @param request
	 */
	public Video registrar(VideoRequest request) {
		final Video video = new Video();
		final Optional<Categoria> categoria = categoriaRepository.findById(request.getCategoria());

		video.setDescricao(request.getDescricao());
		video.setTitulo(request.getTitulo());
		video.setUrl(request.getUrl());
		
		if (categoria.isPresent())
		{
			video.setCategoriaId(request.getCategoria());
		}
		else
		{
			video.setCategoriaId(1);
		}

		return videoRepository.save(video);

	}
	
	/**
	 * Registra um Video
	 * 
	 * @param request
	 * @throws NaoEncontradoException 
	 */
	public Video atualizar(long id, VideoRequest request) throws NaoEncontradoException {
		
		final Optional<Video> db = videoRepository.findById(id);
		
		if (db.isPresent())
		{
			db.get().setDescricao(request.getDescricao());
			db.get().setTitulo(request.getTitulo());
			db.get().setUrl(request.getUrl());
			return videoRepository.save(db.get());
		}
		else
		{
			throw new NaoEncontradoException("Video Não encontrado");
		}
	}
	
	/**
	 * Deleta um Video
	 * 
	 * @throws NaoEncontradoException 
	 */
	public Video deletar(long id) throws NaoEncontradoException {
		
		final Optional<Video> db = videoRepository.findById(id);
		
		if (db.isPresent())
		{
			videoRepository.delete(db.get());
			
			return db.get();
		}
		else
		{
			throw new NaoEncontradoException("Video Não encontrado");
		}
	}

}
