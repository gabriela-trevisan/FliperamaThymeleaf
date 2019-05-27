package com.fliperamaestudio.fliperamaestudio.model;

public class Cliente extends Usuario{

    private String email;


    public Cliente(String nome, String senha, String email) {
        super(nome, senha);
        this.email=email;

    }

    public String getEmail() {
        return email;
    }
}