package br.com.cinema.saphira.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;


/**
 * Representa a entidade Ingresso no sistema.
 */
@Entity
@Data
public class Ingresso {
	@Id
	@Column(name = "coding")
	private Integer codigoIngresso;
	
	@Column(name = "preing", nullable = false)
	private double precoIngresso;
	
	@OneToOne
	@JoinColumn(name = "codses", nullable = false)
	private int codigoSessao;
}
