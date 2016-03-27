/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.edu.laboratorio1.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;

@Entity
@Table(name="Vehiculo")
@NamedQueries({
    @NamedQuery(name="Vehiculo.getAll",query="SELECT ve FROM Vehiculo ve"),
    @NamedQuery(name="Vehiculo.getAllDisponible",query="SELECT ve FROM Vehiculo ve WHERE ve.estado = 0"),
    @NamedQuery(name="Vehiculo.getAllPorestado",query="SELECT v FROM Vehiculo v WHERE v.estado = :estado")
})
public class Vehiculo implements Serializable{

    public Vehiculo() {
    }

    public Vehiculo(String placa, String color, TipoVehiculo tipoVehiculo, int estado) {
        this.placa = placa;
        this.color = color;
        this.tipoVehiculo = tipoVehiculo;
        this.estado=estado;
    }
    
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="placa")
    private String placa;
    
    @Column(name="color")
    private String color;
    
    @Column(name="estado")
    private int estado;
    
    @ManyToOne()
    @JoinColumn(name= "TipoVehiculo")
    private TipoVehiculo tipoVehiculo;

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
}

