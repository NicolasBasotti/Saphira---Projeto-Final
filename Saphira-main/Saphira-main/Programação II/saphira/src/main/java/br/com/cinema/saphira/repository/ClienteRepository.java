package br.com.cinema.saphira.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cinema.saphira.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Integer> {

}
