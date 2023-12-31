package br.com.cinema.saphira.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


/**
 * Representa a entidade Companhia no sistema.
 */
@Entity
@Data
public class Companhia {
	@Id
	@Column(name = "codcom", nullable = false)
	private Integer codigoCompanhia;
	

	@Column(name = "nomcom", length = 40, nullable = false)
	private String nomeCompanhia;
}
