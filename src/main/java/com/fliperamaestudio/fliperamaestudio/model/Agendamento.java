package com.fliperamaestudio.fliperamaestudio.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.swing.text.DateFormatter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@Entity
@NoArgsConstructor
public class Agendamento {

    @Id
    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHora;


    //@Column(nullable = false, name = "id_usuario")
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario reserva;

    @ManyToOne
    @JoinColumn(name = "id_func" )
    private Usuario reservaFunc;

    public Agendamento(LocalDateTime dataHora, Usuario reserva){
        this.dataHora = dataHora;
        this.reserva = reserva;

    }

}