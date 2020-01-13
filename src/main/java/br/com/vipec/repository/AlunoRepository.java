package br.com.vipec.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.vipec.model.Aluno;

/**
 * AlunoRepository
 */
public interface AlunoRepository extends CrudRepository<Aluno, Integer> {

    List<Aluno> findAll();
}