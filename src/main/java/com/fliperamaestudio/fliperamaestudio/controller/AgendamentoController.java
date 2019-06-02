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
    public String returnAgendaDia(@RequestParam(defaultValue = "2018") int ano,
                                  @RequestParam(defaultValue = "0") int mes,
                                  @RequestParam(defaultValue = "0" ) int dia, Model model) {
       /* System.out.println(dia);
        System.out.println(Formatador.formmatter.format(dia));*/

        //LocalDateTime atual = LocalDateTime.now();

        /*String data = Formatador.formmatter.format(atual.getMonth().getValue()) + "/" +
                Formatador.formmatter.format(atual.getDayOfMonth());
*/
        if(dia > 0 && mes >0 && mes < 12 && ano > 2018 ){
            try{
                DataHora data = new DataHora(ano, mes, dia);

                model.addAttribute("data", data );
                model.addAttribute("agendamentos", new AgendamentoDAO()
                        .getAgendamentos(data.getDataHora()));


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

            model.addAttribute( "usuario" ,new UsuarioDAO()
                    .retornarUsuario(new Usuario("joao","1234")));
        }


        return "agendamento";
    }



}
