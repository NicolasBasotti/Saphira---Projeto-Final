package br.com.cinema.saphira.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class GeneroDoFilme {
	@Id
	@Column(name = "codgenfil")
	private int codigoGenero;
	
	@Column(name = "nomgenfil", length = 40, nullable = false)
	private String nomeGenero;
	
}
