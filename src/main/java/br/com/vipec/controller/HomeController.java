package br.com.vipec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * HomeController
 */
@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {

        return "redirect:/usuario/cadastrar";
    }
    
}
