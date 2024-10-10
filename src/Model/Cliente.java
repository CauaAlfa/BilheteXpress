/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;

/**
 *
 * @author Caua
 */
public class Cliente {
    private int id;
    private String nome;
    private String email;
    private String BI;
    private String telefone;
    private List<Viagem> historicoViagens;

    public Cliente(int id, String nome, String email, String BI, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.BI = BI;
        this.telefone = telefone;
        this.historicoViagens = historicoViagens;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBI() {
        return BI;
    }

    public void setBI(String BI) {
        this.BI = BI;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Viagem> getHistoricoViagens() {
        return historicoViagens;
    }

    public void setHistoricoViagens(List<Viagem> historicoViagens) {
        this.historicoViagens = historicoViagens;
    }
    
    
    
}
