package com.fliperamaestudio.fliperamaestudio.controller;

import com.fliperamaestudio.fliperamaestudio.model.Agendamento;
import com.fliperamaestudio.fliperamaestudio.model.DataHora;
import com.fliperamaestudio.fliperamaestudio.repository.AgendamentoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Controller
public class RelatorioController {

    private final AgendamentoRepository agendamentoRepository;

    public RelatorioController(AgendamentoRepository agendamentoRepository) {
        this.agendamentoRepository = agendamentoRepository;
    }

    @GetMapping("/relatorio")
    public String gerarRelatorio(Model model) {
        var diaHoje = LocalDateTime.now().minusHours(LocalDateTime.now().getHour());
        var inicioMes = LocalDateTime.now().minusDays(LocalDateTime.now().getDayOfMonth());
        var listaMes = agendamentoRepository.findAgendamentoByDataHoraBetween(inicioMes, inicioMes.plusMonths(1));
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

        model.addAttribute("diasSemana", diasEnsaiados);
        model.addAttribute("mes", DataHora.formatar(diaHoje.getMonthValue()) + "/" + diaHoje.getYear() );

        return "relatorio";
    }
}
