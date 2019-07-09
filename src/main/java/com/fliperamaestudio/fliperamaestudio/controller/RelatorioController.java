package com.fliperamaestudio.fliperamaestudio.controller;

import com.fliperamaestudio.fliperamaestudio.model.Agendamento;
import com.fliperamaestudio.fliperamaestudio.model.DataHora;
import com.fliperamaestudio.fliperamaestudio.model.Usuario;
import com.fliperamaestudio.fliperamaestudio.model.Vendidos;
import com.fliperamaestudio.fliperamaestudio.repository.AgendamentoRepository;
import com.fliperamaestudio.fliperamaestudio.repository.UserRepository;
import com.fliperamaestudio.fliperamaestudio.repository.VendidosRepository;
import com.fliperamaestudio.fliperamaestudio.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RelatorioController {

    private final AgendamentoRepository agendamentoRepository;
    private final VendidosRepository vendidosRepository;
    private final UserRepository userRepository;

    public RelatorioController(AgendamentoRepository agendamentoRepository, VendidosRepository vendidosRepository, UserService userService, UserRepository userRepository) {
        this.agendamentoRepository = agendamentoRepository;
        this.vendidosRepository = vendidosRepository;

        this.userRepository = userRepository;
    }

    @GetMapping("/relatorio")
    public String gerarRelatorio(Model model, @RequestParam(defaultValue = "") String dataConsulta) {
        LocalDateTime data;

        if(dataConsulta.isEmpty()){
            data = LocalDateTime.now().minusDays(LocalDateTime.now().getDayOfMonth());
        }else {
            data = LocalDateTime.parse(dataConsulta);
        }



        var diaHoje = LocalDateTime.now().minusHours(LocalDateTime.now().getHour());

       // var inicioMes = LocalDateTime.now().minusDays(LocalDateTime.now().getDayOfMonth());

        var listaMes = agendamentoRepository.findAgendamentoByDataHoraBetween(data, data.plusMonths(1));
        int[] diasEnsaiados = {0, 0, 0, 0, 0, 0, 0};
        for (Agendamento agend : listaMes) {
            switch (agend.getDataHora().getDayOfWeek().getValue()) {
                case 1:
                    diasEnsaiados[0]++;
                    break;

                case 2:
                    diasEnsaiados[1]++;
                    break;

                case 3:
                    diasEnsaiados[2]++;
                    break;

                case 4:
                    diasEnsaiados[3]++;
                    break;

                case 5:
                    diasEnsaiados[4]++;
                    break;

                case 6:
                    diasEnsaiados[5]++;
                    break;

                case 7:
                    diasEnsaiados[6]++;
                    break;

            }
        }

        List<Vendidos> produtosVendidos = vendidosRepository.findVendidosByDataBetween(data, data.plusMonths(1));

        Map<String, Vendidos> hashVendidos = new HashMap<>();

        for (Vendidos produto : produtosVendidos){
            if (hashVendidos.containsKey(produto.getNome())){
                hashVendidos.get(produto.getNome()).somaQtd(produto.getQtd());

            }else {
                hashVendidos.put(produto.getNome(), produto);
            }

        }


        List<Usuario> cadastrados = userRepository.findAll();





        model.addAttribute("cadastrados",cadastrados);

        model.addAttribute("diasSemana", diasEnsaiados);
        model.addAttribute("produtos", hashVendidos);
        model.addAttribute("mes", DataHora.formatar(data.getMonthValue()) + "/" + data.getYear() );

        return "relatorio";
    }
}
