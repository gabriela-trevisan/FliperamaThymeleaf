package com.fliperamaestudio.fliperamaestudio.controller;


import com.fliperamaestudio.fliperamaestudio.model.Usuario;
import com.fliperamaestudio.fliperamaestudio.security.UserPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final UserPrincipal userPrincipal;

    public LoginController(UserPrincipal userPrincipal) {
        this.userPrincipal = userPrincipal;
    }

    @GetMapping
    public String returnLogin(){

        return "login";
    }

    @PostMapping
    public String autenticarUsuario(@RequestParam String email, @RequestParam String senha) {

        var usuario = new Usuario(email, senha);

        Usuario retorno = userPrincipal.

    }

   /* @PostMapping
    public String autenticaUsuario(@RequestParam String nome, String senha, Model model){
        var usuario = new Usuario(nome, new BCryptPasswordEncoder().encode(senha));

        boolean retorno = new UsuarioDAO().autenticarUsuario(usuario);

        if (retorno){
            return "index";
        }else{
            return "login";
        }

    }*/

}
