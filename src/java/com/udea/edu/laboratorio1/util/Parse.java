/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.edu.laboratorio1.util;

/**
 *
 * @author esteban
 */
public class Parse {
    
    public int stringTOint(String string){
        int entero = 0;
        try{
            entero = Integer.parseInt(string);
        } catch(NullPointerException e){
            System.out.println("El string a convertir es nulo");
        } catch(NumberFormatException e){
            System.out.println("El string a convertir es vacio");
        }
        return entero;
    }
}
