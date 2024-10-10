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
public class Atendente extends Usuario{
    private List<Vendas> vendasRealizadas;
            
    public Atendente(int id, String nome, String email, String senha, String cargo) {
        super(id, nome, email, senha, cargo);
    }
    
}
