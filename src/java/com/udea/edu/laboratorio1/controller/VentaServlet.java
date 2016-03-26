/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.edu.laboratorio1.controller;

import com.udea.edu.laboratorio1.modelo.Vehiculo;
import com.udea.edu.laboratorio1.negocio.VehiculoDAOLocal;
import com.udea.edu.laboratorio1.negocio.VentaDAOLocal;
import com.udea.edu.laboratorio1.util.Parse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author esteban
 */
public class VentaServlet extends HttpServlet {

    @EJB
    private VehiculoDAOLocal vehiculoDAO;

    @EJB
    private VentaDAOLocal ventaDAO;
    

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
            
            //Captura de valores del formulario
            String placa = request.getParameter("placa");
            
            //Capturando la acción
            Parse parse = new Parse();
            String action = request.getParameter("action");
            action = parse.aMinuscula(action);
            
            
            switch(action){
                case "buscar":
                    if(!placa.isEmpty()){
                        List<Vehiculo> vehiculo = new ArrayList<Vehiculo>();
                        vehiculo.add(vehiculoDAO.getVehiculo(placa));
                        request.setAttribute("getAllVehiculo", vehiculo);
                    } else{
                        request.setAttribute("getAllVehiculo", vehiculoDAO.getAllVehiculoDisponible());
                    }
                    break;
                    
                case "comprar":
                    
                    break;
   
                    
                default:
                    request.setAttribute("getAllVehiculo", vehiculoDAO.getAllVehiculoDisponible());
                    break;
            }  
            
            //Redireccionamiento de página jsp
            request.getRequestDispatcher("venta.jsp").forward(request,response);
            
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
