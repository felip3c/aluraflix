package br.com.cobello.aluraflix.pojo;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Pojo que representa as Categorias
 * @author Felipe
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaRequest 
{
	@NotBlank(message = "titulo é obrigatorio")
	private String titulo;
	@NotBlank(message = "cor é obrigatorio")
	private String cor;
}
