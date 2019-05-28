package com.fliperamaestudio.fliperamaestudio.model;

import java.time.LocalDateTime;

public class Faturamento {
    private LocalDateTime dia;
    private double faturamentoDia;

    public Faturamento(LocalDateTime dia, double faturamentoDia) {
        this.dia = dia;
        this.faturamentoDia = faturamentoDia;
    }

    public LocalDateTime getDia() {
        return dia;
    }

    public void setDia(LocalDateTime dia) {
        this.dia = dia;
    }

    public double getFaturamentoDia() {
        return faturamentoDia;
    }

    public void setFaturamentoDia(double faturamentoDia) {
        this.faturamentoDia = faturamentoDia;
    }
}
