/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.uncuyo.controller;

/**
 *
 * @author Paula
 */
import ar.edu.uncuyo.dao.UsuarioDAO;
import ar.edu.uncuyo.model.Usuario;

public class UsuarioController {

    private UsuarioDAO dao;

    public UsuarioController() {
        dao = new UsuarioDAO();
    }

    public Usuario login(String email, String password) {
        return dao.autenticarAdministrador(email, password);
    }
}