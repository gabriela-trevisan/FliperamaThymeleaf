package com.fliperamaestudio.fliperamaestudio.controller;


import com.fliperamaestudio.fliperamaestudio.dao.AgendamentoDAO;
import com.fliperamaestudio.fliperamaestudio.model.Agendamento;
import com.fliperamaestudio.fliperamaestudio.model.DataHora;

import com.fliperamaestudio.fliperamaestudio.repository.AgendamentoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/agendamento")
@SessionAttributes("usuario")
public class AgendamentoController {

    private final AgendamentoRepository agendamentoRepository;

    public AgendamentoController(AgendamentoRepository agendamentoRepository) {
        this.agendamentoRepository = agendamentoRepository;
    }

    @GetMapping
    public String returnAgendaDia(@RequestParam(defaultValue = "") String data, Model model) {

        if(!data.isEmpty()){

            try{
                DataHora dia = new DataHora(LocalDateTime.parse(data));
                if( dia.getDataHora().toLocalDate().isBefore(LocalDateTime.now().toLocalDate()) ) {
                    model.addAttribute("passado", true);
                }else {
                    model.addAttribute("passsdo", false);
                }

                var listaAgendamento = agendamentoRepository
                        .findAgendamentoByDataHoraBetween(dia.getDataHora(), dia.getDataHora().plusDays(1));

                Map<Integer, Agendamento> hashDia = new HashMap<>(15);

                for(Agendamento agend : listaAgendamento){
                    hashDia.put(agend.getDataHora().getHour(), agend);

                }

                model.addAttribute("data", dia );
                model.addAttribute("agendamentos", hashDia);

            }catch (Exception e){
                consultarDiaAtual(model);

                e.printStackTrace();
            }


        }else{

            consultarDiaAtual(model);

        }

        return "agendamento";
    }

    private void consultarDiaAtual(Model model) {
        var diaHoje = LocalDateTime.now().minusHours(LocalDateTime.now().getHour());

        var listaAgendamento = agendamentoRepository
                .findAgendamentoByDataHoraBetween(diaHoje, diaHoje.plusDays(1));

        Map<Integer, Agendamento> hashDia = new HashMap<>(15);

        for(Agendamento agend : listaAgendamento){
            hashDia.put(agend.getDataHora().getHour(), agend);

        }

        model.addAttribute("passado", false);
        model.addAttribute("data", new DataHora(LocalDateTime.now()));
        model.addAttribute("agendamentos",  hashDia);
    }


    @GetMapping("/proximo")
    public String consultarProximoDia(@RequestParam String data){

        return "redirect:/agendamento?data=" + LocalDateTime.parse(data).plusDays(1);
    }

    @GetMapping("/anterior")
    public String consultarDiaAnterior(@RequestParam String data){

        return "redirect:/agendamento?data=" + LocalDateTime.parse(data).minusDays(1);
    }


}
