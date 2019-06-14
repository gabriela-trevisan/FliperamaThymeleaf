package com.fliperamaestudio.fliperamaestudio.controller;

import com.fliperamaestudio.fliperamaestudio.dao.AgendamentoDAO;
import com.fliperamaestudio.fliperamaestudio.model.Agendamento;
import com.fliperamaestudio.fliperamaestudio.model.DataHora;
import com.fliperamaestudio.fliperamaestudio.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/agendar")
@SessionAttributes("usuario")
public class AgendarController {



    @GetMapping
    public String agendarHora(@RequestParam int ano,
                              @RequestParam int mes,
                              @RequestParam int dia,
                              @RequestParam int hora,
                              @SessionAttribute("usuario") Usuario usuario, Model model){

        DataHora dataHora = new DataHora(ano, mes, dia, hora);



        try {

            model.addAttribute("data", dataHora);

            new AgendamentoDAO().agendarHora( new Agendamento(dataHora.getDataHora(), usuario));

            return "agendamento";

        }catch (Exception e){

            e.printStackTrace();

            model.addAttribute("data", dataHora);

            return "agendamento";

        }






    }

}
