package com.fliperamaestudio.fliperamaestudio.repository;


import com.fliperamaestudio.fliperamaestudio.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {

    List< Agendamento> findAgendamentoByDataHoraBetween(LocalDateTime inicio, LocalDateTime fim);
}
