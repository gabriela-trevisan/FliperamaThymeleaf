package com.fliperamaestudio.fliperamaestudio.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/agendamento")
public class BuscaAgendamento {

    @GetMapping("/proximo")
    public String consultarProximoDia(@RequestParam String data){


        return "redirect:/agendamento?data=" + LocalDateTime.parse(data).plusDays(1);
    }

    @GetMapping("/anterior")
    public String consultarDiaAnterior(@RequestParam String data){

        return "redirect:/agendamento?data=" + LocalDateTime.parse(data).minusDays(1);
    }
}
