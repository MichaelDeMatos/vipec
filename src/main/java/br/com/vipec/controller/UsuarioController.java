package br.com.vipec.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.vipec.model.Usuario;
import br.com.vipec.repository.UsuarioRepository;

@Controller
@RequestMapping(path = "/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	
	@GetMapping("/mostraFormUsuario")
    public String mostraFormUsuario(Usuario usuario) {
		// Usuario usuario = new Usuario();
		// model.addAttribute("usuario", usuario);

        return "usuarioForm";
    }

	@PostMapping
	public String salvaNovoUsuario(@Valid Usuario usuario, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "usuarioForm";
		}

		usuarioRepository.save(usuario);
		model.addAttribute("usuarios", usuarioRepository.findAll());
		return "usuarioForm";
	}

	@GetMapping("/{id}")
	public String mostraFormAtualizar(@PathVariable("id") int id, Model model) {
		Usuario user = usuarioRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Id de usuário inválido:" + id));

		model.addAttribute("usuario", user);
		return "update-user";
	}

	@GetMapping
	public String listaTodosUsuarios(Model model) {

		List<Usuario> listaUsuarios = new ArrayList<Usuario>();

		listaUsuarios = usuarioRepository.findAll();
		model.addAttribute("usuarios", listaUsuarios);
		System.out.println(listaUsuarios);

		return "login";

	}

	@PutMapping("/{id}")
	public String atualizaUsuario(@PathVariable("id") int id, @Valid Usuario user, BindingResult result, Model model) {

		if (result.hasErrors()) {
			user.setId(id);
			return "update-user";
		}

		usuarioRepository.save(user);
		model.addAttribute("usuarios", usuarioRepository.findAll());
		return "index";
	}

	@DeleteMapping("/{id}")
	public String deletaUsuario(@PathVariable("id") int id, Model model) {
		Usuario user = usuarioRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Id de usuário inválido:" + id));
		usuarioRepository.delete(user);
		model.addAttribute("usuarios", usuarioRepository.findAll());
		return "index";
	}

}
