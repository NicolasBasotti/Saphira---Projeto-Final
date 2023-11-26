package br.com.cinema.saphira.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * Representa a entidade ClassificacaoIdade no sistema.
 */
@Entity
@Data
public class ClassificacaoIdade {
	@Id
	@Column(name = "codcla")
	private int codigoClassificacao;
	
	@Column(name = "nomclafil", length = 40, nullable = false)
	private String nomeClassificacao;
	
}
