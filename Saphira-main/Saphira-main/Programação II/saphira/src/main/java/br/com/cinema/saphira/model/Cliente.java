package br.com.cinema.saphira.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


/**
 * Representa a entidade Cliente no sistema.
 */
@Entity
@Data
public class Cliente {
	@Id
	@Column(name ="codcli")
	private Integer codigoCliente;
	
	@Column(name = "nomcli", length = 40, nullable = false)
	private String nomeCliente;
	
	@Column(name = "cpfcli", nullable = false, unique = true)
	private double cpfCliente;
}
