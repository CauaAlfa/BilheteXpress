/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Caua
 */

public class UsuarioDAO {

    // Método para cadastrar um novo usuário
    public void cadastrarUsuario(String apelido, String nome, String email, String senha, String cargo) {
        Connection con = ConexaoBD.conectar();
        boolean status = true;  // Define o status inicialmente como true

        // Insere os valores no banco de dados
        try {
            PreparedStatement pst = con.prepareStatement("INSERT INTO users (apelido, nome, email, senha, cargo, status) VALUES (?, ?, ?, ?, ?, ?)");
            pst.setString(1, apelido);
            pst.setString(2, nome);
            pst.setString(3, email);
            pst.setString(4, senha);
            pst.setString(5, cargo);
            pst.setBoolean(6, status);
            pst.executeUpdate();
            System.out.println("Usuário cadastrado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
        }
    }

    // Método para validar login de um usuário
    public Usuario login(String email, String senha) {
        Connection con = ConexaoBD.conectar();
        Usuario usuario = null;

        try {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM users WHERE email = ? AND senha = ?");
            pst.setString(1, email);
            pst.setString(2, senha);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setCargo(rs.getString("cargo"));
                // Defina outros atributos conforme necessário
            }

        } catch (SQLException e) {
            System.out.println("Erro ao validar login: " + e.getMessage());
        }
        return usuario;
    }
    
    // Método para obter todos os usuários
    public List<Usuario> buscarTodosUsuarios() {
        Connection con = ConexaoBD.conectar();
        List<Usuario> usuarios = new ArrayList<>();

        try {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM users");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setApelido(rs.getString("apelido"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setCargo(rs.getString("cargo"));
                usuario.setStatus(rs.getBoolean("status"));

                usuarios.add(usuario);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar usuários: " + e.getMessage());
        }
        return usuarios;
    }
}

