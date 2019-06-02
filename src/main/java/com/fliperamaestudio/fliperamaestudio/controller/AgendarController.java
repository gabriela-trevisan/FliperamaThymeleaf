package com.fliperamaestudio.fliperamaestudio.controller;

import com.fliperamaestudio.fliperamaestudio.model.Agendamento;
import com.fliperamaestudio.fliperamaestudio.model.DataHora;
import com.fliperamaestudio.fliperamaestudio.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/agendar")
public class AgendarController {

    @GetMapping("/agendar")
    public String agendarHora(@RequestParam int ano,
                              @RequestParam int mes,
                              @RequestParam int dia,
                              @RequestParam int hora, Model model){

        DataHora dataHora = new DataHora(ano, mes, dia, hora);


        try {

            model.addAttribute("data", dataHora);

            new AgendarController().agendarHora( new Agendamento( new Usuario(id, nome), dataHora.getDataHora() ) );

            return "agendamento";

        }catch (Exception e){

            e.printStackTrace();

            model.addAttribute("data", dataHora);

            return "agendamento";

        }






    }

}
