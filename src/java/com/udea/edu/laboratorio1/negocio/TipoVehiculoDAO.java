package com.udea.edu.laboratorio1.negocio;

import com.udea.edu.laboratorio1.modelo.TipoVehiculo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author frank.castrillon
 */
@Stateless
public class TipoVehiculoDAO implements TipoVehiculoDAOLocal {
    @PersistenceContext(unitName = "Laboratorio1_2PU")
    private EntityManager em;

    @Override
    public void addTipoVehiculo(TipoVehiculo tipoVehiculo) {
        em.persist(tipoVehiculo);
    }

    @Override
    public void deleteTipoVehiculo(TipoVehiculo tipoVehiculo) {
        tipoVehiculo = em.find(TipoVehiculo.class, tipoVehiculo.getId());
        em.remove(tipoVehiculo);
    }

    @Override
    public void editTipoVehiculo(TipoVehiculo tipoVehiculo) {
        em.merge(tipoVehiculo);
    }

    @Override
    public TipoVehiculo getTipoVehiculo(String tipoVehiculoId) {
        return em.find(TipoVehiculo.class, tipoVehiculoId);
    }

    @Override
    public List<TipoVehiculo> getAllTipoVehiculo() {
        return em.createNamedQuery("TipoVehiculo.getAll").getResultList();
    }

    public void persist(Object object) {
        em.persist(object);
    }

    
    
}
