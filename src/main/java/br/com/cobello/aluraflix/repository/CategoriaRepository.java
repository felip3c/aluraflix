package br.com.cobello.aluraflix.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.cobello.aluraflix.entity.Categoria;

/**
 * Interface para as operações de consulta no repositorio de Categorias
 * @author Felipe
 *
 */
@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
	
	List<Categoria> findAll();
}
