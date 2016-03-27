/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.edu.laboratorio1.controller;

import com.udea.edu.laboratorio1.modelo.Cliente;
import com.udea.edu.laboratorio1.negocio.ClienteDAOLocal;
import com.udea.edu.laboratorio1.util.ValidadorEntrada;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
    private boolean flag = true;
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
            String script1 = "<script type=\"text/javascript\"> alert('";
            String script2 = "'); </script>";
            out.println(script1+"Hello a todos"+script2);
            ValidadorEntrada validar = new ValidadorEntrada();
            String action = request.getParameter("action");
            String documento = request.getParameter("documento");
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String direccion = request.getParameter("direcion");
            String telefono = request.getParameter("telefono");
            Cliente clienteAux = new Cliente(documento, nombre, apellido, direccion, telefono);
            if ("Agregar".equalsIgnoreCase(action)) {
                if (validar.esValidoCliente(clienteAux)) {
                    clienteDAO.addCliente(clienteAux);
                }else{
                     String error = validar.crearMensajeScript(
                                "Ingrese correctamente los datos "
                                        + "en los campos del formulario");
                        out.println(error);
                }                    
            } else if ("Editar".equalsIgnoreCase(action)) {
                if (validar.esValidoCliente(clienteAux)) {
                    clienteDAO.editCliente(clienteAux);
                }else{
                     String error = validar.crearMensajeScript(
                                "Ingrese correctamente los datos "
                                        + "en los campos del formulario");
                        out.println(error);
                }         
            } else if ("Buscar".equalsIgnoreCase(action)) {
                if (!documento.isEmpty()) {
                    ArrayList<Cliente>cliente = new ArrayList<>();
                cliente.add(clienteDAO.getCliente(documento));
                request.setAttribute("cliente", cliente);
                flag = false;
                }else{
                    String error = validar.crearMensajeScript(
                                "Ingrese correctamente el numero de documento ");
                        out.println(error);
                }
                
            } else if ("Eliminar".equalsIgnoreCase(action)) {
                if (validar.esValidoCliente(clienteAux)) {
                    clienteDAO.deleteCliente(clienteAux);
                }else{
                     String error = validar.crearMensajeScript(
                                "Ingrese correctamente los datos "
                                        + "en los campos del formulario");
                        out.println(error);
                } 
            }
            if (flag) {
                request.setAttribute("cliente", clienteDAO.getAllClientes());
            }
            flag = true;
            request.getRequestDispatcher("cliente.jsp").forward(request,response);
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
