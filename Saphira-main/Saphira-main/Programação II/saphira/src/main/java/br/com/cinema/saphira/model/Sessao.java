package br.com.cinema.saphira.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

/**
 * Representa a entidade Sessao no sistema.
 */

@Entity
@Data
public class Sessao {
	@Id
	@Column(name = "codses")
	private Integer codigoSessao;
	
	@Column(name = "horses", nullable = false)
	private Date horarioSessao;
	
	@ManyToOne
	@JoinColumn(name = "codfil", nullable = false)
	private int codigoFilme;
}
