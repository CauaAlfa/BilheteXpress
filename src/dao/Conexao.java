/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Beto
 */



/**
 *
 * @author user
 */
public class Conexao {

    /* metodo responsavel em estabelecer aconexao com o banco*/
    public static Connection conector() {

        java.sql.Connection conexao = null;
        /* chamar o drive de concxao*/
        String driver = "com.mysql.cj.jdbc.Driver";
        /* armazena informacao do banco de dados */
        String url = "jdbc:mysql://localhost:3306/agiota_business";
        String user = "root";
        String senha = "";
        /* estabelecendo a conexao com o banco*/

        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, senha);
            return conexao;
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }

    }

}