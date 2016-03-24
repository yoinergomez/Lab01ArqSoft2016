/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.edu.laboratorio1.negocio;

import com.udea.edu.laboratorio1.modelo.TipoVehiculo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author frank.castrillon
 */
@Local
public interface TipoVehiculoDAOLocal {
    public void addTipoVehiculo(TipoVehiculo tipoVehiculo);
    public void deleteTipoVehiculo(TipoVehiculo tipoVehiculo);
    public void editTipoVehiculo(TipoVehiculo tipoVehiculo);
    public TipoVehiculo getTipoVehiculo(String tipoVehiculoId);
    public List<TipoVehiculo> getAllTipoVehiculo();
}
