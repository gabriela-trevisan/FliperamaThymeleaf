package com.fliperamaestudio.fliperamaestudio.dao;

import com.fliperamaestudio.fliperamaestudio.model.Agendamento;
import com.fliperamaestudio.fliperamaestudio.model.Usuario;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class AgendamentoDAO {

    public boolean agendarHora(Agendamento agendamento){

        try(Connection conn = ConnectPostgres.getConnection()){

            String sql = "INSERT INTO agendamento(data_hora, id_usuario, id_func) VALUES(?,?,?)";

            PreparedStatement pre = conn.prepareStatement(sql);

            pre.setTimestamp(1, Timestamp.valueOf(agendamento.getDataHora()));
            pre.setInt(2, agendamento.getReserva().getIdUsuario());
            pre.setInt(3, agendamento.getReservaFunc().getIdUsuario());

            int retorno = pre.executeUpdate();

            if(retorno > 0 ) return  true;

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return false;
    }

    public Map<Integer, Agendamento> getAgendamentos(LocalDateTime dia){

        Map< Integer, Agendamento> agendamentos = new HashMap<>(15);

        try(Connection conn = ConnectPostgres.getConnection()){

            String sql = "SELECT * FROM agendamento, usuario " +
                    "WHERE agendamento.id_usuario = usuario.id_usuario AND agendamento.data_hora  BETWEEN ? AND ?" ;
            System.out.println(Timestamp.valueOf(dia));


            PreparedStatement pre = conn.prepareStatement(sql);

            pre.setTimestamp(1, Timestamp.valueOf(dia));
            pre.setTimestamp(2, Timestamp.valueOf(dia.plusDays(1)));


             ResultSet rs = pre.executeQuery();


            /*Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM agendamento, usuario " +
                    "WHERE agendamento.id_usuario = usuario.id_usuario AND agendamento.data_hora  = " +
                dia.format(Agendamento.formatador));*/

            while (rs.next()){

                agendamentos.put(rs.getTimestamp("data_hora").toLocalDateTime()
                        .getHour(),new Agendamento( rs.getTimestamp("data_hora").toLocalDateTime(),
                        new Usuario(rs.getString("nome"),rs.getString("tipo_usuario") ) ) );
            }

        }catch (Exception e){e.printStackTrace();}

        return agendamentos;


    }
}