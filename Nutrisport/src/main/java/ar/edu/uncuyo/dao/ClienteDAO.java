/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.uncuyo.dao;

/**
 *
 * @author Paula
 */

import ar.edu.uncuyo.model.Cliente;
import javax.persistence.*;
import java.util.List;

public class ClienteDAO {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

    public void insertarCliente(Cliente cliente) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            cliente.setTipoUsuario("cliente");
            em.persist(cliente);  
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }


    public List<Cliente> getClientes() {
        EntityManager em = emf.createEntityManager();
        List<Cliente> clientes = em.createQuery("FROM Cliente", Cliente.class).getResultList();
        em.close();
        return clientes;
    }

    public void modificarCliente(Cliente clienteActualizado) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            
            Cliente existente = em.find(Cliente.class, clienteActualizado.getId());
            if (existente != null) {
                existente.setNombre(clienteActualizado.getNombre());
                existente.setApellido(clienteActualizado.getApellido());
                existente.setEmail(clienteActualizado.getEmail());
                existente.setContraseña(clienteActualizado.getContraseña());
                existente.setFechaNacimiento(clienteActualizado.getFechaNacimiento());
                existente.setGenero(clienteActualizado.getGenero());
                existente.setObjetivo(clienteActualizado.getObjetivo());
                existente.setTipoActividad(clienteActualizado.getTipoActividad());
                existente.setFrecuenciaActividad(clienteActualizado.getFrecuenciaActividad());
            }

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void eliminarCliente(int idCliente) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            Cliente cliente = em.find(Cliente.class, idCliente);
            if (cliente != null) {
                em.remove(cliente); 
            }

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    public List<Cliente> obtenerTodos() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("FROM Cliente", Cliente.class).getResultList();
        } finally {
            em.close();
        }
    }
    public Cliente buscarPorId(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Cliente.class, id);
        } finally {
            em.close();
        }
    }

}
