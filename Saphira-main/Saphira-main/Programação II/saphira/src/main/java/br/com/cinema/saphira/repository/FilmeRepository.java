package br.com.cinema.saphira.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cinema.saphira.model.Filme;

public interface FilmeRepository extends JpaRepository<Filme,Integer> {

}
