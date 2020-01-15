package br.com.vipec.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.vipec.model.Professor;

/**
 * ProfessorRepository
 */
@Repository
public interface ProfessorRepository extends CrudRepository<Professor, String> {

    
}