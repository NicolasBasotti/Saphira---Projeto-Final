package br.com.cinema.saphira.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Funcionario {

	@Id
	@Column(name = "codfun")
	private int codigoFuncionario;

	@Column(name = "nomfun", length = 40, nullable = false)
	private String nomeFuncionario;

	@Column(name = "datnasfun", nullable = false)
	private Date dataNascimento;
	
	@Column(name = "datadifun", nullable = false)
	private Date dataAdmissao;

	@Column(name = "cpffun", nullable = false)
	private double cpfFuncionario;
	
	@Column(name ="telfun", nullable = false)
	private double telefoneFuncionario;
	
	@Column(name = "carhorfun", nullable = false)
	private int cargaHoraria;
	
	@ManyToOne
	@JoinColumn(name = "codcin", nullable = false)
	private int codigoCinema;
}
