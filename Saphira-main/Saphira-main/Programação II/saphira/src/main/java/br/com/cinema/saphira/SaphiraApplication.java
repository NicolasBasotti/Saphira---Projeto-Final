package br.com.cinema.saphira;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = "br.com.cinema.saphira.model")
@SpringBootApplication
public class SaphiraApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaphiraApplication.class, args);
	}

}
