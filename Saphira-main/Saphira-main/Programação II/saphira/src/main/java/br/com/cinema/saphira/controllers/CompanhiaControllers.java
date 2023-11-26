package br.com.cinema.saphira.controllers;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.cinema.saphira.model.Companhia;
import br.com.cinema.saphira.repository.CompanhiaRepository;

@RestController
@RequestMapping("/Companhia")
public class CompanhiaControllers {
	@Autowired
	private CompanhiaRepository companhiaRepository;
	
	  /**
     * Lista todas as companhias.
     * @return ResponseEntity contendo a lista de companhias e o status HTTP.
     */
	
	@PostMapping(value = "listar")
	@ResponseBody
	public ResponseEntity<List<Companhia>> companhiaListar() {
		List<Companhia> companhias = companhiaRepository.findAll();
		return new ResponseEntity<List<Companhia>>(companhias, HttpStatus.OK);
	}

	  /**
     * Salva uma nova companhia.
     * @return contendo a nova companhia.
     */
	
	@PostMapping(value = "salvar")
	@ResponseBody
	public ResponseEntity<Companhia> salvar(@RequestBody Companhia companhia) {
		Companhia com = companhiaRepository.save(companhia);
		return new ResponseEntity<Companhia>(com, HttpStatus.CREATED);
	}
	
	  /**
     * Deleta uma companhia.
     * @return contendo a nova companhia.
     */

	@DeleteMapping(value = "deletar")
	@ResponseBody
	public ResponseEntity<String> delete(@RequestParam Integer codcompanhia) {
		companhiaRepository.deleteById(codcompanhia);
		;
		return new ResponseEntity<String>("Companhia excluido com sucesso", HttpStatus.OK);
	}
	
	
	  /**
   * Busca uma companhia por um determinado id.
   * @return retorna as companhias da busca.
   */

	@GetMapping(value = "buscarCompanhia")
	@ResponseBody
	public ResponseEntity<Companhia> buscarCompanhia(@RequestParam(name = "comcompanhia") Integer comcompanhia) {
		Companhia com = companhiaRepository.findById(comcompanhia).get();
		return new ResponseEntity<Companhia>(com, HttpStatus.OK);
	}

	  /**
 * Busca uma companhia por um determinado id.
 * @return atualiza uma companhia existente.
 */
	
	@PutMapping(value = "atualizar")
	@ResponseBody
	public ResponseEntity<?> atualizar(@RequestBody Companhia companhia) {
		if (companhia.getCodigoCompanhia() == null) {
			return new ResponseEntity<String>("Id não informado para atualizar", HttpStatus.OK);
		}
		Companhia com = companhiaRepository.saveAndFlush(companhia);
		return new ResponseEntity<Companhia>(com, HttpStatus.OK);
	}

	@GetMapping(path = "cria")
	public String Gravar() {
		Scanner scanner = new Scanner(System.in);

		int codigoCompanhia = scanner.nextInt();
		String nomeCompanhia = scanner.nextLine();
		
		scanner.close();
		Companhia companhia = new Companhia();
		companhia.setCodigoCompanhia(codigoCompanhia);
		companhia.setNomeCompanhia(nomeCompanhia);
		companhiaRepository.save(companhia);
		return "Gravado";
	}
}
