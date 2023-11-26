package br.com.cinema.saphira.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cinema.saphira.model.Sessao;

public interface SessaoRepository extends JpaRepository<Sessao,Integer> {
	
}
