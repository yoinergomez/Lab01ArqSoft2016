/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.edu.laboratorio1.negocio;

import com.udea.edu.laboratorio1.modelo.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author esteban
 */
@Stateless
public class ClienteDAO implements ClienteDAOLocal {

    @PersistenceContext(unitName = "Laboratorio1_2PU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void addCliente(Cliente cliente) {
        em.persist(cliente);
    }

    @Override
    public void editCliente(Cliente cliente) {
      em.merge(cliente);
    }

    @Override
    public void deleteCliente(Cliente cliente) {
        cliente = em.find(Cliente.class, cliente.getNumeroDocumento());
        em.remove(cliente);
    }

    @Override
    public Cliente getCliente(String numeroDocumento) {
        return em.find(Cliente.class, numeroDocumento);
    }

    @Override
    public List<Cliente> getAllClientes() {
        return em.createNamedQuery("Cliente.getAll").getResultList();
    }
    
}
