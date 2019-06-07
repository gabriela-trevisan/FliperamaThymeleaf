package com.fliperamaestudio.fliperamaestudio.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public String returnLogin(){
        return "login";
    }

    @PostMapping
    public String autenticaUsuario(@RequestParam(required = false) String nome, String senha, Model model){

        if (nome == null || senha == null){

            //model.addAttribute("alerta", "alert('nome ou senha incorretos");

            return "login";



        }else{

            return "/";
        }

    }

}
