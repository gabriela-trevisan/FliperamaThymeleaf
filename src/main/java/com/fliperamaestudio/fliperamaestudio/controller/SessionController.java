package com.fliperamaestudio.fliperamaestudio.controller;

import com.fliperamaestudio.fliperamaestudio.model.Usuario;
import com.fliperamaestudio.fliperamaestudio.security.UserPrincipal;
import com.fliperamaestudio.fliperamaestudio.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("usuario")
public class SessionController {




    private final UserService userService;

    public SessionController(UserService userService) {
        this.userService = userService;
    }






    @ModelAttribute("usuario")
    public Usuario usuario(){
        return new Usuario();
    }

    /*@GetMapping("session")
    public String retornaHome(){
        return "redirect:/login/autenticado";
    }*/


    @GetMapping("/session")
    public String salvaSession(@ModelAttribute("usuario") Usuario usuario) {
        UserPrincipal usr = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        var retorno = userService.findEmail(usr.getUsername());

        if (retorno != null){
            usuario.setNome(retorno.getNome());
            usuario.setTipo(retorno.getTipo());
            usuario.setIdUsuario(retorno.getIdUsuario());
        }



        return "redirect:/agendamento";
    }
}
