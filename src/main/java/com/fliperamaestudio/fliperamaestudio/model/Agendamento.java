package com.fliperamaestudio.fliperamaestudio.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
public class Agendamento {

    @Id
    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHora;



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