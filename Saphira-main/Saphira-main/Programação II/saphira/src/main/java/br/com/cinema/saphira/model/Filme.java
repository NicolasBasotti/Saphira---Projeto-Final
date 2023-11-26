package br.com.cinema.saphira.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;


/**
 * Representa a entidade Filme no sistema.
 */
@Entity
@Data
public class Filme {
	@Id
	@Column(name = "codfil")
	private Integer codigoFilme;
	
	@Column(name = "nomfil", length = 100, nullable = false)
	private String nomeFilme;
	
	@Column(name = "genfil", length = 50, nullable = false)
	private String generoFilme;
	
	@Column(name = "temdurfil",  nullable = false)
	private int tempoDuracao;
	
	@Column(name = "codavacli")
	private double codigoAvaliacao;
	
	@Column(name = "datlanfil")
	private Date dataLancamento;
	
	@ManyToOne
	@JoinColumn(name = "codcom")
	private int codigoCompanhia;
	
	@ManyToOne
	@JoinColumn(name = "codgnefil")
	private int codigoGenero;
	
	@OneToOne
	@JoinColumn(name = "codclafil")
	private int codigoClassificao;
	
	
}
