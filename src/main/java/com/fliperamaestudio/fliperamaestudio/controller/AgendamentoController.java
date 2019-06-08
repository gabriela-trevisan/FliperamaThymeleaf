package com.fliperamaestudio.fliperamaestudio.controller;


import com.fliperamaestudio.fliperamaestudio.DAO.AgendamentoDAO;
import com.fliperamaestudio.fliperamaestudio.DAO.UsuarioDAO;
import com.fliperamaestudio.fliperamaestudio.model.Agendamento;
import com.fliperamaestudio.fliperamaestudio.model.DataHora;

import com.fliperamaestudio.fliperamaestudio.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.Format;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;

@Controller
@RequestMapping("/agendamento")
public class AgendamentoController {


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
                model.addAttribute("agendamentos", new AgendamentoDAO()
                        .getAgendamentos(LocalDateTime.now()));

                e.printStackTrace();
            }



        }else{



            model.addAttribute("data", new DataHora(LocalDateTime.now()));
            model.addAttribute("agendamentos", new AgendamentoDAO()
                    .getAgendamentos(LocalDateTime.now()));


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
