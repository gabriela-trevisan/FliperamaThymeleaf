package com.fliperamaestudio.fliperamaestudio.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@Entity
@NoArgsConstructor
public class Funcionario extends Usuario{
    private String endereco;
    private double salario;
    private String funcao;



    public Funcionario(String nome, String email, String senha, String endereco, double salario, String funcao) {
        super(nome, email, senha);
        this.endereco = endereco;
        this.salario = salario;
        this.funcao = funcao;
    }



    public Funcionario(String nome, int id, String email, String senha, String endereco, double salario, String funcao) {
        super(nome, id, email, senha);
        this.endereco = endereco;
        this.salario = salario;
        this.funcao = funcao;
    }




}
