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
public class Viagens {
    private int id;
    private String partida;
    private String destino;
    private String autocarro;
    private String data;
    private String hora;
    private double preco;
    private boolean isDelete;
    
    public Viagens() {
    }

    public Viagens(int id, String partida, String destino, String autocarro, String data, String hora, double preco, boolean isDelete) {
        this.id = id;
        this.partida = partida;
        this.destino = destino;
        this.autocarro = autocarro;
        this.data = data;
        this.hora = hora;
        this.preco = preco;
        this.isDelete = isDelete;
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

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }
}
