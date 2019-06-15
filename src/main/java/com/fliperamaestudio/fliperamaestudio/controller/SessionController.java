package com.fliperamaestudio.fliperamaestudio.controller;

import com.fliperamaestudio.fliperamaestudio.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("usuario")
public class SessionController {

    @ModelAttribute("usuario")
    public Usuario usuario(){
        return new Usuario();
    }

    @GetMapping("session")
    public String retornaHome(){
        return "redirect:/login/autenticado";
    }
}
