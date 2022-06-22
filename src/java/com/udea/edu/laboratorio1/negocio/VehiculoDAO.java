package com.udea.edu.laboratorio1.negocio;

import com.udea.edu.laboratorio1.modelo.Vehiculo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    public void deleteVehiculo(Vehiculo vehiculo) {
        vehiculo = em.find(Vehiculo.class, vehiculo.getPlaca());
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


}
