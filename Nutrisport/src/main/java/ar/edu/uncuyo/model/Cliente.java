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
@Table(name = "Cliente", schema = "usuarios")
public class Cliente extends Usuario implements Serializable {

    @Column(name = "fecha_nac", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    @Column(name = "genero", nullable = false, length = 1)
    private char genero;

    @Column(name = "objetivo", nullable = false, columnDefinition = "TEXT")
    private String objetivo;

    @Column(name = "tipo_actividad", nullable = false, columnDefinition = "TEXT")
    private String tipoActividad;

    @Column(name = "frecuencia_actividad", nullable = false, length = 100)
    private String frecuenciaActividad;

    // Getters y Setters

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(String tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    public String getFrecuenciaActividad() {
        return frecuenciaActividad;
    }

    public void setFrecuenciaActividad(String frecuenciaActividad) {
        this.frecuenciaActividad = frecuenciaActividad;
    }
}