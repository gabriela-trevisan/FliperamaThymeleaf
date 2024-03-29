package com.fliperamaestudio.fliperamaestudio.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@Entity
@NoArgsConstructor
public class Cliente extends Usuario{


    private String telefone;

    private int diasEnsaiados;


    public Cliente(String nome, String email, String senha, String telefone) {
        super(nome, email, senha);
        this.telefone = telefone;

    }
    public Cliente(String nome, String email, String telefone) {
        super(nome, email);
        this.telefone = telefone;

    }


}