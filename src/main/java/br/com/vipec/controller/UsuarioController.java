package br.com.vipec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.vipec.model.Usuario;
import br.com.vipec.repository.UsuarioRepository;

@RestController
@RequestMapping(path = "/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	 @PostMapping// Map ONLY POST Requests
	  public String addNewUser (@RequestParam String name
	      , @RequestParam String email) {
	    // @ResponseBody means the returned String is the response, not a view name
	    // @RequestParam means it is a parameter from the GET or POST request

	    Usuario n = new Usuario();
	    n.setNome(name);
	    n.setEmail(email);
	    usuarioRepository.save(n);
	    return "Saved";
	  }

	  @GetMapping
	  public Iterable<Usuario> getAllUsers() {
	    // This returns a JSON or XML with the users
	    return usuarioRepository.findAll();
	  }
	
	
}
