package br.com.cinema.saphira.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Cliente {
	@Id
	@Column(name ="codcli")
	private int codigoCliente;
	
	@Column(name = "nomcli", length = 40, nullable = false)
	private String nomeCliente;
	
	@Column(name = "cpfcli", nullable = false, unique = true)
	private double cpfCliente;
}
