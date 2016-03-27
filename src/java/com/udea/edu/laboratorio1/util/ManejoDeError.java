/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.edu.laboratorio1.util;

/**
 *
 * @author Pc1
 */
public class ManejoDeError {

    private boolean correcto;
    private Object valor;
    private String mensaje;

    public ManejoDeError(boolean correcto, Object valor, String mensaje) {
        this.correcto = correcto;
        this.valor = valor;
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public boolean isCorrecto() {
        return correcto;
    }

    public void setCorrecto(boolean esCorrecto) {
        this.correcto = esCorrecto;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

}
