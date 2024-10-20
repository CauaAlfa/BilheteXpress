/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDate;

/**
 *
 * @author Caua
 */
public class Pagamento {
    private int id;
    private Venda venda;
    private double valorPago;
    private Cliente cliente;
    private Atendente atendente;
    private String tipoPagamento;
    private LocalDate dataPagamento;
    private boolean statusPagamento;

    public Pagamento(int id, Venda venda, double valorPago, Cliente cliente, Atendente atendente, String tipoPagamento, LocalDate dataPagamento, boolean statusPagamento) {
        this.id = id;
        this.venda = venda;
        this.valorPago = valorPago;
        this.cliente = cliente;
        this.atendente = atendente;
        this.tipoPagamento = tipoPagamento;
        this.dataPagamento = dataPagamento;
        this.statusPagamento = statusPagamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public boolean isStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(boolean statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Atendente getAtendente() {
        return atendente;
    }

    public void setAtendente(Atendente atendente) {
        this.atendente = atendente;
    }
    
    
    
}
