package com.fliperamaestudio.fliperamaestudio.repository;


import com.fliperamaestudio.fliperamaestudio.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {

    List< Agendamento> findAgendamentoByDataHoraBetween(LocalDateTime inicio, LocalDateTime fim);
}
