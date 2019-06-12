package com.fliperamaestudio.fliperamaestudio.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Inheritance;

@Data
@Entity
@NoArgsConstructor
public class Cliente extends Usuario{


    private int telefone;

    private int diasEnsaiados;


    public Cliente(String nome, String senha, String email, int telefone) {
        super(nome, senha);
        this.telefone = telefone;

    }


}