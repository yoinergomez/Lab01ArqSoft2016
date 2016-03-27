/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.edu.laboratorio1.util;

import com.udea.edu.laboratorio1.modelo.Cliente;
import com.udea.edu.laboratorio1.modelo.TipoVehiculo;

/**
 *
 * @author esteban
 */
public class ValidadorEntrada {
    
    
    public boolean esValidoTipoVehiculo(TipoVehiculo tv){
        return !(tv.getId().isEmpty() || 
                tv.getMarca().isEmpty() ||
                tv.getModelo().isEmpty() ||
                tv.getCantidad()<0 ||
                tv.getPrecio()<0);
    }
    
    public boolean esValidoCliente(Cliente c){
        return !(c.getNumeroDocumento().isEmpty() ||
                c.getNombre().isEmpty() ||
                c.getApellido().isEmpty());
    }
    
    public String crearMensajeScript(String string){
        String script1 = "<script type=\"text/javascript\"> alert('";
        String script2 = "'); </script>";
        return script1+string+script2;
    }
    
}
