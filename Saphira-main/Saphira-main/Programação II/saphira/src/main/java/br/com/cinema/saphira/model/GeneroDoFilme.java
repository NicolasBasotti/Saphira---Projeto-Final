package br.com.cinema.saphira.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * Representa a entidade Genero do filme no sistema.
 */
@Entity
@Data
public class GeneroDoFilme {
	@Id
	@Column(name = "codgenfil")
	private Integer codigoGenero;
	
	@Column(name = "nomgenfil", length = 40, nullable = false)
	private String nomeGenero;
	
}
