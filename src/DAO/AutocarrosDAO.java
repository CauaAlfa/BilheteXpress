/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Autocarros;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Caua
 */

public class AutocarrosDAO {
    
    public void cadastrarAutocarro(String modelo, String matricula, int assentos, boolean manutencao, String motoristaApelido, String motoristaNome, String sexo) {
        Connection con = ConexaoBD.conectar();
        boolean isDelete = false;  // Por padrão, o novo registro não está deletado

        try {
            PreparedStatement pst = con.prepareStatement("INSERT INTO Autocarros (modelo, matricula, assentos, manutencao, motoristaApelido, motoristaNome, sexo, isDelete) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            pst.setString(1, modelo);
            pst.setString(2, matricula);
            pst.setInt(3, assentos);
            pst.setBoolean(4, manutencao);  // Definir valor padrão para 'manutencao' se necessário, ou adicionar como parâmetro
            pst.setString(5, motoristaApelido);
            pst.setString(6, motoristaNome);
            pst.setString(7, sexo);
            pst.setBoolean(8, isDelete);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Autocarro cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar autocarro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
        public List<Autocarros> buscarTodosAutocarros() {
        Connection con = ConexaoBD.conectar();
        List<Autocarros> autocarros = new ArrayList<>();
        
        try {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM Autocarros WHERE isDelete = false");
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                Autocarros autocarro = new Autocarros();
                autocarro.setId(rs.getInt("id"));
                autocarro.setModelo(rs.getString("modelo"));
                autocarro.setMatricula(rs.getString("matricula"));
                autocarro.setAssentos(rs.getInt("assentos"));
                autocarro.setManutencao(rs.getBoolean("manutencao"));
                autocarro.setMotoristaApelido(rs.getString("motoristaApelido"));
                autocarro.setMotoristaNome(rs.getString("motoristaNome"));
                autocarro.setSexo(rs.getString("sexo"));
                autocarro.setIsDelete(rs.getBoolean("isDelete"));
                
                autocarros.add(autocarro);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar autocarros: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return autocarros;
        }
        
        public void atualizarAutocarro(int id, boolean manutencao, String motoristaApelido, String motoristaNome, String sexo) {
            Connection con = ConexaoBD.conectar();
            try {
                PreparedStatement pst = con.prepareStatement("UPDATE Autocarros SET manutencao = ?, motoristaApelido = ?, motoristaNome = ?, sexo = ? WHERE id = ?");
                pst.setBoolean(1, manutencao);
                pst.setString(2, motoristaApelido);
                pst.setString(3, motoristaNome);
                pst.setString(4, sexo);
                pst.setInt(5, id);
                pst.executeUpdate();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar autocarro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        public void eliminarAutocarro(int id) {
            Connection con = ConexaoBD.conectar();
            try {
                PreparedStatement pst = con.prepareStatement("UPDATE Autocarros SET isDelete = true WHERE id = ?");
                pst.setInt(1, id);
                pst.executeUpdate();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao excluir autocarro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        public List<Autocarros> pesquisarAutocarros(String keyword) {
            Connection con = ConexaoBD.conectar();
            List<Autocarros> autocarros = new ArrayList<>();
            try {
                PreparedStatement pst = con.prepareStatement("SELECT * FROM Autocarros WHERE (modelo LIKE ? OR matricula LIKE ? OR assentos LIKE ? OR motoristaApelido LIKE ? OR motoristaNome LIKE ? OR sexo LIKE ?) AND isDelete = false");
                String searchPattern = "%" + keyword + "%";
                pst.setString(1, searchPattern);
                pst.setString(2, searchPattern);
                pst.setString(3, searchPattern);
                pst.setString(4, searchPattern);
                pst.setString(5, searchPattern);
                pst.setString(6, searchPattern);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    Autocarros autocarro = new Autocarros();
                    autocarro.setId(rs.getInt("id"));
                    autocarro.setModelo(rs.getString("modelo"));
                    autocarro.setMatricula(rs.getString("matricula"));
                    autocarro.setAssentos(rs.getInt("assentos"));
                    autocarro.setManutencao(rs.getBoolean("manutencao"));
                    autocarro.setMotoristaApelido(rs.getString("motoristaApelido"));
                    autocarro.setMotoristaNome(rs.getString("motoristaNome"));
                    autocarro.setSexo(rs.getString("sexo"));
                    autocarro.setIsDelete(rs.getBoolean("isDelete"));
                    autocarros.add(autocarro);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao buscar autocarros: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
            return autocarros;
        }


}