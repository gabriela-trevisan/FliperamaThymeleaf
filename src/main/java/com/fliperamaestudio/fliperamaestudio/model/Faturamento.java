package com.fliperamaestudio.fliperamaestudio.model;

import java.time.LocalDateTime;

public class Faturamento {
    private LocalDateTime dia;
    private double faturamentoDia;
    private int numBandas;

    public Faturamento(LocalDateTime dia, double faturamentoDia, int numBandas) {
        this.dia = dia;
        this.faturamentoDia = faturamentoDia;
        this.numBandas = numBandas;
    }

    public int getNumBandas() {
        return numBandas;
    }

    public void setNumBandas(int numBandas) {
        this.numBandas = numBandas;
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
