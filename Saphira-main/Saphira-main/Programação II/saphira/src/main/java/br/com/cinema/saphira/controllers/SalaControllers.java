package br.com.cinema.saphira.controllers;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.cinema.saphira.model.Sala;
import br.com.cinema.saphira.repository.SalaRepository;

@RestController
@RequestMapping("/Salas")
public class SalaControllers {
	@Autowired
	private SalaRepository salaRepository;
	
	/**
	 * Lista todas as salas cadastradas.
	 * @return ResponseEntity contendo a lista de salas e o status HTTP.
	 */

	
	@PostMapping(value = "listar")
	@ResponseBody
	public ResponseEntity<List<Sala>> listarSalas() {
		List<Sala> sala = salaRepository.findAll();
		return new ResponseEntity<List<Sala>>(sala, HttpStatus.OK);
	}
	
	/**
	 * Atualiza as informações de uma sala.
	 * @param sala o objeto do tipo Sala a ser atualizado.
	 * @return ResponseEntity com a sala atualizada e o status HTTP.
	 */
	
	@PutMapping(value = "atualizar")
	@ResponseBody
	public ResponseEntity<?> atualizar(@RequestBody Sala sala) {
		if (sala.getCodigoSala()== null) {
			return new ResponseEntity<String>("Id não informado para atualizar", HttpStatus.OK);
		}
		Sala sal = salaRepository.saveAndFlush(sala);
		return new ResponseEntity<Sala>(sal, HttpStatus.OK);
	}
	
	/**
	 * Cria uma nova sala através da entrada do console.
	 * @return mensagem indicando se a operação foi realizada com sucesso.
	 */
	
	@GetMapping(path = "cria")
	public String Gravar() {
		Scanner scanner = new Scanner(System.in);

        int CapacidadeSala= scanner.nextInt();
        int CodigoCinema = scanner.nextInt();
        int CodigoSala = scanner.nextInt();
        String nomeSala = scanner.nextLine();

        scanner.close();
		Sala sala = new Sala();
		sala.setCapacidadeSala(CapacidadeSala);
		sala.setCodigoCinema(CodigoCinema);
		sala.setCodigoSala(CodigoSala);
		sala.setNomeSala(nomeSala);
		return "Gravado";
	}
}	
