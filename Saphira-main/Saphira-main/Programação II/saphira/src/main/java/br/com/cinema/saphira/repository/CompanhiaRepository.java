package br.com.cinema.saphira.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cinema.saphira.model.Companhia;

public interface CompanhiaRepository extends JpaRepository<Companhia,Long> {

}
