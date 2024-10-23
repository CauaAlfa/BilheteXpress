/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Caua
 */
import Model.Viagens;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ViagensDAO {
    
    public void cadastrarViagem(String partida, String destino, String autocarro, String data, String hora, double preco) {
        Connection con = ConexaoBD.conectar();
        boolean isDelete = false; 

        try {
            PreparedStatement pst = con.prepareStatement("INSERT INTO Viagens (partida, destino, autocarro, data, hora, preco, isDelete) VALUES (?, ?, ?, ?, ?, ?, ?)");
            pst.setString(1, partida);
            pst.setString(2, destino);
            pst.setString(3, autocarro);
            pst.setString(4, data);
            pst.setString(5, hora);
            pst.setDouble(6, preco);
            pst.setBoolean(7, isDelete);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Viagem cadastrada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar viagem: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public List<Viagens> buscarTodasViagens() {
        Connection con = ConexaoBD.conectar();
        List<Viagens> viagens = new ArrayList<>();

        try {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM Viagens");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Viagens viagem = new Viagens();
                viagem.setId(rs.getInt("id"));
                viagem.setPartida(rs.getString("partida"));
                viagem.setDestino(rs.getString("destino"));
                viagem.setAutocarro(rs.getString("autocarro"));
                viagem.setData(rs.getString("data"));
                viagem.setHora(rs.getString("hora"));
                viagem.setPreco(rs.getDouble("preco"));
                viagem.setDelete(rs.getBoolean("isDelete"));

                viagens.add(viagem);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar viagens: " + e.getMessage());
        }
        return viagens;
    }

    public void atualizarViagem(int id, String autocarro, String data, String hora, double preco, boolean isDelete) {
        Connection con = ConexaoBD.conectar();

        try {
            PreparedStatement pst = con.prepareStatement("UPDATE Viagens SET autocarro = ?, data = ?, hora = ?, preco = ?, isDelete = ? WHERE id = ?");
            pst.setString(1, autocarro);
            pst.setString(2, data);
            pst.setString(3, hora);
            pst.setDouble(4, preco);
            pst.setBoolean(5, isDelete);
            pst.setInt(6, id);
            pst.executeUpdate();
            System.out.println("Viagem atualizada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar viagem: " + e.getMessage());
        } 
    }
    
    
    
}
