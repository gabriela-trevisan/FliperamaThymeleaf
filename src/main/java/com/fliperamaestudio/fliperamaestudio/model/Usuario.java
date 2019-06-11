package com.fliperamaestudio.fliperamaestudio.model;


import lombok.Data;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Usuario {


    @Id
    @GeneratedValue
    @Column(name = "id_usuario")
    private int IdUsuario;

    @Id
    @Column(name = "nome_usuario")
    private String nome;

    @NotNull
    @Column(name = "tipo_usuario")
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