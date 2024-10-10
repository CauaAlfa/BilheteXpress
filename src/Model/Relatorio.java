/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Caua
 */
public class Relatorio {
    private int id;
    private String tipo;
    private localDate dataInicio;
    private localDate dataFim;
    private String dados;

    public Relatorio(int id, String tipo, localDate dataInicio, localDate dataFim, String dados) {
        this.id = id;
        this.tipo = tipo;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.dados = dados;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public localDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(localDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public localDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(localDate dataFim) {
        this.dataFim = dataFim;
    }

    public String getDados() {
        return dados;
    }

    public void setDados(String dados) {
        this.dados = dados;
    }
    
    
}
