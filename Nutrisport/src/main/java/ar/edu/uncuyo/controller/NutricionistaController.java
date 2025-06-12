/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.uncuyo.controller;

import ar.edu.uncuyo.dao.NutricionistaDAO;
import ar.edu.uncuyo.model.Nutricionista;

/**
 *
 * @author Paula
 */
public class NutricionistaController {
    private NutricionistaDAO dao;

    public NutricionistaController() {
        dao = new NutricionistaDAO();
    }

    public void insertarNutricionista(Nutricionista nutricionista) {
        dao.insertarNutricionista(nutricionista);
    }

    public void modificarNutricionista(Nutricionista nutricionista) {
        dao.modificarNutricionista(nutricionista);
    }

    public void eliminarNutricionista(int id) {
        dao.eliminarNutricionista(id);
    }
}
