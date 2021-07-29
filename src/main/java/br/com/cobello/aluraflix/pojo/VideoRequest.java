package br.com.cobello.aluraflix.pojo;

import com.sun.istack.NotNull;

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
	private long id;
	private String titulo;
	private String descricao;
	@NotNull
	private String url;
}
