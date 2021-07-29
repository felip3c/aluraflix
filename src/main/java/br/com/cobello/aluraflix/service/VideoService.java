package br.com.cobello.aluraflix.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cobello.aluraflix.entity.Video;
import br.com.cobello.aluraflix.exception.VideoNaoEncontradoException;
import br.com.cobello.aluraflix.pojo.VideoRequest;
import br.com.cobello.aluraflix.repository.VideoRepository;

@Service
public class VideoService {

	@Autowired
	private VideoRepository videoRepository;

	public List<Video> buscar() throws VideoNaoEncontradoException {
		List<Video> videos = videoRepository.findAll();

		if (videos.isEmpty()) {
			throw new VideoNaoEncontradoException("Sem Videos");
		}

		return videos;
	}

	public Video buscar(long id) throws VideoNaoEncontradoException {
		final Optional<Video> video;

		video = videoRepository.findById(id);

		if (!video.isPresent()) {
			throw new VideoNaoEncontradoException("Video [" + id + "] não encontrado");
		}

		return video.get();
	}

	/**
	 * Registra um Video
	 * 
	 * @param request
	 */
	public Video registrar(VideoRequest request) {
		final Video db = new Video();

		db.setDescricao(request.getDescricao());
		db.setTitulo(request.getTitulo());
		db.setUrl(request.getUrl());

		return videoRepository.save(db);

	}
	
	/**
	 * Registra um Video
	 * 
	 * @param request
	 * @throws VideoNaoEncontradoException 
	 */
	public Video atualizar(long id, VideoRequest request) throws VideoNaoEncontradoException {
		
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
			throw new VideoNaoEncontradoException("Video Não encontrado");
		}



	}

}
