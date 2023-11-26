package br.com.cinema.saphira.controllers;

import java.util.List;

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

import br.com.cinema.saphira.model.Cliente;
import br.com.cinema.saphira.repository.ClienteRepository;

@RestController
@RequestMapping("/Cliente")
public class ClienteControllers {
	@Autowired
	private ClienteRepository clienteRepository;
	
	/**
	 * Lista os cliente
	 * @return retorna a lista de clientes
	 */
	
	@PostMapping(value = "listar")
	@ResponseBody
	public ResponseEntity<List<Cliente>> listarClientes() {
		List<Cliente> clientes = clienteRepository.findAll();
		return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
	}
	
	/**
	 * Cria um novo cliente
	 * @return retorna o novo cliente
	 */
	
	@PostMapping(value = "Criar")
	@ResponseBody
	public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente) {
		Cliente cli = clienteRepository.save(cliente);
		return new ResponseEntity<Cliente>(cli, HttpStatus.CREATED);
	}
	
	/**
	 * Deleta um cliente
	 * @return retorna a mensagem "Cliente excluido com sucesso"
	 */
	

	@DeleteMapping(value = "deletar")
	@ResponseBody
	public ResponseEntity<String> delete(@RequestParam Integer codCliente) {
		clienteRepository.deleteById(codCliente);;
		return new ResponseEntity<String>("Cliente excluido com sucesso", HttpStatus.OK);
	}
	
	/**
	 * Busca um cliente
	 * @return retorna a lista de busca
	 */
	
	@GetMapping(value = "buscarCliente")
	@ResponseBody
	public ResponseEntity<Cliente> buscarCliente(@RequestParam(name = "codCliente") Integer codCliente) {
		Cliente cliente = clienteRepository.findById(codCliente).get();
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}

	/**
	 * Atualiza as informações de um cliente
	 * @return Retorna a atualização do cliente
	 */
	
	
	@PutMapping(value = "atualizar")
	@ResponseBody
	public ResponseEntity<?> atualizar(@RequestBody Cliente cliente) {
		if (cliente.getCodigoCliente() == null) {
			return new ResponseEntity<String>("Id não informado para atualizar", HttpStatus.OK);
		}
		Cliente cli = clienteRepository.saveAndFlush(cliente);
		return new ResponseEntity<Cliente>(cli, HttpStatus.OK);
	}
	
}
