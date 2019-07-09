package com.fliperamaestudio.fliperamaestudio.dao;

import com.fliperamaestudio.fliperamaestudio.model.Produto;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class VendidosDao {
    public boolean vendaDia(Produto produto){
        try(Connection conn = ConnectPostgres.getConnection()) {
            String sql = "INSERT INTO vendidos(id_usuario, qtd, data) VALUES(?,?,?)";
            var data = LocalDateTime.now();

            PreparedStatement pre = conn.prepareStatement(sql);
             pre.setInt(1, produto.getIdProduto());
             pre.setInt(2, produto.getQtd());
             pre.setTimestamp(3, Timestamp.valueOf(data));

             int retorno = pre.executeUpdate();

             if (retorno > 0 ) return true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }


    public List<Produto> returnVendaProdutos(LocalDateTime data){
        try(Connection conn = ConnectPostgres.getConnection()) {


            String sql = "SELECT * FROM vendidos WHERE vendidos.data BETWEEN ? AND ?";

            PreparedStatement pre = conn.prepareStatement(sql);

            pre.setTimestamp(1, Timestamp.valueOf(data));
            pre.setTimestamp(2, Timestamp.valueOf(data.plusMonths(1)));

            ResultSet rs = pre.executeQuery();

            while (rs.next()){

            }



        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ArrayList<>();


    }
}
