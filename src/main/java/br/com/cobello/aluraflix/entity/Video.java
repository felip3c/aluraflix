package br.com.cobello.aluraflix.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidade que representa os Videos
 * @author Felipe
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonInclude(Include.NON_NULL)
public class Video 
{
	@Id @GeneratedValue
	private long id;
	private String titulo;
	private String descricao;
	private String url;
	private long categoriaId;
	@ManyToOne
	@JoinColumn(name="categoriaId", referencedColumnName = "id", insertable = false, updatable = false)
	private Categoria categoria;
}
