/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.edu.laboratorio1.controller;

import com.udea.edu.laboratorio1.modelo.TipoVehiculo;
import com.udea.edu.laboratorio1.negocio.TipoVehiculoDAOLocal;
import com.udea.edu.laboratorio1.util.Parse;
import com.udea.edu.laboratorio1.util.ValidadorEntrada;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author esteban
 */
@MultipartConfig(maxFileSize=16177215)
public class TipoVehiculoServlet extends HttpServlet {

    @EJB
    private TipoVehiculoDAOLocal tipoVehiculoDAO;

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
            String id = request.getParameter("idTipoVehiculo");
            String modelo = request.getParameter("modelo");
            String marca = request.getParameter("marca");
            String precioStr = request.getParameter("precio");
            String cantidadStr = request.getParameter("cantidad");
            
            
            //Parseando los datos string a int
            Parse parse = new Parse();
            ValidadorEntrada validar = new ValidadorEntrada();
            int precio = parse.stringAint(precioStr);
            int cantidad = parse.stringAint(cantidadStr);
       
            
            //Capturando la acción
            String action = request.getParameter("action");
            action = parse.aMinuscula(action);
            
            
            TipoVehiculo tipoVehiculo;
            Part part;
            byte[] imagen;
            switch(action){
                case "add":
                    //Leyendo la imagen
                    part = request.getPart("imagen");
                    imagen = parse.leerImagen(part);
                    
                    //Añadiendo un tipo de vehiculo
                    tipoVehiculo = new TipoVehiculo(id, marca, modelo, precio, cantidad, imagen);
                    if(validar.esValidoTipoVehiculo(tipoVehiculo)){
                        tipoVehiculoDAO.addTipoVehiculo(tipoVehiculo);
                    } else {
                        String error = validar.crearMensajeScript(
                                "Ingrese correctamente los datos "
                                        + "en los campos del formulario");
                        out.println(error);
                    }
                    
                    break;
                    
                case "edit":
                    //Leyendo la imagen
                    part = request.getPart("imagen");
                    imagen = parse.leerImagen(part);
                    
                    //Editando un tipo de vehiculo
                    tipoVehiculo = new TipoVehiculo(id, marca, modelo, precio, cantidad, imagen);
                    if(validar.esValidoTipoVehiculo(tipoVehiculo)){
                        tipoVehiculoDAO.addTipoVehiculo(tipoVehiculo);
                    } else {
                        String error = validar.crearMensajeScript(
                                "Ingrese correctamente los datos "
                                        + "en los campos del formulario");
                        out.println(error);
                    }
                    break;
                case "delete":
                    //Eliminando un tipo de vehiculo
                    tipoVehiculoDAO.deleteTipoVehiculo(id);
                    break;
                    
                default:
                    break;
            }
            
            request.setAttribute("tipoVehiculo", tipoVehiculoDAO.getAllTipoVehiculo());
            request.getRequestDispatcher("tipoVehiculo.jsp").forward(request,
                    response);
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
