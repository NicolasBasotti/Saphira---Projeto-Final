package br.com.cinema.saphira.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cinema.saphira.model.Vendas;

public interface VendasRepository extends JpaRepository<Vendas,Integer> {

}
