/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Cliente;
import java.util.List;
import dao.

/**
 *
 * @author Beto
 */


public class ClienteController {
    private ClienteDAO clienteDAO = new ClienteDAO();

    public void adicionarCliente(Cliente cliente) {
        clienteDAO.inserirCliente(cliente);
    }

    public List<Cliente> obterClientes() {
        return clienteDAO.listarClientes();
    }

    public void atualizarCliente(Cliente cliente) {
        clienteDAO.atualizarCliente(cliente);
    }

    public void removerCliente(int id) {
        clienteDAO.deletarCliente(id);
    }
}
