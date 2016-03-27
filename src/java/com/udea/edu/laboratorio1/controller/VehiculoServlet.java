/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.edu.laboratorio1.controller;

import com.udea.edu.laboratorio1.modelo.TipoVehiculo;
import com.udea.edu.laboratorio1.modelo.Vehiculo;
import com.udea.edu.laboratorio1.negocio.TipoVehiculoDAOLocal;
import com.udea.edu.laboratorio1.negocio.VehiculoDAOLocal;
import com.udea.edu.laboratorio1.util.ManejoDeError;
import com.udea.edu.laboratorio1.util.Parse;
import com.udea.edu.laboratorio1.util.ValidadorEntrada;
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
public class VehiculoServlet extends HttpServlet {

    @EJB
    private VehiculoDAOLocal vehiculoDAO;
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
                    
        //Captura de valores del 
            String placa = request.getParameter("placa");
            String color = request.getParameter("color");
            String idTipoVehiculo = (String) request.getParameter("idTipoV");
            String estadoStr = request.getParameter("estado");
            
            //Parseando los datos a int
            Parse parse = new Parse();
            ValidadorEntrada validar = new ValidadorEntrada();
            int estado=parse.stringAint(estadoStr);
            
            //Capturando la acción
            String action = request.getParameter("action");
            action = parse.aMinuscula(action);
            
            String mensaje="";
            TipoVehiculo tipoVehiculo;
            Vehiculo vehiculo=new Vehiculo();
            List<Vehiculo> v=new ArrayList();
            ManejoDeError manejoDeError;
            //capturando cada posible caso del action
            if("Agregar".equalsIgnoreCase(action)){
                 //validando que el objeto tipoVehiculo sea correcto
                tipoVehiculo=tipoVehiculoDAO.getTipoVehiculo(idTipoVehiculo);
                manejoDeError=validar.esVacioTipovehiculo(tipoVehiculo);
                if(manejoDeError.isCorrecto()==true){
                    //validando que el objeto vehiculo sea correcto
                    vehiculo=new Vehiculo(placa, color, tipoVehiculo, estado);
                    manejoDeError=validar.esValidoVehiculo(vehiculo);
                    if(manejoDeError.isCorrecto()==true){
                        //agregando el vehiculo
                        vehiculoDAO.addVehiculo(vehiculo);
                    }
                    mensaje=manejoDeError.getMensaje();
                    
                }else{
                   mensaje=manejoDeError.getMensaje();
                }
            }else if("Editar".equalsIgnoreCase(action)){
                //validando que el objeto tipoVehiculo sea correcto
                tipoVehiculo=tipoVehiculoDAO.getTipoVehiculo(idTipoVehiculo);
                manejoDeError=validar.esVacioTipovehiculo(tipoVehiculo);
                if(manejoDeError.isCorrecto()==true){
                    //validando que el objeto vehiculo sea correcto
                    vehiculo=new Vehiculo(placa, color, tipoVehiculo, estado);
                    manejoDeError=validar.esValidoVehiculo(vehiculo);
                    if(manejoDeError.isCorrecto()==true){
                        //modificando el vehiculo
                        vehiculoDAO.editVehiculo(vehiculo);
                    }
                    mensaje=manejoDeError.getMensaje();
                    
                }else{
                   mensaje=manejoDeError.getMensaje();
                }
                
            }else if("Eliminar".equalsIgnoreCase(action)){
                //verficando que la placa ingresada tenga un vehiculo asociado
                vehiculo = vehiculoDAO.getVehiculo(placa);
                manejoDeError=validar.esValidoVehiculo(vehiculo);
                if(manejoDeError.isCorrecto()){
                    //eliminando vehiculo
                    vehiculoDAO.deleteVehiculo(placa); 
                }else{
                    mensaje=manejoDeError.getMensaje();
                }
            }else if("Buscar por placa".equalsIgnoreCase(action)){
                //buscando un vehiculo con la placa ingresada
                vehiculo = vehiculoDAO.getVehiculo(placa);
                manejoDeError=validar.esValidoVehiculo(vehiculo);
                if(manejoDeError.isCorrecto()){
                    //cargando a la tabla el resultado de la busqueda
                    v.clear();
                    v.add(vehiculo);
                    request.setAttribute("allVehiculo", v);

                }else{
                    mensaje=manejoDeError.getMensaje();
                    request.setAttribute("allVehiculo", vehiculoDAO.getAllVehiculo());
         
                }
                
                //actualizar la lista de Tipo de Vehiculos en la pagina
                request.setAttribute("allTipoVeh", tipoVehiculoDAO.getAllTipoVehiculo());
                //actualizar el mensaje en le pagina
                request.setAttribute("message", mensaje);
                //refrescar la pagina
                request.getRequestDispatcher("/crudVehiculo.jsp").forward(request, response);
            }else if("Buscar vehiculos por estado".equalsIgnoreCase(action)){
                //buscando la lista de vehiculos de acuerdo al estado ingresado
                v.clear();
                v=vehiculoDAO.getAllVehiculoEstado(estado);
                 request.setAttribute("allVehiculo", v);
                
                //actualizar la lista de Tipo de Vehiculos en la pagina
                request.setAttribute("allTipoVeh", tipoVehiculoDAO.getAllTipoVehiculo());
                //actualizar el mensaje en le pagina
                request.setAttribute("message", mensaje);
                //refrescar la pagina
                request.getRequestDispatcher("/crudVehiculo.jsp").forward(request, response);
            }
            
            //actualizar los datos a la vista y refresacar la pagina
            request.setAttribute("vehiculo", vehiculo); //llamo solo 1 objeto
            request.setAttribute("allTipoVeh", tipoVehiculoDAO.getAllTipoVehiculo());
            request.setAttribute("allVehiculo", vehiculoDAO.getAllVehiculo());
            request.setAttribute("message", mensaje);
            request.getRequestDispatcher("crudVehiculo.jsp").forward(request, response);

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
