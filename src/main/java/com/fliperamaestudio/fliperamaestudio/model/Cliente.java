package com.fliperamaestudio.fliperamaestudio.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Inheritance;

@Data
@Entity
public class Cliente extends Usuario{

    private int telefone;

    private int diasEnsaiados;


    public Cliente(String nome, String senha, String email, int telefone) {
        super(nome, senha);
        this.telefone = telefone;

    }


}