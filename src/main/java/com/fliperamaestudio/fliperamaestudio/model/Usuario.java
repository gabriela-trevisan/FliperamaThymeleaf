package com.fliperamaestudio.fliperamaestudio.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario  implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int IdUsuario;

    private String nome;

    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_usuario", nullable = false)
    private Tipo tipo;

    private String senha;



    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;

    }

    public Usuario(String nome, Tipo tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }



    public Usuario(String nome, int idUsuario, String email, String senha) {
        this.nome = nome;
        this.IdUsuario = idUsuario;
        this.senha = senha;
        this.email = email;
    }




}