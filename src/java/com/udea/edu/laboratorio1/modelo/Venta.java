/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.edu.laboratorio1.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Venta")
@NamedQueries(@NamedQuery(name="Venta.getAll",query="SELECT e FROM Venta e"))
public class Venta implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @ManyToOne()
    @JoinColumn(name="numeroDocumento")
    private Cliente cliente;
    @OneToOne()
    @JoinColumn(name="placa")
    private Vehiculo vehiculo;

    public Venta(Date fecha, Cliente cliente, Vehiculo vehiculo) {
        this.fecha = fecha;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
    }

    public Venta() {
    }
    

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    
    
    
}
