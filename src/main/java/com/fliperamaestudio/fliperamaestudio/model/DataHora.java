package com.fliperamaestudio.fliperamaestudio.model;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DataHora {

    private LocalDateTime dataHora;
    // private LocalDate data;
    private static final DecimalFormat formmatter = new DecimalFormat("00");


    public DataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public DataHora(int ano, int mes, int dia) {
        dataHora = LocalDateTime.of(LocalDate.of(ano, mes, dia), LocalTime.of(0, 0));
    }

    public DataHora(int ano, int mes, int dia, int hora) {
        dataHora = LocalDateTime.of(LocalDate.of(ano, mes, dia), LocalTime.of(hora, 0));
    }


    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public static String formatar(int numero) {

        return formmatter.format(numero);
    }


    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public String getData(){

        return formatar(dataHora.getDayOfMonth()) + "/" + formatar(dataHora.getMonthValue());
    }
}


