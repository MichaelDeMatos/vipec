package br.com.vipec.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.vipec.model.Responsavel;

/**
 * ResponsavelRepository
 */
@Repository
public interface ResponsavelRepository extends CrudRepository<Responsavel, Integer> {

}