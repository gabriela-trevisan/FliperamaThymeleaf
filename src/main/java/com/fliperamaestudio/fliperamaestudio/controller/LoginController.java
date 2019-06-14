package com.fliperamaestudio.fliperamaestudio.controller;


import com.fliperamaestudio.fliperamaestudio.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
@SessionAttributes("usuario")
public class LoginController {


    @ModelAttribute("usuario")
    public Usuario usuario(){
        return new Usuario();
    }

    /*private final UserPrincipal userPrincipal;

    public LoginController(UserPrincipal userPrincipal) {
        this.userPrincipal = userPrincipal;
    }*/

    @GetMapping
    public String returnLogin(@ModelAttribute Usuario usuario){

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
    public String bbb(@ModelAttribute Usuario usuario){
       System.out.println(usuario.getNome());
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
