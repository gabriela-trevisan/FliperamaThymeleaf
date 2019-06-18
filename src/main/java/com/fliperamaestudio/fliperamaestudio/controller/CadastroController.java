package com.fliperamaestudio.fliperamaestudio.controller;


import com.fliperamaestudio.fliperamaestudio.model.Cliente;
import com.fliperamaestudio.fliperamaestudio.model.Tipo;
import com.fliperamaestudio.fliperamaestudio.model.Usuario;
import com.fliperamaestudio.fliperamaestudio.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cadastro")
public class CadastroController {

    private final UserService userService;

    public CadastroController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public String returCadastro(){
        return "cadastro";
    }

    @PostMapping
    public String cadastraUsuario(@RequestParam String nome,
                                  @RequestParam String email,
                                  @RequestParam String senha,
                                  @RequestParam String telefone){


        var cliente = new Cliente(nome, email, senha, telefone);

        cliente.setTipo(Tipo.CLI);

        Usuario retorno = userService.save(cliente);

        if (retorno ==  null){
            return "cadastro";
        } else {
            return "login";
        }

    }


}
