package com.fliperamaestudio.fliperamaestudio.model;


import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Cliente extends Usuario{

    private String email;


    public Cliente(String nome, String senha, String email) {
        super(nome, senha);
        this.email=email;

    }


}