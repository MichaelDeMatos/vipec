package br.com.vipec.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.vipec.model.Aluno;

/**
 * AlunoRepository
 */
@Repository
public interface AlunoRepository extends CrudRepository<Aluno, Integer> {

    List<Aluno> findAll();
}