package br.com.vipec.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.vipec.model.Aluno;
import br.com.vipec.repository.AlunoRepository;

@Controller
@RequestMapping(path = "/aluno")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

	@GetMapping("/cadastrar")
    public ModelAndView formCadastrar(Aluno aluno, ModelMap model) {
		// Aluno aluno = new Aluno();
		model.addAttribute("aluno", aluno);
		model.addAttribute("template", "/views/aluno/form");
		model.addAttribute("fragment", "aluno-form");
		model.addAttribute("title", "title");

		System.out.println(model);


        return new ModelAndView("/layout/layout", model);
	}

    @GetMapping
	public ModelAndView listarTodos(ModelMap model) {

		List<Aluno>listaAlunos = new ArrayList<Aluno>();

		listaAlunos = alunoRepository.findAll();
		model.addAttribute("alunos", listaAlunos);
		System.out.println(listaAlunos);
		model.addAttribute("template", "/views/aluno/list");
		model.addAttribute("fragment", "corpo");
		model.addAttribute("title", "title");

		return new ModelAndView("/layout/layout", model);

	}

    

}
