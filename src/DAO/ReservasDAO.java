/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Reservas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author Caua
 */


public class ReservasDAO {
    
    public void cadastrarReserva(String partida, String destino, String autocarro, String data, String hora, double preco, String apelido, String nome, String email, String BI, String telefone, String telefoneEmergencia, String sexo, boolean status) {
        Connection con = ConexaoBD.conectar();

        try {
            PreparedStatement pst = con.prepareStatement("INSERT INTO Reservas (partida, destino, autocarro, data, hora, preco, apelido, nome, email, BI, telefone, telefoneEmergencia, sexo, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pst.setString(1, partida);
            pst.setString(2, destino);
            pst.setString(3, autocarro);
            pst.setString(4, data);
            pst.setString(5, hora);
            pst.setDouble(6, preco);
            pst.setString(7, apelido);
            pst.setString(8, nome);
            pst.setString(9, email);
            pst.setString(10, BI);
            pst.setString(11, telefone);
            pst.setString(12, telefoneEmergencia);
            pst.setString(13, sexo);
            pst.setBoolean(14, status);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Reserva cadastrada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar reserva: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public List<Reservas> buscarTodasReservas() {
        Connection con = ConexaoBD.conectar();
        List<Reservas> reservas = new ArrayList<>();

        try {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM Reservas");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Reservas reserva = new Reservas();
                reserva.setId(rs.getInt("id"));
                reserva.setPartida(rs.getString("partida"));
                reserva.setDestino(rs.getString("destino"));
                reserva.setAutocarro(rs.getString("autocarro"));
                reserva.setData(rs.getString("data"));
                reserva.setHora(rs.getString("hora"));
                reserva.setPreco(rs.getDouble("preco"));
                reserva.setApelido(rs.getString("apelido"));
                reserva.setNome(rs.getString("nome"));
                reserva.setEmail(rs.getString("email"));
                reserva.setBI(rs.getString("BI"));
                reserva.setTelefone(rs.getString("telefone"));
                reserva.setTelefoneEmergencia(rs.getString("telefoneEmergencia"));
                reserva.setSexo(rs.getString("sexo"));
                reserva.setStatus(rs.getBoolean("status"));

                reservas.add(reserva);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar reservas: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return reservas;
    }
                
              
}
