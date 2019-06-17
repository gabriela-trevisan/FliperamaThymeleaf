package com.fliperamaestudio.fliperamaestudio.controller;

import com.fliperamaestudio.fliperamaestudio.dao.AgendamentoDAO;
import com.fliperamaestudio.fliperamaestudio.model.Agendamento;
import com.fliperamaestudio.fliperamaestudio.model.DataHora;
import com.fliperamaestudio.fliperamaestudio.model.Usuario;
import com.fliperamaestudio.fliperamaestudio.repository.AgendamentoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/agendar")
@SessionAttributes("usuario")
public class AgendarController {
    private final AgendamentoRepository agendamentoRepository;

    public AgendarController(AgendamentoRepository agendamentoRepository) {
        this.agendamentoRepository = agendamentoRepository;    }


    @GetMapping
    public String agendarHora(@RequestParam String data,
                              @SessionAttribute(required = false, name = "usuario") Usuario usuario, Model model){

        DataHora dataHora = new DataHora(LocalDateTime.parse(data));


        if (usuario != null && !( dataHora.getDataHora().toLocalDate().isBefore(LocalDateTime.now().toLocalDate()) ) ) {



            try {

                model.addAttribute("data", dataHora);

                agendamentoRepository.save(new Agendamento(dataHora.getDataHora(), usuario));

                return "redirect:/agendamento?data=" + dataHora.getData() + "T00:00";

            } catch (Exception e) {

                e.printStackTrace();

                model.addAttribute("data", dataHora);

                return "redirect:/agendamento?data=" + dataHora.getData() + "T00:00";

            }

        }

        return "redirect:/login";

    }


    @GetMapping("/cancelar")
    public String cancelarAgendamento(@RequestParam String data,
                                      @SessionAttribute("usuario") Usuario usuario, Model model){

        DataHora dataHora = new DataHora(LocalDateTime.parse(data));

        try {

            model.addAttribute("data", dataHora);

            agendamentoRepository.delete(new Agendamento(dataHora.getDataHora(), usuario));

            return "redirect:/agendamento?data=" + dataHora.getData() + "T00:00";

        } catch (Exception e) {

            e.printStackTrace();

            model.addAttribute("data", dataHora);

            return "redirect:/agendamento?data=" + dataHora.getData() + "T00:00";

        }

    }



}
