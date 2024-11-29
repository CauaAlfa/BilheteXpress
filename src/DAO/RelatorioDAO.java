/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Caua
 */


public class RelatorioDAO {

    public String gerarRelatorio() {
        StringBuilder relatorio = new StringBuilder();

        Connection con = ConexaoBD.conectar();

        try {
            
            relatorio.append("=========================R E L A T O R I O=========================\n");
            relatorio.append("===================================================================\n");


            
            // Quantidade de funcionários
            String sqlFuncionarios = "SELECT COUNT(*) AS total FROM users";
            PreparedStatement pstFuncionarios = con.prepareStatement(sqlFuncionarios);
            ResultSet rsFuncionarios = pstFuncionarios.executeQuery();
            if (rsFuncionarios.next()) {
                relatorio.append("Total de Funcionários: ").append(rsFuncionarios.getInt("total")).append("\n");
            }

            // Quantidade de cada cargo
            String sqlCargos = "SELECT cargo, COUNT(*) AS total FROM users GROUP BY cargo";
            PreparedStatement pstCargos = con.prepareStatement(sqlCargos);
            ResultSet rsCargos = pstCargos.executeQuery();
            relatorio.append("Funcionários por Cargo:\n");
            while (rsCargos.next()) {
                relatorio.append("  ").append(rsCargos.getString("cargo")).append(": ").append(rsCargos.getInt("total")).append("\n");
            }

          /*  // Quantidade de cada sexo
            String sqlSexo = "SELECT sexo, COUNT(*) AS total FROM users GROUP BY sexo";
            PreparedStatement pstSexo = con.prepareStatement(sqlSexo);
            ResultSet rsSexo = pstSexo.executeQuery();
            relatorio.append("Funcionários por Sexo:\n");
            while (rsSexo.next()) {
                relatorio.append("  ").append(rsSexo.getString("sexo")).append(": ").append(rsSexo.getInt("total")).append("\n");
            } */

            // Quantidade de viagens
            String sqlViagens = "SELECT COUNT(*) AS total FROM viagens";
            PreparedStatement pstViagens = con.prepareStatement(sqlViagens);
            ResultSet rsViagens = pstViagens.executeQuery();
            if (rsViagens.next()) {
                relatorio.append("Total de Viagens: ").append(rsViagens.getInt("total")).append("\n");
            }

            // Viagens mais cadastradas
            String sqlViagensMaisCadastradas = "SELECT partida, destino, COUNT(*) AS total FROM viagens GROUP BY partida, destino ORDER BY total DESC LIMIT 1";
            PreparedStatement pstViagensMaisCadastradas = con.prepareStatement(sqlViagensMaisCadastradas);
            ResultSet rsViagensMaisCadastradas = pstViagensMaisCadastradas.executeQuery();
            if (rsViagensMaisCadastradas.next()) {
                relatorio.append("Viagem Mais Cadastrada: ").append(rsViagensMaisCadastradas.getString("partida")).append(" -> ").append(rsViagensMaisCadastradas.getString("destino")).append(" (").append(rsViagensMaisCadastradas.getInt("total")).append(" vezes)\n");
            }

            // Quantidade de autocarros
            String sqlAutocarros = "SELECT COUNT(*) AS total FROM autocarros";
            PreparedStatement pstAutocarros = con.prepareStatement(sqlAutocarros);
            ResultSet rsAutocarros = pstAutocarros.executeQuery();
            if (rsAutocarros.next()) {
                relatorio.append("Total de Autocarros: ").append(rsAutocarros.getInt("total")).append("\n");
            }

            
            relatorio.append("===================================================================\n");
            relatorio.append("===================================================================\n");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

        return relatorio.toString();
    }
}

