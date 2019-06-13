package com.fliperamaestudio.fliperamaestudio.controller;


import com.fliperamaestudio.fliperamaestudio.model.Usuario;
import com.fliperamaestudio.fliperamaestudio.repository.UserRepository;
import com.fliperamaestudio.fliperamaestudio.security.UserPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
public class LoginController {




    /*@ModelAttribute(name = "usuario")
    public Usuario usuario(){
        return new Usuario();
    }*/

    /*private final UserPrincipal userPrincipal;

    public LoginController(UserPrincipal userPrincipal) {
        this.userPrincipal = userPrincipal;
    }*/

    @GetMapping
    public String returnLogin(){

        return "login";
    }

    @GetMapping("/autenticado")
    public String insereUsuarioSession(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

       UserPrincipal user = (UserPrincipal) authentication.getPrincipal();
       System.out.println(user.getUsername());

        return "index";

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
