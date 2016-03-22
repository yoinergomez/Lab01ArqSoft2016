/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.edu.Laboratorio1.negocio;

import com.udea.edu.Laboratorio1.modelo.Cliente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author esteban
 */
@Local
public interface ClienteDAOLocal {
    
    public void addCliente(Cliente cliente);
    public void editCliente(Cliente cliente);
    public void deleteCliente(Cliente cliente);
    public Cliente getCliente(String numeroDocumento);
    public List<Cliente> getAllClientes();
    
}
