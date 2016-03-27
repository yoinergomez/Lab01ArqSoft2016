package com.udea.edu.laboratorio1.negocio;

import com.udea.edu.laboratorio1.modelo.Vehiculo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author frank.castrillon
 */
@Local
public interface VehiculoDAOLocal {

    public void addVehiculo(Vehiculo vehiculo);
    public void deleteVehiculo(String placa);
    public void editVehiculo(Vehiculo vehiculo);
    public Vehiculo getVehiculo(String vehiculoPlaca);
    public List<Vehiculo> getAllVehiculo();
    public List<Vehiculo> getAllVehiculoDisponible();
    public List<Vehiculo> getAllVehiculoEstado(int est);
    
}
