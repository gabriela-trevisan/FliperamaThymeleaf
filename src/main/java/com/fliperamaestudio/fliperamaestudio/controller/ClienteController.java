package com.fliperamaestudio.fliperamaestudio.controller;


import com.fliperamaestudio.fliperamaestudio.model.Cliente;
import com.fliperamaestudio.fliperamaestudio.model.Tipo;
import com.fliperamaestudio.fliperamaestudio.model.Usuario;
import com.fliperamaestudio.fliperamaestudio.repository.ClienteRepository;
import com.fliperamaestudio.fliperamaestudio.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("cliente")
@SessionAttributes("usuario")
public class ClienteController {
    private final UserService userService;
    private final ClienteRepository clienteRepository;

    public ClienteController(UserService userService, ClienteRepository clienteRepository) {
        this.userService = userService;
        this.clienteRepository = clienteRepository;
    }

    @GetMapping("editarCliente")
    public String retornEditarCliente(@SessionAttribute("usuario")Usuario usuarioSession, Model model){

        Optional<Cliente> clienteOptional = clienteRepository.findById(usuarioSession.getIdUsuario());

        model.addAttribute("cliente", clienteOptional.get());

        return "editarCliente";
    }


    @PostMapping("editar")
    public String cadastraUsuario(@RequestParam String nome,
                                  @RequestParam String email,
                                  @RequestParam(required = false) String senha,
                                  @RequestParam String telefone,
                                  @SessionAttribute("usuario") Usuario usuarioSession ) {



            var cliente = new Cliente(nome, email, senha, telefone);
            cliente.setIdUsuario(usuarioSession.getIdUsuario());
            cliente.setTipo(Tipo.CLI);
            Usuario retorno = userService.save(cliente);









        return "redirect:editarCliente";

    }

    @PostMapping("/excluir")
    public String deletarCliente(@RequestParam int id){

        var cliente = userService.find(id);

        userService.delete(cliente);

        return "redirect:/logout";


    }


}
