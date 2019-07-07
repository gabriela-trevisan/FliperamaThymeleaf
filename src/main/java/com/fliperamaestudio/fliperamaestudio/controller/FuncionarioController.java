package com.fliperamaestudio.fliperamaestudio.controller;


import com.fliperamaestudio.fliperamaestudio.model.Funcionario;
import com.fliperamaestudio.fliperamaestudio.model.Tipo;
import com.fliperamaestudio.fliperamaestudio.model.Usuario;
import com.fliperamaestudio.fliperamaestudio.repository.FuncionarioRepository;
import com.fliperamaestudio.fliperamaestudio.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("funcionario")
public class FuncionarioController {


    private final UserService userService;
    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioController(UserService userService, FuncionarioRepository funcionarioRepository) {
        this.userService = userService;
        this.funcionarioRepository = funcionarioRepository;
    }

    @GetMapping("/cadastroFuncionario")
    public String returnCadastroFuncionario(){
        return "cadastroFuncionario";
    }

    @PostMapping("/cadastroFuncionario")
    public String cadastrarFuncionario(@RequestParam String nome,
                                       @RequestParam String email,
                                       @RequestParam String endereco,
                                       @RequestParam double salario,
                                       @RequestParam String funcao,
                                       @RequestParam(required = false) String senha){


        var funcionario = new Funcionario(nome, email, senha, endereco, salario, funcao);

        funcionario.setTipo(Tipo.FUNC);

        Usuario retorno = userService.save(funcionario);

        if (retorno == null){
            return "cadastroFuncionario";

        }else {
            return "login";
        }

    }

    @GetMapping("listaFuncionarios")
    public String listarFuncionarios(Model model){

        List<Funcionario> funcionarios = funcionarioRepository.findAll();

        model.addAttribute("funcionarios", funcionarios);

        return "listaFuncionarios";
    }



    @PutMapping("/editarFuncionario")
    public String returnEditarFuncionario(@RequestParam int id, Model model){

        Optional<Funcionario> funcionario = funcionarioRepository.findById(id);



        model.addAttribute("funcionario", funcionario.get());


        return "editarFuncionario";
    }

    @PutMapping("/salvarFuncionario")
    public String editarFuncionario(@RequestParam String nome,
                                    @RequestParam String email,
                                    @RequestParam String endereco,
                                    @RequestParam int id,
                                    @RequestParam double salario,
                                    @RequestParam String funcao,
                                    @RequestParam String senha){


        var funcionario = new Funcionario(nome, email, senha, endereco, salario, funcao);
        funcionario.setIdUsuario(id);
        System.out.println(salario);

        userService.save(funcionario);

        return "redirect:listaFuncionarios";
    }

    @DeleteMapping("/deletarFuncionario")
    public String deletarFuncionario(@RequestParam int id){

        var funcionario = userService.find(id);

        userService.delete(funcionario);

        return "redirect:/editarFuncionario";


    }


}
