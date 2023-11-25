package br.com.cinema.saphira.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Sala {
	@Id
	@Column(name = "codsal")
	private int codigoSala;
	
	@Column(name = "nomsal", length = 2, nullable = false)
	private String nomeSala;
	
	@Column(name = "capsal", nullable = false)
	private int capacidadeSala;
	
	@ManyToOne
	@JoinColumn(name = "codcin", nullable = false)
	private int codigoCinema;
	
		
}
