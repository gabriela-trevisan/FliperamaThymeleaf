package com.fliperamaestudio.fliperamaestudio.controller;


import com.fliperamaestudio.fliperamaestudio.DAO.AgendamentoDAO;
import com.fliperamaestudio.fliperamaestudio.DAO.UsuarioDAO;
import com.fliperamaestudio.fliperamaestudio.model.Agendamento;
import com.fliperamaestudio.fliperamaestudio.model.Formatador;
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
    public String returnAgendaDia( @RequestParam(defaultValue = "0") int mes ,
                                   @RequestParam(defaultValue = "0" ) int dia, Model model) {
        System.out.println(dia);
        System.out.println(Formatador.formmatter.format(dia));

        LocalDateTime atual = LocalDateTime.now();

        String data = Formatador.formmatter.format(atual.getMonth().getValue()) + "/" +
                Formatador.formmatter.format(atual.getDayOfMonth());

        if(dia > 0 && mes >0 && mes < 12){
            try{

                model.addAttribute("data", mes + "/" + dia );
                model.addAttribute("agendamentos", new AgendamentoDAO()
                        .getAgendamentos(LocalDateTime.parse("2019-06-" +
                                Formatador.formmatter.format(dia) + "T00:00")));


            }catch (Exception e){

                model.addAttribute("data", data);
                model.addAttribute("agendamentos", new AgendamentoDAO()
                        .getAgendamentos(LocalDateTime.now()));

                e.printStackTrace();
            }



        }else{

            model.addAttribute("data", data);
            model.addAttribute("agendamentos", new AgendamentoDAO()
                    .getAgendamentos(LocalDateTime.now()));

            model.addAttribute( "usuario" ,new UsuarioDAO()
                    .retornarUsuario(new Usuario("joao","1234")));
        }


        return "agendamento";
    }
}
