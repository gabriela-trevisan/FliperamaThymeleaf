package com.fliperamaestudio.fliperamaestudio.controller;


import com.fliperamaestudio.fliperamaestudio.model.Funcionario;
import com.fliperamaestudio.fliperamaestudio.model.Tipo;
import com.fliperamaestudio.fliperamaestudio.model.Usuario;
import com.fliperamaestudio.fliperamaestudio.repository.FuncionarioRepository;
import com.fliperamaestudio.fliperamaestudio.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String cadastrarFuncionario(Funcionario funcionario){


       // var funcionario = new Funcionario(nome, email, senha, endereco, salario, funcao);

        funcionario.setTipo(Tipo.FUNC);

        Usuario retorno = userService.save(funcionario);

        if (retorno == null){
            return "cadastroFuncionario";

        }else {
            return "redirect:listaFuncionarios";
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

    @PostMapping("/salvarFuncionario")
    public String editarFuncionario(Funcionario funcionario){


//        var funcionario = new Funcionario(nome, email, senha, endereco, salario, funcao);
  //      funcionario.setIdUsuario(id);
        funcionario.setTipo(Tipo.FUNC);


        userService.save(funcionario);

        return "redirect:listaFuncionarios";
    }

    @PostMapping("/deletarFuncionario")
    public String deletarFuncionario(@RequestParam int id){

        var funcionario = userService.find(id);

        userService.delete(funcionario);

        return "redirect:listaFuncionarios";


    }


}
