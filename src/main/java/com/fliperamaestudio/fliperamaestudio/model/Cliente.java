package com.fliperamaestudio.fliperamaestudio.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Inheritance;

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


}