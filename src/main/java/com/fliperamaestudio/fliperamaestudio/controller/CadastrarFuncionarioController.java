package com.fliperamaestudio.fliperamaestudio.controller;


import com.fliperamaestudio.fliperamaestudio.model.Funcionario;
import com.fliperamaestudio.fliperamaestudio.model.Tipo;
import com.fliperamaestudio.fliperamaestudio.model.Usuario;
import com.fliperamaestudio.fliperamaestudio.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cadastroFuncionario")
public class CadastrarFuncionarioController {

    private final UserService userService;

    public CadastrarFuncionarioController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String returnCadastroFuncionario(){
        return "cadastroFuncionario";
    }

    @PostMapping
    public String cadastrarFuncionario(@RequestParam String nome,
                                       @RequestParam String email,
                                       @RequestParam String endereco,
                                       @RequestParam double salario,
                                       @RequestParam String funcao,
                                       @RequestParam String senha){


        var funcionario = new Funcionario(nome, email, senha, endereco, salario, funcao);

        funcionario.setTipo(Tipo.FUNC);

        Usuario retorno = userService.save(funcionario);

        if (retorno == null){
            return "cadastroFuncionario";

        }else {
            return "login";
        }

    }
}
