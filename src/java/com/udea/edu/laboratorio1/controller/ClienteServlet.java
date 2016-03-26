/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.edu.laboratorio1.controller;

import com.udea.edu.laboratorio1.modelo.Cliente;
import com.udea.edu.laboratorio1.negocio.ClienteDAOLocal;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author esteban
 */
public class ClienteServlet extends HttpServlet {

    @EJB
    private ClienteDAOLocal clienteDAO;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String action = request.getParameter("action");
            String documento = request.getParameter("documento");
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String direccion = request.getParameter("direcion");
            String telefono = request.getParameter("telefono");
            Cliente clienteAux = new Cliente(documento, nombre, apellido, direccion, telefono);
            if ("Añadir".equalsIgnoreCase(action)) {
                String newCliente = clienteDAO.getCliente(documento).getNumeroDocumento();
                if (!newCliente.isEmpty()) {
                    out.println("<script>"); 
                    out.println("alert('El cliente ya existe.')"); 
                    out.println("</script>"); 
                    return;
                } else if (documento.isEmpty()) {
                    out.println("<script>"); 
                    out.println("alert('Numero de documento es requerido')"); 
                    out.println("</script>");
                    return;
                } else if (nombre.isEmpty()) {
                    out.println("<script>"); 
                    out.println("alert('El nombre es requerido.')"); 
                    out.println("</script>");
                    return;
                } else if (apellido.isEmpty()) {
                    out.println("<script>"); 
                    out.println("alert('El apellido es requerido.')"); 
                    out.println("</script>");
                    return;
                }
                clienteDAO.addCliente(clienteAux);
            } else if ("Editar".equalsIgnoreCase(action)) {
                clienteDAO.editCliente(clienteAux);
            } else if ("Buscar".equalsIgnoreCase(action)) {
                clienteAux = clienteDAO.getCliente(documento);
                if (clienteAux.getNumeroDocumento().isEmpty()) {
                    out.println("<script>"); 
                    out.println("alert('El cliente no existe.')"); 
                    out.println("</script>");
                    return;
                } else {
                    request.setAttribute("cliente", clienteAux);
                }
            } else if ("Eliminar".equalsIgnoreCase(action)) {
                clienteDAO.deleteCliente(clienteAux);
            }
                
            request.setAttribute("clientes", clienteDAO.getAllClientes());
            request.getRequestDispatcher("cliente.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
    }
    
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    
    
}
