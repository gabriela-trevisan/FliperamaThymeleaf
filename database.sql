BEGIN;

CREATE TABLE usuario(
    id_usuario serial,
    nome VARCHAR(50),
    tipo_usuario VARCHAR(50),
    senha VARCHAR(60),
    PRIMARY KEY (id_usuario)
);

CREATE TABLE cliente(
    id_usuario int,
    email VARCHAR(50),
    PRIMARY KEY (id_usuario),
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)    
);

CREATE TABLE agendamento(
    id_agendamento serial,
    data_hora TIMESTAMP,
    id_usuario int,
    id_func int,
    PRIMARY KEY (id_agendamento),
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario),
    FOREIGN KEY (id_func) REFERENCES usuario(id_usuario)
);
 
 CREATE TABLE faturamento(
     id_faturamento serial,
     dia TIMESTAMP,
     faturamento_dia FLOAT,
     PRIMARY KEY (id_faturamento)
 );


COMMIT;