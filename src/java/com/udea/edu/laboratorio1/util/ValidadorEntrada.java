/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.edu.laboratorio1.util;

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
    
//    public String errorTipoVehiculo(TipoVehiculo tv){
//        String mensaje = "Ingrese: ";
//        StringBuffer atributosVacios = new StringBuffer(" ");
//        
//        if(tv.getId().isEmpty()){
//            atributosVacios.append("codigo,");
//        }
//        
//        if(tv.getMarca().isEmpty()){
//            atributosVacios.append("marca,");
//        }
//        
//        if(tv.getModelo().isEmpty()){
//            atributosVacios.append("modelo,");
//        }
//        atributosVacios.deleteCharAt(atributosVacios.length()-1);
//
//    }
    
    public String crearMensajeScript(String string){
        String script1 = "<script type=\"text/javascript\"> alert('";
        String script2 = "'); </script>";
        
        return script1+string+script2;
    }
    
}
