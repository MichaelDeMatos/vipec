package br.com.vipec.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.vipec.model.Turma;

/**
 * TurmaRepository
 */
@Repository
public interface TurmaRepository extends CrudRepository<Turma, Integer> {

    
}