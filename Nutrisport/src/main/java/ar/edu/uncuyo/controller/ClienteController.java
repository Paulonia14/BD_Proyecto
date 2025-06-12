/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.uncuyo.controller;

/**
 *
 * @author Paula
 */
import ar.edu.uncuyo.dao.ClienteDAO;
import ar.edu.uncuyo.model.Cliente;

public class ClienteController {

    private ClienteDAO dao;

    public ClienteController() {
        dao = new ClienteDAO();
    }

    public void insertarCliente(Cliente cliente) {
        dao.insertarCliente(cliente);
    }

    public void modificarCliente(Cliente cliente) {
        dao.modificarCliente(cliente);
    }

    public void eliminarCliente(int id) {
        dao.eliminarCliente(id);
    }
}