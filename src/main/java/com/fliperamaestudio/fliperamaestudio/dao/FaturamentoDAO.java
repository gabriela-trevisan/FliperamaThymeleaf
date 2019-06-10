package com.fliperamaestudio.fliperamaestudio.dao;

import com.fliperamaestudio.fliperamaestudio.model.Faturamento;

import java.sql.*;
import java.util.ArrayList;

public class FaturamentoDAO {
    public boolean guardarFaturamento(Faturamento faturamento){
        try(Connection conn = ConnectPostgres.getConnection()){
            String sql = "INSERT INTO faturamento(dia, faturamento_dia) VALUE(?, ?)";

            PreparedStatement pre = conn.prepareStatement(sql);

            pre.setTimestamp(1, Timestamp.valueOf(faturamento.getDia()));
            pre.setDouble(2, faturamento.getFaturamentoDia());

            int retorno = pre.executeUpdate();

            if(retorno > 0 ) return true;

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public ArrayList<Faturamento> getFaturamentoDia(){
        ArrayList<Faturamento> faturamentos = new ArrayList<>();

        try(Connection conn = ConnectPostgres.getConnection()){

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM faturamento");


        }catch (Exception e){
            e.printStackTrace();
        }
        return faturamentos;
    }
}
