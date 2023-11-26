package br.com.cinema.saphira.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;


/**
 * Representa a entidade Venda no sistema.
 */

@Entity
@Data
public class Vendas {
	@Id
	@Column(name = "codven")
	private Integer codigoVenda;
	
	@Column(name = "datven", nullable = false)
	private Date dataVenda;
	
	@ManyToOne
	@JoinColumn(name = "coding", nullable = false)
	private int codigoIngresso;
	
	@ManyToOne
	@JoinColumn(name = "codcli", nullable = false)
	private int codigoCliente;
	
}
