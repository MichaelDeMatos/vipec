package br.com.vipec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * LoginController
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @GetMapping
    public String showLoginForm(Model model) {

        return "views/login";
    }
}