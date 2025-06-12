/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.uncuyo.model;
import java.io.Serializable;
import java.util.Date;
import java.util.Random;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.*;
/**
 *
 * @author Paula
 */
@Entity
@Table(name = "Nutricionista", schema = "usuarios")
public class Nutricionista extends Usuario implements Serializable {

    @Column(name = "tarifa", nullable = false, precision = 10, scale = 2)
    private double tarifa;

    @Column(name = "titulo_profesional", nullable = false, length = 100)
    private String tituloProfesional;

    @Column(name = "años_experiencia", nullable = false)
    private int añosExperiencia;

    @Column(name = "disponibilidad", nullable = false, columnDefinition = "TEXT")
    private String disponibilidad;

    // Getters y Setters

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public String getTituloProfesional() {
        return tituloProfesional;
    }

    public void setTituloProfesional(String tituloProfesional) {
        this.tituloProfesional = tituloProfesional;
    }

    public int getAñosExperiencia() {
        return añosExperiencia;
    }

    public void setAñosExperiencia(int añosExperiencia) {
        this.añosExperiencia = añosExperiencia;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
}