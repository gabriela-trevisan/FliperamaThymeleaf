package com.fliperamaestudio.fliperamaestudio.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Currency;

@Data
@Entity
@NoArgsConstructor
public class Funcionario extends Usuario{
    private String endereco;
    private Currency salario;
    private String funcao;



    public Funcionario(String nome, String email, String senha, String endereco, Currency salario, String funcao) {
        super(nome, email, senha);
        this.endereco = endereco;
        this.salario = salario;
        this.funcao = funcao;
    }


}
