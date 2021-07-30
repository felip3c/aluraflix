package br.com.cobello.aluraflix.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidade que representa as Categorias
 * @author Felipe
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Categoria 
{
	@Id @GeneratedValue
	private long id;
	private String titulo;
	private String cor;
}
