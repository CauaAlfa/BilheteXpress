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
    private Cliente cliente;
    private Viagem viagem;

    // Construtor padrão
    public Reservas() {
    }

    // Construtor com todos os parâmetros
    public Reservas(int id, Cliente cliente, Viagem viagem) {
        this.id = id;
        this.cliente = cliente;
        this.viagem = viagem;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Viagem getViagem() {
        return viagem;
    }

    public void setViagem(Viagem viagem) {
        this.viagem = viagem;
    }

    // Método toString para exibir a reserva
    @Override
    public String toString() {
        return "Reserva [id=" + id + ", cliente=" + cliente.getNome() + ", viagem=" + viagem.getDestino() + "]";
    }
}
