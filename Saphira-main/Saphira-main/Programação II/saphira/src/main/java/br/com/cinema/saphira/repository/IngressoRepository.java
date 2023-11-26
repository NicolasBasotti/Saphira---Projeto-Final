package br.com.cinema.saphira.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cinema.saphira.model.Ingresso;

public interface IngressoRepository extends JpaRepository<Ingresso,Integer> {

}
