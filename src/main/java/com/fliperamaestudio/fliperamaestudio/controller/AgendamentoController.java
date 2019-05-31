package com.fliperamaestudio.fliperamaestudio.controller;


import com.fliperamaestudio.fliperamaestudio.DAO.AgendamentoDAO;
import com.fliperamaestudio.fliperamaestudio.DAO.UsuarioDAO;
import com.fliperamaestudio.fliperamaestudio.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/agendamento")
public class AgendamentoController {


    @GetMapping
    public String returnAgendaDia( @RequestParam(defaultValue = "0") int dia, Model model) {
        System.out.println(dia);
        if(dia > 0){

            model.addAttribute("agendamentos", new AgendamentoDAO().getAgendamentos(LocalDateTime.parse("2019-06-" + dia + "T18:00")));


        }else{
            model.addAttribute("agendamentos", new AgendamentoDAO().getAgendamentos(LocalDateTime.now()));
            model.addAttribute( "usuario" ,new UsuarioDAO().retornarUsuario(new Usuario("joao","1234")));
        }






        return "agendamento";
    }
}
