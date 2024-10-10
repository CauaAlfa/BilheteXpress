/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Caua
 */
public class Veiculo {
    private int id;
    private String modelo;
    private String matricula;
    private int quantidadeAssentos;
    private boolean manutencaoNecessaria;

    public Veiculo(int id, String modelo, String matricula, int quantidadeAssentos, boolean manutencaoNecessaria) {
        this.id = id;
        this.modelo = modelo;
        this.matricula = matricula;
        this.quantidadeAssentos = quantidadeAssentos;
        this.manutencaoNecessaria = manutencaoNecessaria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getQuantidadeAssentos() {
        return quantidadeAssentos;
    }

    public void setQuantidadeAssentos(int quantidadeAssentos) {
        this.quantidadeAssentos = quantidadeAssentos;
    }

    public boolean isManutencaoNecessaria() {
        return manutencaoNecessaria;
    }

    public void setManutencaoNecessaria(boolean manutencaoNecessaria) {
        this.manutencaoNecessaria = manutencaoNecessaria;
    }
    
    
}
