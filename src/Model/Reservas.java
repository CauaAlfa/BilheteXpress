/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Caua
 */
public class Reservas {
    private int id;
    private String partida;
    private String destino;
    private String autocarro;
    private String data;
    private String hora;
    private double preco;
    private String apelido;
    private String nome;
    private String email;
    private String BI;
    private String telefone;
    private String telefoneEmergencia;
    private String sexo;
    private boolean status;

    // Construtor padrão
    public Reservas() {
    }

    public Reservas(int id, String partida, String destino, String autocarro, String data, String hora, double preco, String apelido, String nome, String email, String BI, String telefone, String telefoneEmergencia, String sexo, boolean status) {
        this.id = id;
        this.partida = partida;
        this.destino = destino;
        this.autocarro = autocarro;
        this.data = data;
        this.hora = hora;
        this.preco = preco;
        this.apelido = apelido;
        this.nome = nome;
        this.email = email;
        this.BI = BI;
        this.telefone = telefone;
        this.telefoneEmergencia = telefoneEmergencia;
        this.sexo = sexo;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPartida() {
        return partida;
    }

    public void setPartida(String partida) {
        this.partida = partida;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getAutocarro() {
        return autocarro;
    }

    public void setAutocarro(String autocarro) {
        this.autocarro = autocarro;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
