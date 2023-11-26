package br.com.cinema.saphira.controllers;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import br.com.cinema.saphira.model.Sessao;
import br.com.cinema.saphira.repository.SessaoRepository;

@RestController
@RequestMapping("/Sessao")
public class SessaoControllers {
	@Autowired
	private SessaoRepository sessaoRepository;

	/**
	 * Lista todas as sessões cadastradas.
	 * @return ResponseEntity contendo a lista de sessões e o status HTTP.
	 */
	
	@PostMapping(value = "listar")
	@ResponseBody
	public ResponseEntity<List<Sessao>> listarSessao() {
		List<Sessao> sessao = sessaoRepository.findAll();
		return new ResponseEntity<List<Sessao>>(sessao, HttpStatus.OK);
	}

	/**
	 * Salva uma nova sessão.
	 * @param sessao o objeto do tipo Sessao a ser salvo.
	 * @return ResponseEntity com a sessão criada e o status HTTP.
	 */
	
	@PostMapping(value = "salvar")
	@ResponseBody
	public ResponseEntity<Sessao> salvar(@RequestBody Sessao sessao) {
		Sessao ses = sessaoRepository.save(sessao);
		return new ResponseEntity<Sessao>(ses, HttpStatus.CREATED);
	}

	 /**
     * Deleta uma sessão pelo código.
     * @param codSessao o código da sessão a ser excluída.
     * @return ResponseEntity com a mensagem de sucesso ou falha e o status HTTP.
     */
	
	@DeleteMapping(value = "deletar")
	@ResponseBody
	public ResponseEntity<String> delete(@RequestParam Integer codSessao) {
		sessaoRepository.deleteById(codSessao);
		;
		return new ResponseEntity<String>("Filme excluido com sucesso", HttpStatus.OK);
	}
	
	  /**
     * Atualiza as informações de uma sessão.
     * @param sessao o objeto do tipo Sessao a ser atualizado.
     * @return ResponseEntity com a sessão atualizada e o status HTTP.
     */

	@PutMapping(value = "atualizar")
	@ResponseBody
	public ResponseEntity<?> atualizar(@RequestBody Sessao sessao) {
		if (sessao.getCodigoSessao() == null) {
			return new ResponseEntity<String>("Id não informado para atualizar", HttpStatus.OK);
		}
		Sessao ses = sessaoRepository.saveAndFlush(sessao);
		return new ResponseEntity<Sessao>(ses, HttpStatus.OK);
	}
	
	 /**
     * Cria uma nova sessão através da entrada do console.
     * @return mensagem indicando se a operação foi realizada com sucesso.
     */

	@GetMapping(path = "cria")
	public String Gravar() {
		Scanner scanner = new Scanner(System.in);

		int CodigoFilme = scanner.nextInt();
		int CodigoSessao = scanner.nextInt();
		String dataString = scanner.next();
		Date HorarioSessao = null;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			HorarioSessao = (Date) dateFormat.parse(dataString);
		} catch (ParseException e) {
			System.out.println("Formato de data inválido!");
			scanner.close();
			return "Erro ao gravar filme";
		}
		scanner.nextLine();

		scanner.close();
		Sessao sessao = new Sessao();
		sessao.setCodigoFilme(CodigoFilme);
		sessao.setCodigoSessao(CodigoSessao);
		sessao.setHorarioSessao(HorarioSessao);
		sessaoRepository.save(sessao);
		return "Gravado";
	}
}
