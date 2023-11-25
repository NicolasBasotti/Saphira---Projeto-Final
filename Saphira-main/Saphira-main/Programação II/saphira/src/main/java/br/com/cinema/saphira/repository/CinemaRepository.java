package br.com.cinema.saphira.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cinema.saphira.model.Cinema;

public interface CinemaRepository extends JpaRepository<Cinema,Long> {

}
