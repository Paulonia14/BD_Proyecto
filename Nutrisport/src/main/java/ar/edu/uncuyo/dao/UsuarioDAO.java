/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.uncuyo.dao;

/**
 *
 * @author Paula
 */
import ar.edu.uncuyo.model.Usuario;

import javax.persistence.*;

public class UsuarioDAO {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

    public Usuario autenticarAdministrador(String email, String contraseña) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Usuario> query = em.createQuery(
                "SELECT u FROM Usuario u WHERE u.email = :email AND u.contraseña = :password AND u.tipoUsuario = 'administrador'", 
                Usuario.class);
            query.setParameter("email", email);
            query.setParameter("password", contraseña);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    public Usuario autenticarCliente(String email, String contraseña) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Usuario> query = em.createQuery(
                "SELECT u FROM Usuario u WHERE u.email = :email AND u.contraseña = :password AND u.tipoUsuario = 'cliente'", 
                Usuario.class);
            query.setParameter("email", email);
            query.setParameter("password", contraseña);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
    public Usuario autenticarNutricionista(String email, String contraseña) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Usuario> query = em.createQuery(
                "SELECT u FROM Usuario u WHERE u.email = :email AND u.contraseña = :password AND u.tipoUsuario = 'nutricionista'", 
                Usuario.class);
            query.setParameter("email", email);
            query.setParameter("password", contraseña);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

}