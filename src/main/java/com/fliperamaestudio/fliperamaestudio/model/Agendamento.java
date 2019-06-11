package com.fliperamaestudio.fliperamaestudio.model;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.swing.text.DateFormatter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@Entity
public class Agendamento {

    @Id
    @Column(name = "data_hora")
    private LocalDateTime dataHora;

    private Usuario reserva;
    private Usuario reservaFunc;
    //private boolean reservado;


//    public Agendamento(int ano, int mes, int dia, int hora, Usuario reserva) {
//        dataHora= LocalDateTime.of(ano, mes, dia, hora, 00);
//        this.reserva = reserva;
//        reservado = true;
//    }



//    public Agendamento(int ano, int mes, int dia, int hora, Usuario reserva, Usuario reservaFunc) {
//        dataHora.of(ano, mes, dia, hora, 00);
//        this.reserva = reserva;
//        this.reservaFunc = reservaFunc;
//        reservado = true;
//    }

    public Agendamento(LocalDateTime dataHora, Usuario reserva){
        this.dataHora = dataHora;
        this.reserva = reserva;

    }



}