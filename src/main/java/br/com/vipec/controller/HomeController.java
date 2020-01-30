package br.com.vipec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * HomeController
 */
@Controller
@RequestMapping(path = "/")
public class HomeController {
    @GetMapping
    public String home() {

        return "redirect:/login";
    }

    @GetMapping("home")
    public String showLoginForm(Model model) {

        return "layout/layout";
    }


    
}
