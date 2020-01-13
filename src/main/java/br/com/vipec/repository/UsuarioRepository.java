package br.com.vipec.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.vipec.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

    List<Usuario> findAll();
}
