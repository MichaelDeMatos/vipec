package br.com.vipec.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.vipec.model.Usuario;
import br.com.vipec.repository.UsuarioRepository;

@Controller
@RequestMapping(path = "/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@PostMapping
	public String addNewUser(@Valid Usuario user, BindingResult result, Model model) {
		
		if (result.hasErrors()) {
            return "add-user";
        }

		model.addAttribute("users", usuarioRepository.findAll());
		usuarioRepository.save(user);
		return "index";
	}

	@GetMapping
	public Iterable<Usuario> getAllUsers() {
		// This returns a JSON or XML with the users
		return usuarioRepository.findAll();
	}

}
