package br.com.vipec.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.vipec.model.Professor;

/**
 * ProfessorRepository
 */
public interface ProfessorRepository extends CrudRepository<Professor, String> {

    
}