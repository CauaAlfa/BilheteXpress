/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Caua
 */
public class Venda {
    private int id;
    private Cliente cliente;
    private Viagem viagem;
    private List<Assento> assentosVendidos;
    private double valorTotal;
    private localDate dataVenda;
    private String formaPagamento;
    private String status;
}
