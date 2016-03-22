/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.edu.laboratorio1.modelo;

/**
 *
 * @author 
 */
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;

@Entity
@Table(name="TipoVehiculo")
@NamedQueries(@NamedQuery(name="TipoVehiculo.getAll",query="SELECT e FROM TipoVehiculo e"))

public class TipoVehiculo implements Serializable{

    public TipoVehiculo(String id, String marca, String modelo, int precio, int cantidad, byte[] imagen) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.cantidad = cantidad;
        this.imagen = imagen;
    }

    public TipoVehiculo() {
    }
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private String id;
    
    @Column(name="marca")
    private String marca;  
    
    @Column(name="modelo")
    private String modelo;
    
    @Column(name="precio")
    private int precio;
    
    @Column(name="cantidad")
    private int cantidad;
    
    @Column(name="imagen")
    private byte[] imagen;
    
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }
    
    
}
