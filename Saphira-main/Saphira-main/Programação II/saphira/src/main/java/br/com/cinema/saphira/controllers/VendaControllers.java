package br.com.cinema.saphira.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.cinema.saphira.model.Vendas;
import br.com.cinema.saphira.repository.VendasRepository;

public class VendaControllers {
	
	@Autowired
	private VendasRepository vendaRepository;
	
	 /**
     * Lista todas as vendas registradas.
     * @return ResponseEntity contendo a lista de vendas e o status HTTP.
     */
	
	@PostMapping(value = "listar")
	@ResponseBody
	public ResponseEntity<List<Vendas>> listarFilmes() {
		List<Vendas> vendas = vendaRepository.findAll();
		return new ResponseEntity<List<Vendas>>(vendas, HttpStatus.OK);
	}
	
	  /**
     * Salva uma nova venda.
     * @param vendas o objeto do tipo Vendas a ser salvo.
     * @return ResponseEntity com a venda criada e o status HTTP.
     */
	
	@PostMapping(value = "salvar")
	@ResponseBody
	public ResponseEntity<Vendas> salvar(@RequestBody Vendas vendas) {
		Vendas ven = vendaRepository.save(vendas);
		return new ResponseEntity<Vendas>(ven, HttpStatus.CREATED);
	}
}
