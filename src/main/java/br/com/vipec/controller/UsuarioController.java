package br.com.vipec.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.vipec.model.Usuario;
import br.com.vipec.repository.UsuarioRepository;

@Controller
@RequestMapping(path = "/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	
	@GetMapping("/cadastrar")
    public ModelAndView formCadastrar(Usuario usuario) {
		// Usuario usuario = new Usuario();
		// model.addAttribute("usuario", usuario);

        return new ModelAndView("/views/usuario/form");
	}
	
	
	@GetMapping("/editar/{id}")
	public ModelAndView formEditar(@PathVariable("id") int id, ModelMap model) {
		Usuario user = usuarioRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Id de usuário inválido:" + id));

		model.addAttribute("usuario", user);
		return new ModelAndView("/views/usuario/form");
	}


	@PostMapping("/salvar")
	public ModelAndView salvar(@Valid Usuario usuario, BindingResult result, ModelMap model) {
		System.out.println("Salvar");

		if (result.hasErrors()) {
			return new ModelAndView("/views/usuario/form");
		}

		usuarioRepository.save(usuario);
		return new ModelAndView("redirect:/usuario");
	}


	@GetMapping
	public ModelAndView listarTodos(ModelMap model) {

		List<Usuario> listaUsuarios = new ArrayList<Usuario>();

		listaUsuarios = usuarioRepository.findAll();
		model.addAttribute("usuarios", listaUsuarios);
		System.out.println(listaUsuarios);

		return new ModelAndView("/views/usuario/list");

	}

	@PostMapping("/atualizar")
	public ModelAndView atualizar(@Valid Usuario usuario, BindingResult result) {

		if (result.hasErrors()) {
			return new ModelAndView("/views/usuario/form");
		}

		usuarioRepository.save(usuario);
		return new ModelAndView("redirect:/usuario");
	}

	@GetMapping("deletar/{id}")
	public String deletar(@PathVariable("id") int id) {
		Usuario usuario = usuarioRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Id de usuário inválido:" + id));
		usuarioRepository.delete(usuario);
		return "redirect:/usuario";
	}

}
