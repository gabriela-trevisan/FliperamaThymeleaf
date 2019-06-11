package com.fliperamaestudio.fliperamaestudio.model;


import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
public class Usuario {


    @Id
    @GeneratedValue
    @Column(name = "id_usuario")
    private int IdUsuario;


    @Column(name = "nome_usuario")
    private String nome;

    @Column(unique = true)
    private String email;


    @Column(name = "tipo_usuario", nullable = false)
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