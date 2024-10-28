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
import java.util.List;

public class Cliente {
    private int id;
    private String apelido;
    private String nome;
    private String email;
    private String BI;  // Bilhete de Identidade
    private String telefone;
    private String telefoneEmergencia;
    private String sexo;
    private List<Viagens> historicoViagens;

    // Construtor padrão
    public Cliente() {
    }

    public Cliente(int id, String apelido, String nome, String email, String BI, String telefone, String telefoneEmergencia, String sexo, List<Viagens> historicoViagens) {
        this.id = id;
        this.apelido = apelido;
        this.nome = nome;
        this.email = email;
        this.BI = BI;
        this.telefone = telefone;
        this.telefoneEmergencia = telefoneEmergencia;
        this.sexo = sexo;
        this.historicoViagens = historicoViagens;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
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

    public String getTelefoneEmergencia() {
        return telefoneEmergencia;
    }

    public void setTelefoneEmergencia(String telefoneEmergencia) {
        this.telefoneEmergencia = telefoneEmergencia;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public List<Viagens> getHistoricoViagens() {
        return historicoViagens;
    }

    public void setHistoricoViagens(List<Viagens> historicoViagens) {
        this.historicoViagens = historicoViagens;
    }
}
