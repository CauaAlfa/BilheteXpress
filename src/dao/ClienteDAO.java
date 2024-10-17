/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Beto
 */

import Model.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
   Connection connection
    // CREATE
    public void inserirCliente(Cliente cliente) {
        String sql = "INSERT INTO cliente (Pnome, Sobrenome, Email, Sexo, Tel, Tel_alternativo, Nrdoc, id_user) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, cliente.getNome());
           // pstmt.setString(2, cliente.getSobrenome());
            pstmt.setString(3, cliente.getEmail());
          ///  pstmt.setString(4, cliente.getSexo());
            pstmt.setString(5, cliente.getTelefone());
          //  pstmt.setString(6, cliente.getTelAlternativo());
           // pstmt.setString(7, cliente.getNrDoc());
           // pstmt.setInt(8, cliente.getId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ
    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("Pnome"));
               // cliente.setSobrenome(rs.getString("Sobrenome"));
                cliente.setEmail(rs.getString("Email"));
                //cliente.setSexo(rs.getString("Sexo"));
                cliente.setNome(rs.getString("Tel"));
                cliente.setTelefone(rs.getString("Tel_alternativo"));
                //cliente.setNrDoc(rs.getString("Nrdoc"));
                cliente.setId(rs.getInt("id_user"));

                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clientes;
    }

    // UPDATE
    public void atualizarCliente(Cliente cliente) {
        String sql = "UPDATE cliente SET Pnome = ?, Sobrenome = ?, Email = ?, Sexo = ?, Tel = ?, Tel_alternativo = ?, Nrdoc = ?, id_user = ? WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, cliente.getNome());
           // pstmt.setString(2, cliente.getSobrenome());
            pstmt.setString(3, cliente.getEmail());
           // pstmt.setString(4, cliente.getSexo());
            pstmt.setString(5, cliente.getTelefone());
            //pstmt.setString(6, cliente.getTelAlternativo());
           // pstmt.setString(7, cliente.getNrDoc());
           // pstmt.setInt(8, cliente.getIdUser());
            pstmt.setInt(9, cliente.getId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deletarCliente(int id) {
        String sql = "DELETE FROM cliente WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
