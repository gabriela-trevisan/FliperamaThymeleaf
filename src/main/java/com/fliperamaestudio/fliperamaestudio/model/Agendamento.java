package com.fliperamaestudio.fliperamaestudio.model;


import javax.swing.text.DateFormatter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Agendamento {


    private LocalDateTime dataHora;
    private Usuario reserva;
    private Usuario reservaFunc;
    private boolean reservado;
    public static final DateTimeFormatter formatador =  DateTimeFormatter.ofPattern("yyyy/mm/dd hh:mm:ss");

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


    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public Usuario getReserva() {
        return reserva;
    }

    public Usuario getReservaFunc() {
        return reservaFunc;
    }
}