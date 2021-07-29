package br.com.cobello.aluraflix.pojo;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Pojo que representa os Videos
 * @author Felipe
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoRequest 
{
	@NotBlank(message = "titulo é obrigatorio")
	private String titulo;
	@NotBlank(message = "descricao é obrigatorio")
	private String descricao;
	@NotBlank(message = "url é obrigatorio")
	private String url;
}
