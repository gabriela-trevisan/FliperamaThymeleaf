package com.fliperamaestudio.fliperamaestudio.controller;


import com.fliperamaestudio.fliperamaestudio.DAO.UsuarioDAO;
import com.fliperamaestudio.fliperamaestudio.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String returnHome(Model model){

        model.addAttribute("usuario", new UsuarioDAO().retornarUsuario(new Usuario("a", "aa")));
        return "index";
    }


}
