package com.fliperamaestudio.fliperamaestudio.controller;


import com.fliperamaestudio.fliperamaestudio.model.Usuario;
import com.fliperamaestudio.fliperamaestudio.security.UserPrincipal;
import com.fliperamaestudio.fliperamaestudio.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
@SessionAttributes("usuario")
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }




    /*private final UserPrincipal userPrincipal;

    public LoginController(UserPrincipal userPrincipal) {
        this.userPrincipal = userPrincipal;
    }*/

    @GetMapping
    public String returnLogin() {

        return "login";
    }

   /* @GetMapping("/autenticado")
    public String insereUsuarioSession(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

       UserPrincipal user = (UserPrincipal) authentication.getPrincipal();
       System.out.println(user.getUsername());

        return "index";

    }*/




    @GetMapping("/autenticado")
    public String salvaSession(@ModelAttribute("usuario") Usuario usuario, Model model) {
        UserPrincipal usr = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        var retorno = userService.findEmail(usr.getUsername());

        if (retorno != null){
            usuario.setNome(retorno.getNome());
            usuario.setTipo(retorno.getTipo());
            usuario.setIdUsuario(retorno.getIdUsuario());
        }



        return "redirect:/agendamento";
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
