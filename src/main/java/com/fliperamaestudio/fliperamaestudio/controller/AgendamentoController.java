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
      //  System.out.println(LocalDateTime.parse(data));



       /* System.out.println(dia);
        System.out.println(Formatador.formmatter.format(dia));*/

        //LocalDateTime atual = LocalDateTime.now();

        /*String data = Formatador.formmatter.format(atual.getMonth().getValue()) + "/" +
                Formatador.formmatter.format(atual.getDayOfMonth());
*/
       // if(dia > 0 && mes >0 && mes < 12 && ano > 2018 ){
        if(!data.isEmpty()){
            try{
                DataHora dia = new DataHora(LocalDateTime.parse(data));

                model.addAttribute("data", dia );
                model.addAttribute("agendamentos", new AgendamentoDAO()
                        .getAgendamentos(dia.getDataHora()));


            }catch (Exception e){

                model.addAttribute("data", new DataHora(LocalDateTime.now()));
                model.addAttribute("agendamentos", agendamentoRepository
                        .findAgendamentoByDataHoraBetween(LocalDateTime.now(), LocalDateTime.now().plusDays(1)) );

                e.printStackTrace();
            }



        }else{

            var diaHoje = LocalDateTime.now().minusHours(LocalDateTime.now().getHour());

            var listaAgendamento = agendamentoRepository
                    .findAgendamentoByDataHoraBetween(diaHoje, diaHoje.plusDays(1));

            Map<Integer, Agendamento> hashDia = new HashMap<>(15);

            for(Agendamento agend : listaAgendamento){
                hashDia.put(agend.getDataHora().getHour(), agend);
                System.out.println(diaHoje);
            }


            model.addAttribute("data", new DataHora(LocalDateTime.now()));
            model.addAttribute("agendamentos", hashDia);


        }


        return "agendamento";
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
