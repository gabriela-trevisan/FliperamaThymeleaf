package com.fliperamaestudio.fliperamaestudio.controller;


import com.fliperamaestudio.fliperamaestudio.DAO.UsuarioDAO;
import com.fliperamaestudio.fliperamaestudio.model.Usuario;
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
    public String autenticaUsuario(@RequestParam String nome, String senha, Model model){
        var usuario = new Usuario(nome, senha);

        boolean retorno = new UsuarioDAO().autenticarUsuario(usuario);

        if (retorno){
            return "/";
        }else{
            return "login";
        }

    }

}
