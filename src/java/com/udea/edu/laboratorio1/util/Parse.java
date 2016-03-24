/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.edu.laboratorio1.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.Part;

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
            System.out.println("stringTOint: El string a convertir es nulo");
            System.out.println(e.getMessage());
        } catch(NumberFormatException e){
            System.out.println("stringTOint: El string a convertir es vacio");
            System.out.println(e.getMessage());
        } catch(Exception e){
            System.out.println("stringTOint: Error de conversión");
            System.out.println(e.getMessage());
        }
        return entero;
    }
    
    public byte[] leerImagen(Part part){
        
        //Declarando variables
        InputStream inputStream;
        ByteArrayOutputStream buffer;
        byte[] datos = {};
        
        try{
            //Asignación de variables
            inputStream = part.getInputStream();
            buffer = new ByteArrayOutputStream();
            datos = new byte[inputStream.available()];
            
            //Leyendo imagen
            int tamano;
            while ((tamano = inputStream.read(datos, 0, datos.length)) != -1) {
                        buffer.write(datos, 0, tamano);
            }
            
            buffer.flush();
            datos = buffer.toByteArray();
            
            //Cerrando el canal de los Stream
            buffer.close();
            inputStream.close();
            
        } catch(IOException e){
            System.out.println("leerImagen: Error al obtener el InputStream");
            System.out.println(e.getMessage());
        } catch (NullPointerException e){
            System.out.println("leerImagen: El parametro de entrada es nulo");
            System.out.println(e.getMessage());
        } catch (Exception e){
            System.out.println("leerImagen: Error al leer la imagen");
            System.out.println(e.getMessage());
        } 
        
        return datos;
    }
}
