package br.com.cobello.aluraflix.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cobello.aluraflix.entity.Categoria;
import br.com.cobello.aluraflix.entity.Video;
import br.com.cobello.aluraflix.exception.NaoEncontradoException;
import br.com.cobello.aluraflix.pojo.CategoriaRequest;
import br.com.cobello.aluraflix.repository.CategoriaRepository;
import br.com.cobello.aluraflix.repository.VideoRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private VideoRepository videoRepository;

	public List<Categoria> buscar() throws NaoEncontradoException {
		List<Categoria> categorias = categoriaRepository.findAll();

		if (categorias.isEmpty()) {
			throw new NaoEncontradoException("Sem Categorias");
		}

		return categorias;
	}

	public Categoria buscar(long id) throws NaoEncontradoException {
		final Optional<Categoria> categoria;

		categoria = categoriaRepository.findById(id);

		if (!categoria.isPresent()) {
			throw new NaoEncontradoException("Categoria [" + id + "] não encontrado");
		}

		return categoria.get();
	}
	
	public List<Video> buscarVideos(long id) throws NaoEncontradoException {

		return videoRepository.findByCategoriaId(id);
	}

	/**
	 * Registra um Categoria
	 * 
	 * @param request
	 */
	public Categoria registrar(CategoriaRequest request) {
		final Categoria db = new Categoria();

		db.setTitulo(request.getTitulo());
		db.setCor(request.getCor());

		return categoriaRepository.save(db);

	}
	
	/**
	 * Atualiza um Categoria
	 * 
	 * @param request
	 * @throws NaoEncontradoException 
	 */
	public Categoria atualizar(long id, CategoriaRequest request) throws NaoEncontradoException {
		
		final Optional<Categoria> db = categoriaRepository.findById(id);
		
		if (db.isPresent())
		{
			db.get().setTitulo(request.getTitulo());
			db.get().setCor(request.getCor());
			return categoriaRepository.save(db.get());
		}
		else
		{
			throw new NaoEncontradoException("Categoria Não encontrada");
		}
	}
	
	/**
	 * Deleta um Categoria
	 * 
	 * @throws NaoEncontradoException 
	 */
	public Categoria deletar(long id) throws NaoEncontradoException {
		
		final Optional<Categoria> db = categoriaRepository.findById(id);
		
		if (db.isPresent())
		{
			categoriaRepository.delete(db.get());
			
			return db.get();
		}
		else
		{
			throw new NaoEncontradoException("Categoria Não encontrada");
		}
	}

}
