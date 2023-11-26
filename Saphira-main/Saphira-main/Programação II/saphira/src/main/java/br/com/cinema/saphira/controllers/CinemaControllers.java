package br.com.cinema.saphira.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.cinema.saphira.model.Cinema;
import br.com.cinema.saphira.repository.CinemaRepository;

@RestController
@RequestMapping("/Cinema")
public class CinemaControllers {
	@Autowired
	private CinemaRepository cinemaRepository;

	/**
	 * Cria uma cinema
	 * @return novo cinema
	 */
	@PostMapping(value = "Criar")
	@ResponseBody
	public ResponseEntity<Cinema> salvar(@RequestBody Cinema cinema) {
		Cinema cine = cinemaRepository.save(cinema);
		return new ResponseEntity<Cinema>(cine, HttpStatus.CREATED);
	}

	/**
	 * Atualiza as informações do cinema
	 * @return atualização cinema
	 */	
	
	@PutMapping(value = "atualizar")
	@ResponseBody
	public ResponseEntity<Cinema> atualizar(@RequestBody Cinema cinema) {
		Cinema cine = cinemaRepository.saveAndFlush(cinema);
		return new ResponseEntity<Cinema>(cine, HttpStatus.OK);
	}
}
