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

import br.com.cinema.saphira.model.Filme;
import br.com.cinema.saphira.repository.FilmeRepository;

@RestController
@RequestMapping("/Filmes")
public class FilmeControllers {
	
	@Autowired
	private FilmeRepository filmeRepository;
	
	/**
	 * Lista todos os filmes cadastrados.
	 * @return ResponseEntity contendo a lista de filmes e o status HTTP.
	 */
	
	@PostMapping(value = "listar")
	@ResponseBody
	public ResponseEntity<List<Filme>> listarFilmes() {
		List<Filme> filmes = filmeRepository.findAll();
		return new ResponseEntity<List<Filme>>(filmes, HttpStatus.OK);
	}
	
	/**
	 * Salva um novo filme
	 * @return retorna o novo filme salvo
	 */
	
	@PostMapping(value = "salvar")
	@ResponseBody
	public ResponseEntity<Filme> salvar(@RequestBody Filme filme) {
		Filme fil = filmeRepository.save(filme);
		return new ResponseEntity<Filme>(fil, HttpStatus.CREATED);
	}
	
	/**
	 * Deleta um filme
	 * @return retorna o delete do filme 
	 */

	@DeleteMapping(value = "deletar")
	@ResponseBody
	public ResponseEntity<String> delete(@RequestParam Integer codfilme) {
		filmeRepository.deleteById(codfilme);;
		return new ResponseEntity<String>("Filme excluido com sucesso", HttpStatus.OK);
	}
	
	/**
	 * Busca um filme
	 * @return retorna a lista de busca
	 */
	
	@GetMapping(value = "buscarFilme")
	@ResponseBody
	public ResponseEntity<Filme> buscarFilme(@RequestParam(name = "codfilme") Integer codfilme) {
		Filme filme = filmeRepository.findById(codfilme).get();
		return new ResponseEntity<Filme>(filme, HttpStatus.OK);
	}
	
	/**
	 * Atualiza um filme
	 * @return retorna a  atualização do filme
	 */

	@PutMapping(value = "atualizar")
	@ResponseBody
	public ResponseEntity<?> atualizar(@RequestBody Filme filme) {
		if (filme.getCodigoFilme() == null) {
			return new ResponseEntity<String>("Id não informado para atualizar", HttpStatus.OK);
		}
		Filme fil = filmeRepository.saveAndFlush(filme);
		return new ResponseEntity<Filme>(fil, HttpStatus.OK);
	}
	
	/*
	 * Cria um novo filme através da entrada do console.
	 * @return mensagem indicando se a operação foi realizada com sucesso.
	 */
	
	@GetMapping(path = "cria")
	public String Gravar() {
		Scanner scanner = new Scanner(System.in);

        int codigoFilme = scanner.nextInt();
        double codigoAvaliacao = scanner.nextDouble();
        int codigoClassificacao = scanner.nextInt();
        int codigoCompanhia = scanner.nextInt();
        int codigoGenero = scanner.nextInt();
        String dataString = scanner.next();
        Date dataLancamento = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dataLancamento = (Date) dateFormat.parse(dataString);
        } catch (ParseException e) {
            System.out.println("Formato de data inválido!");
            scanner.close();
            return "Erro ao gravar filme";
        }
        scanner.nextLine();
        String generoFilme = scanner.nextLine();
        String nomeFilme = scanner.nextLine();
        int tempoDuracao = scanner.nextInt();

        scanner.close();
		Filme filme = new Filme();
		filme.setCodigoFilme(codigoFilme);
		filme.setCodigoAvaliacao(codigoAvaliacao);
		filme.setCodigoClassificao(codigoClassificacao);
		filme.setCodigoCompanhia(codigoCompanhia);
		filme.setCodigoGenero(codigoGenero);
		filme.setDataLancamento(dataLancamento);
		filme.setGeneroFilme(generoFilme);
		filme.setNomeFilme(nomeFilme);
		filme.setTempoDuracao(tempoDuracao);
		filmeRepository.save(filme);
		return "Gravado";
	}
	
}
