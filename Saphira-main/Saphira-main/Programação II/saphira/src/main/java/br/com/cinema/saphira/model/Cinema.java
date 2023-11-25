package br.com.cinema.saphira.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Cinema {
	@Id
	@Column(name = "codcin")
	private int codigoCinema;
	
	@Column(name = "cnpcin")
	private double cnpjCinema;
	
	@Column(name = "endcin", length = 60, nullable = false)
	private String endercoCinema;
	
	@Column(name = "telcin")
	private double telefoneCinema;
	
}
