package com.fliperamaestudio.fliperamaestudio.controller;


public class LoginControllerDead {







    /*private final UserPrincipal userPrincipal;

    public LoginController(UserPrincipal userPrincipal) {
        this.userPrincipal = userPrincipal;
    }*/



   /* @GetMapping("/autenticado")
    public String insereUsuarioSession(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

       UserPrincipal user = (UserPrincipal) authentication.getPrincipal();
       System.out.println(user.getUsername());

        return "index";

    }*/







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
