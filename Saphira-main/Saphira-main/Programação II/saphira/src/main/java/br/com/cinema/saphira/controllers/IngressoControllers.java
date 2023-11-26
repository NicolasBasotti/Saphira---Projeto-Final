package br.com.cinema.saphira.controllers;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.cinema.saphira.model.Ingresso;
import br.com.cinema.saphira.repository.IngressoRepository;

@RestController
@RequestMapping("/Ingressos")
public class IngressoControllers {
	
	@Autowired
	private IngressoRepository ingressoRepository;
	
	/**
	 * Deleta um ingresso pelo código.
	 * @param codingresso o código do ingresso a ser excluído.
	 * @return ResponseEntity com a mensagem de sucesso ou falha e o status HTTP.
	 */
	
	@DeleteMapping(value = "deletar")
	@ResponseBody
	public ResponseEntity<String> delete(@RequestParam Integer codingresso) {
		ingressoRepository.deleteById(codingresso);;
		return new ResponseEntity<String>("Ingresso excluido com sucesso", HttpStatus.OK);
	}
	
	/**
	 * Atualiza as informações de um ingresso.
	 * @param ingresso o objeto do tipo Ingresso a ser atualizado.
	 * @return ResponseEntity com o ingresso atualizado e o status HTTP.
	 */
	
	@PutMapping(value = "atualizar")
	@ResponseBody
	public ResponseEntity<?> atualizar(@RequestBody Ingresso ingresso) {
		if (ingresso.getCodigoIngresso() == null) {
			return new ResponseEntity<String>("Id não informado para atualizar", HttpStatus.OK);
		}
		Ingresso ing = ingressoRepository.saveAndFlush(ingresso);
		return new ResponseEntity<Ingresso>(ing, HttpStatus.OK);
	}
	
	/**
	 * Cria um novo ingresso através da entrada do console.
	 * @return mensagem indicando se a operação foi realizada com sucesso.
	 */
	
	@GetMapping(path = "cria")
	public String Gravar() {
		Scanner scanner = new Scanner(System.in);

        int codigoIngresso= scanner.nextInt();
        double precoIngresso = scanner.nextDouble();
        int sessaoIngresso = scanner.nextInt();

        scanner.close();
		Ingresso ingresso = new Ingresso();
		ingresso.setCodigoIngresso(codigoIngresso);
		ingresso.setCodigoSessao(sessaoIngresso);
		ingresso.setPrecoIngresso(precoIngresso);
		ingressoRepository.save(ingresso);
		return "Gravado";
	}
}
