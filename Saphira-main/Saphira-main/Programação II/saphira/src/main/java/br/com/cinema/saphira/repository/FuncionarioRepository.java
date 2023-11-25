package br.com.cinema.saphira.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cinema.saphira.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario,Long> {

}
