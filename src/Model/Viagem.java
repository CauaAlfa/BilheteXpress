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
public class Viagem {
    private int id;
//    private localDate dataHoraPartida;
//    private localDate dataHoraChegada;
    private Rota rota;
    private Veiculo veiculo;
    private int assentosDisponiveis;
    private List<Assento> assentosOcupados;

    public Viagem(int id, Rota rota, Veiculo veiculo, int assentosDisponiveis, List<Assento> assentosOcupados) {
        this.id = id;
        this.rota = rota;
        this.veiculo = veiculo;
        this.assentosDisponiveis = assentosDisponiveis;
        this.assentosOcupados = assentosOcupados;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Rota getRota() {
        return rota;
    }

    public void setRota(Rota rota) {
        this.rota = rota;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public int getAssentosDisponiveis() {
        return assentosDisponiveis;
    }

    public void setAssentosDisponiveis(int assentosDisponiveis) {
        this.assentosDisponiveis = assentosDisponiveis;
    }

    public List<Assento> getAssentosOcupados() {
        return assentosOcupados;
    }

    public void setAssentosOcupados(List<Assento> assentosOcupados) {
        this.assentosOcupados = assentosOcupados;
    }
    
    
}
