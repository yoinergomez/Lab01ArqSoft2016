/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.edu.laboratorio1.negocio;


import com.udea.edu.laboratorio1.modelo.Venta;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author esteban
 */
@Stateless
public class VentaDAO implements VentaDAOLocal {

    @PersistenceContext(unitName = "Lab01Arq_Soft2016PU")
    private EntityManager em;
    
    
    @Override
    public void addVenta(Venta venta) {
        em.persist(venta);
    }

    @Override
    public void editVenta(Venta venta) {
      em.merge(venta);
    }

    @Override
    public void deleteVenta(String placa) {
        Venta venta = em.find(Venta.class, placa);
        em.remove(venta);
    }

    @Override
    public Venta getVenta(String placa) {
        return em.find(Venta.class, placa);
    }

    @Override
    public List<Venta> getAllVentas() {
        return em.createNamedQuery("Venta.getAll").getResultList();
    }

    public void persist(Object object) {
        em.persist(object);
    }

}
