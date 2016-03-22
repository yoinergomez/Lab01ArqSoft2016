/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.edu.Laboratorio1.negocio;

import com.udea.edu.Laboratorio1.modelo.Venta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author esteban
 */
@Local
public interface VentaDAOLocal {
    
    public void addVenta(Venta venta);
    public void editVenta(Venta venta);
    public void deleteVenta(String placa);
    public Venta getVenta(String placa);
    public List<Venta> getAllVentas();
}
