package com.udea.edu.laboratorio1.negocio;

import com.udea.edu.laboratorio1.modelo.Vehiculo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author frank.castrillon
 */
@Stateless
public class VehiculoDAO implements VehiculoDAOLocal {
    @PersistenceContext(unitName = "Laboratorio1_2PU")
    private EntityManager em;

    @Override
    public void addVehiculo(Vehiculo vehiculo) {
        em.persist(vehiculo);
    }

    @Override
    public void deleteVehiculo(String placa) {
        Vehiculo vehiculo = em.find(Vehiculo.class, placa);
        em.remove(vehiculo);
    }

    @Override
    public void editVehiculo(Vehiculo vehiculo) {
        em.merge(vehiculo);
    }

    @Override
    public Vehiculo getVehiculo(String vehiculoPlaca) {
        return em.find(Vehiculo.class, vehiculoPlaca);
    }

    @Override
    public List<Vehiculo> getAllVehiculo() {
        return em.createNamedQuery("Vehiculo.getAll").getResultList();
    }

    public void persist(Object object) {
        em.persist(object);
    }

    @Override
    public List<Vehiculo> getAllVehiculoDisponible() {
        return em.createNamedQuery("Vehiculo.getAllDisponible").getResultList();
    }
    
    @Override
    public List<Vehiculo> getAllVehiculoEstado(int est) {
       Query queryVehiculosPorEstado = em.createNamedQuery("Vehiculo.getAllPorestado");
       queryVehiculosPorEstado.setParameter("estado", est);
       return queryVehiculosPorEstado.getResultList();
    }



}
