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
import javax.swing.JOptionPane;

/**
 *
 * @author Caua
 */

public class UsuarioDAO {

    // Método para cadastrar um novo usuário
    public void cadastrarUsuario(String apelido, String nome, String email, String senha, String cargo) {
        Connection con = ConexaoBD.conectar();
        boolean status = true;  
        boolean isDelete = false;
        
        if (verificarEmailExistente(email, con)) {
            JOptionPane.showMessageDialog(null, "Erro: O email já está cadastrado.", "Erro", JOptionPane.ERROR_MESSAGE); return; 
        }
        
        try {
            PreparedStatement pst = con.prepareStatement("INSERT INTO users (apelido, nome, email, senha, cargo, status, isDelete) VALUES (?, ?, ?, ?, ?, ?, ?)");
            pst.setString(1, apelido);
            pst.setString(2, nome);
            pst.setString(3, email);
            pst.setString(4, senha);
            pst.setString(5, cargo);
            pst.setBoolean(6, status);
            pst.setBoolean(7, isDelete);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }    
        
        private boolean verificarEmailExistente(String email, Connection con) {
            boolean emailExiste = false; 
            
            try { 
                PreparedStatement pst = con.prepareStatement("SELECT COUNT(*) FROM users WHERE email = ?");
                pst.setString(1, email);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    emailExiste = rs.getInt(1) > 0; 
                } 
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao verificar email: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE); 
            } 
            return emailExiste; 
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
            PreparedStatement pst = con.prepareStatement("SELECT * FROM users WHERE isDelete = false");
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
                usuario.setIsDelete(rs.getBoolean("isDelete"));

                usuarios.add(usuario);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar usuários: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return usuarios;
    }
    
    //Metodo para actualizar dados dos usuarios
    public void atualizarUsuario(Usuario usuario) {
     Connection con = ConexaoBD.conectar();

     try {
         PreparedStatement pst = con.prepareStatement("UPDATE users SET email = ?, senha = ?, cargo = ?, status = ? WHERE id = ?");
         pst.setString(1, usuario.getEmail());
         pst.setString(2, usuario.getSenha());
         pst.setString(3, usuario.getCargo());
         pst.setBoolean(4, usuario.isStatus());
         pst.setInt(5, usuario.getId());
         pst.executeUpdate();
         System.out.println("Usuário atualizado com sucesso!");
     } catch (SQLException e) {
         System.out.println("Erro ao atualizar usuário: " + e.getMessage());
     }
    }

    public String buscarApelidoPorEmail(String email) {
        Connection con = ConexaoBD.conectar();
        String apelido = "";

        try {
            String sql = "SELECT apelido FROM users WHERE email = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                apelido = rs.getString("apelido");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar apelido: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

        return apelido;
    }
    

    public boolean atualizarSenha(String email, String novaSenha) {
        Connection con = ConexaoBD.conectar();
        try {
            String sql = "UPDATE users SET senha = ? WHERE email = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, novaSenha);
            pst.setString(2, email);
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar senha: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }


    public List<Usuario> buscarAtendentes() {
        Connection con = ConexaoBD.conectar();
        List<Usuario> atendentes = new ArrayList<>();

        try {
            String sql = "SELECT id, apelido, nome, email, cargo, status FROM Users WHERE cargo = 'Atendente'";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Usuario atendente = new Usuario();
                atendente.setId(rs.getInt("id"));
                atendente.setApelido(rs.getString("apelido"));
                atendente.setNome(rs.getString("nome"));
                atendente.setEmail(rs.getString("email"));
                atendente.setCargo(rs.getString("cargo"));
                atendente.setStatus(rs.getBoolean("status"));

                atendentes.add(atendente);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar atendentes: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return atendentes;
    }

 
}

    


