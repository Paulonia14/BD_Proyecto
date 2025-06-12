/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.uncuyo.dao;

import ar.edu.uncuyo.model.Nutricionista;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Paula
 */
public class NutricionistaDAO {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

    public void insertarNutricionista(Nutricionista nutricionista) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            nutricionista.setTipoUsuario("nutricionista");
            em.persist(nutricionista);  
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }


    public List<Nutricionista> getNutricionistas() {
        EntityManager em = emf.createEntityManager();
        List<Nutricionista> nutricionistas = em.createQuery("FROM Cliente", Nutricionista.class).getResultList();
        em.close();
        return nutricionistas;
    }

    public void modificarNutricionista(Nutricionista nutricionistaActualizado) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            
            Nutricionista existente = em.find(Nutricionista.class, nutricionistaActualizado.getId());
            if (existente != null) {
                existente.setNombre(nutricionistaActualizado.getNombre());
                existente.setApellido(nutricionistaActualizado.getApellido());
                existente.setEmail(nutricionistaActualizado.getEmail());
                existente.setContraseña(nutricionistaActualizado.getContraseña());
                existente.setTarifa(nutricionistaActualizado.getTarifa());
                existente.setTituloProfesional(nutricionistaActualizado.getTituloProfesional());
                existente.setAñosExperiencia(nutricionistaActualizado.getAñosExperiencia());
                existente.setDisponibilidad(nutricionistaActualizado.getDisponibilidad());
            }

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void eliminarNutricionista(int idNutricionista) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            Nutricionista nutricionista = em.find(Nutricionista.class, idNutricionista);
            if (nutricionista != null) {
                em.remove(nutricionista); 
            }

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    public List<Nutricionista> obtenerTodos() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("FROM Nutricionista", Nutricionista.class).getResultList();
        } finally {
            em.close();
        }
    }
    public Nutricionista buscarPorId(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Nutricionista.class, id);
        } finally {
            em.close();
        }
    }

}