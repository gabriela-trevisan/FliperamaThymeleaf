package com.fliperamaestudio.fliperamaestudio.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
public class Vendidos {

    @Id
    private LocalDateTime data;

    private String nome;

    private int qtd;


    public Vendidos(LocalDateTime data, String nome, int qtd) {
        this.data = data;
        this.nome = nome;
        this.qtd = qtd;
    }

    public void somaQtd(int qtd){
        this.qtd += qtd;

    }
}
