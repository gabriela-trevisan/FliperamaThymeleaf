package com.fliperamaestudio.fliperamaestudio.DAO;

import com.fliperamaestudio.fliperamaestudio.config.SpringJdbcConfig;
import com.fliperamaestudio.fliperamaestudio.model.Cliente;

import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ClienteDAO {

    public boolean cadastrarCliente(Cliente cliente){

        try(Connection conn = ConnectPostgres.getConnection()){

            int idUsuario = new UsuarioDAO().cadastroUsuario(cliente);

            if(idUsuario >0){

                String sql = "INSERT INTO cliente(id_usuario, email) VALUES(?,?)";

                PreparedStatement pre = conn.prepareStatement(sql);

                pre.setInt(1, idUsuario);
                pre.setString(2,cliente.getEmail());

                int retorno = pre.executeUpdate();

                return retorno > 0;
            }


            return false;


        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    public void teste() {

        try{

            var dataSource = new SpringJdbcConfig().postgresDataSource();

            String sql = "SELECT email FROM CLIENTE WHERE email = 'luiza';";

             var jdbcTemplate = new JdbcTemplate(dataSource);

            String result = jdbcTemplate.queryForObject(sql, String.class);

            System.out.println(result);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}