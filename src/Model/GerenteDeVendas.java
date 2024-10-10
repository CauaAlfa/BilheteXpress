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
public class GerenteDeVendas extends Usuario{
    private List<Vendas> vendasSupervisionadas;
    
    public GerenteDeVendas(int id, String nome, String email, String senha, String cargo) {
        super(id, nome, email, senha, cargo);
    }
    
}
