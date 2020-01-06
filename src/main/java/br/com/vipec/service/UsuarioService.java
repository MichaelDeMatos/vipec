package br.com.vipec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vipec.model.Usuario;
import br.com.vipec.repository.UsuarioRepository;

/**
 * UsuarioService
 */
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository rep;
    

    public List<Usuario> testeUsuario() {
        return rep.findAll();
        
    }
}