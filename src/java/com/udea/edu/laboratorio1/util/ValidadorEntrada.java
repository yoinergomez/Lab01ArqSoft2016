/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.edu.laboratorio1.util;

import com.udea.edu.laboratorio1.modelo.Cliente;
import com.udea.edu.laboratorio1.modelo.TipoVehiculo;
import com.udea.edu.laboratorio1.modelo.Vehiculo;

/**
 *
 * @author esteban
 */
public class ValidadorEntrada {

    public boolean esValidoTipoVehiculo(TipoVehiculo tv) {
        return !(tv.getId().isEmpty()
                || tv.getMarca().isEmpty()
                || tv.getModelo().isEmpty()
                || tv.getCantidad() < 0
                || tv.getPrecio() < 0);
    }

    public ManejoDeError esValidoVehiculo(Vehiculo v) {
        ManejoDeError manejoDeError;
        boolean valido;
        String mens;
        if (v != null) {
            valido = true;
            mens = "La operación se realizo con exito";
            if(v.getPlaca().isEmpty()){
                valido=false;
                mens="No se puede realizar la operación.El campo placa esta vacio";
            }
        }else{
            valido = false;
            mens = "No existe vehiculo asociado con la placa.No se ha ingresado "
                    + "la placa o se ha digitado mal";
        } 

        manejoDeError = new ManejoDeError(valido, v, mens);
        return manejoDeError;

    }

    public ManejoDeError esVacioTipovehiculo(TipoVehiculo tv) {
        ManejoDeError manejoDeError;
        boolean vacio;
        String mens = "";
        if (tv != null) {
            vacio = false;
            mens="La operación se realizo con exito";
        } else {
            vacio = true;
            mens = "No se pudo realizar la operación.Seleccione por favor un tipo"
                    + " de vehiculo";
        }
        manejoDeError = new ManejoDeError(!vacio, tv, mens);
        return manejoDeError;

    }

    public boolean esValidoCliente(Cliente c){
        return !(c.getNumeroDocumento().isEmpty() ||
                c.getNombre().isEmpty() ||
                c.getApellido().isEmpty());
    }

    public String crearMensajeScript(String string) {
        String script1 = "<script type=\"text/javascript\"> alert('";
        String script2 = "'); </script>";

        return script1 + string + script2;
    }

}
