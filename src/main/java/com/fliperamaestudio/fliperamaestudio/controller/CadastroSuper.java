package com.fliperamaestudio.fliperamaestudio.controller;

import com.fliperamaestudio.fliperamaestudio.model.Tipo;
import com.fliperamaestudio.fliperamaestudio.model.Usuario;
import com.fliperamaestudio.fliperamaestudio.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("cadastroSuper")
public class CadastroSuper {

    private final UserService userService;

    public CadastroSuper(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String retornaSuper() {
        return "cadastroSuper";
    }

    @PostMapping
    public String cadastraSuper(@RequestParam String nome,
                                @RequestParam String email,
                                @RequestParam String senha) {


        var usuario = new Usuario(nome, email, senha);


        usuario.setTipo(Tipo.SUPER);

        Usuario retorno = userService.save(usuario);

        if (retorno == null) {
            return "cadastro";
        } else {
            return "login";
        }

    }

}
