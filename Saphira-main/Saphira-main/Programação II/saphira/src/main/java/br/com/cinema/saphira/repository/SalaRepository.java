package br.com.cinema.saphira.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cinema.saphira.model.Sala;

public interface SalaRepository extends JpaRepository<Sala,Long>  {

}
