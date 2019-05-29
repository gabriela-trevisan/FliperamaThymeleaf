package com.fliperamaestudio.fliperamaestudio.controller;


import com.fliperamaestudio.fliperamaestudio.DAO.AgendamentoDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/agendamento")
public class AgendamentoController {


    @GetMapping
    public String returnAgendaDia (Model model){

            model.addAttribute("agendamentos",new AgendamentoDAO().getAgendamentos(LocalDateTime.now()));



        
        return "agendamento";
    }
}
