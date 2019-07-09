BEGIN;

CREATE TABLE usuario(
    id_usuario serial,
    nome VARCHAR(50),
    tipo_usuario VARCHAR(50),
    senha VARCHAR(60),
    email VARCHAR(50),
    PRIMARY KEY (id_usuario)
);

CREATE TABLE cliente(
    id_usuario int,
    telefone varchar(50),
    dias_ensaiados int,
    PRIMARY KEY (id_usuario),
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)    
);

CREATE TABLE funcionario(
    id_usuario int,
    endereco varchar(50),
    salario double precision,
    funcao varchar(50),
    PRIMARY KEY (id_usuario),
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
);



CREATE TABLE agendamento(
    data_hora TIMESTAMP,
    id_usuario int,
    id_func int,
    PRIMARY KEY (data_hora),
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario),
    FOREIGN KEY (id_func) REFERENCES usuario(id_usuario)
);
 
 CREATE TABLE faturamento(
     id_faturamento serial,
     dia TIMESTAMP,
     faturamento_dia double precision,
     PRIMARY KEY (id_faturamento)
 );

CREATE TABLE produto(
     id_produto serial,
     nome varchar(50),
     preco double precision,
     qtd int,

     PRIMARY KEY (id_produto)
 );

CREATE TABLE vendidos(
    nome varchar(50),
    qtd int,
    data TIMESTAMP primary key


);




COMMIT;