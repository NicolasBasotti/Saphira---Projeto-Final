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

import br.com.cinema.saphira.model.Funcionario;
import br.com.cinema.saphira.repository.FuncionarioRepository;
@RestController
@RequestMapping("/Funcionario")
public class FuncionarioControllers {
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	
	/**
	 * Lista todos os Funcionarios.
	 * @return ResponseEntity contendo a lista de funcionarios e o status HTTP.
	 */
	
	@PostMapping(value = "listar")
	@ResponseBody
	public ResponseEntity<List<Funcionario>> listarFuncionario() {
		List<Funcionario> funcionario = funcionarioRepository.findAll();
		return new ResponseEntity<List<Funcionario>>(funcionario, HttpStatus.OK);
	}
	
	/**
	 * Salva um novo fuincionario.
	 * @return retona o novo funcionario.
	 */
	
	
	@PostMapping(value = "salvar")
	@ResponseBody
	public ResponseEntity<Funcionario> salvar(@RequestBody Funcionario funcionario) {
		Funcionario fun = funcionarioRepository.save(funcionario);
		return new ResponseEntity<Funcionario>(fun, HttpStatus.CREATED);
	}
	
	/**
	 * Deleta um fuincionario.
	 * @return retona o delete do funcionario.
	 */

	@DeleteMapping(value = "deletar")
	@ResponseBody
	public ResponseEntity<String> delete(@RequestParam Integer codfuncionario) {
		funcionarioRepository.deleteById(codfuncionario);
		return new ResponseEntity<String>("Funcionario excluido com sucesso", HttpStatus.OK);
	}
	
	/**
	 * Busca um funcionario
	 * @return retorna a lista de busca dos funcionarios
	 */
	
	@GetMapping(value = "buscarFuncionario")
	@ResponseBody
	public ResponseEntity<Funcionario> buscarFuncionario(@RequestParam(name = "codfuncionario") Integer codfuncionario) {
		Funcionario funcionario = funcionarioRepository.findById(codfuncionario).get();
		return new ResponseEntity<Funcionario>(funcionario, HttpStatus.OK);
	}

	
	/**
	 * Atualiza um Funcionario
	 * @return retorna a  atualização do funcionario
	 */
	
	@PutMapping(value = "atualizar")
	@ResponseBody
	public ResponseEntity<?> atualizar(@RequestBody Funcionario funcionario) {
		if (funcionario.getCodigoFuncionario()== null) {
			return new ResponseEntity<String>("Id não informado para atualizar", HttpStatus.OK);
		}
		Funcionario fun = funcionarioRepository.saveAndFlush(funcionario);
		return new ResponseEntity<Funcionario>(fun, HttpStatus.OK);
	}
	
	@GetMapping(path = "cria")
	public String Gravar() {
		Scanner scanner = new Scanner(System.in);

        int codigoFuncionario = scanner.nextInt();
        double cpfFuncionario = scanner.nextDouble();
        int cargahorariaFuncionario = scanner.nextInt();
        int codigoCinema = scanner.nextInt();
        String dataString = scanner.next();
        Date dataAdmissao = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dataAdmissao = (Date) dateFormat.parse(dataString);
        } catch (ParseException e) {
            System.out.println("Formato de data inválido!");
            scanner.close();
            return "Erro ao gravar filme";
        }
        scanner.nextLine();
        Date dataNasc = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dataNasc = (Date) dateFormat.parse(dataString);
        } catch (ParseException e) {
            System.out.println("Formato de data inválido!");
            scanner.close();
            return "Erro ao gravar filme";
        }
        scanner.nextLine();
        String nomeFuncionario = scanner.nextLine();
        int telefoneFuncionario = scanner.nextInt();

        scanner.close();
		Funcionario funcionario = new Funcionario();
		funcionario.setCargaHoraria(cargahorariaFuncionario);
		funcionario.setCodigoCinema(codigoCinema);
		funcionario.setCodigoFuncionario(codigoFuncionario);
		funcionario.setCpfFuncionario(cpfFuncionario);
		funcionario.setDataAdmissao(dataAdmissao);
		funcionario.setDataNascimento(dataNasc);
		funcionario.setNomeFuncionario(nomeFuncionario);
		funcionario.setTelefoneFuncionario(telefoneFuncionario);
		
		funcionarioRepository.save(funcionario);
		return "Gravado";
	}
}
