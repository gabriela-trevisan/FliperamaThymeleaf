package com.fliperamaestudio.fliperamaestudio.controller;


import com.fliperamaestudio.fliperamaestudio.DAO.ClienteDAO;
import com.fliperamaestudio.fliperamaestudio.model.Cliente;
import com.fliperamaestudio.fliperamaestudio.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cadastro")
public class CadastroController {

    @GetMapping
    public String returCadastro(){
        return "cadastro";
    }

    @PostMapping
    public String cadastraUsuario(@RequestParam String nome, String email, String senha){
        var cliente = new Cliente(nome, email, senha);

        boolean retorno = new ClienteDAO().cadastrarCliente(cliente);

        if (retorno){
            return "/";
        }else {
            return "cadastro";
        }

    }


}
