package com.fliperamaestudio.fliperamaestudio.model;


import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Usuario {


    @Id
    @GeneratedValue
    private int IdUsuario;

    @Id
    private String nome;

    @NotNull
    private Tipo tipo;
    private String senha;



    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public Usuario(String nome, Tipo tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

}