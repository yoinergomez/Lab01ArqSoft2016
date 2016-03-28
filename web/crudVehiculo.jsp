<%-- 
    Document   : crudVehiculo
    Created on : 24/03/2016, 07:51:50 PM
    Author     : Pc1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <!-- Optional theme -->
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

        <title>Lista vehiculos</title>
    </head>
    <body>
        <div class="navbar">
            <div class="navbar-inner">
                <a href="#" class="brand">Venta de Vehiculos</a>
                <ul class="nav">
                    <li><a href="index.jsp">Inicio</a></li>
                    <li><a href="ClienteServlet">Clientes</a></li>
                    <li><a href="TipoVehiculoServlet">Tipo de vehiculos</a></li>
                    <li class="active"><a href="#">Inventario vehiculos</a></li>
                    <li><a href="VentasServlet">Lista de ventas</a></li>
                </ul>
            </div>
        </div>
        <div class="container well">
            <h1>Lista vehiculos</h1>
            <h4>Mensaje: ${message}</h4>
            <form action="./VehiculoServlet" method="POST">
                <div class="row-fluid">
                    <div class="span4">
                        <h5>Placa</h5>
                        <input type="text" name="placa" class="form-control" placeholder="Placa" value="${vehiculo.placa}"/>
                        <h5> Color</h5>
                        <input type="text" name="color" class="form-control" placeholder="Color" value="${vehiculo.color}"/>
                    </div>
                    <div class="span4">
                        <h5>Tipo vehiculo</h5>
                        
                            <select name="idTipoV">
                                <option value="--">Seleccione el tipo de vehiculo</option>
                                <c:forEach items="${allTipoVeh}" var="tipoVe">
                                    <option value="${tipoVe.id}">Marca: ${tipoVe.marca} 
                                        Modelo: ${tipoVe.modelo}</option>
                                    </c:forEach>
                            </select>
                        
                        <h5> Estado </h5>
                        <select name="estado">
                                <option value="0">Disponible</option>
                                <option value="1">Vendido</option>
                        </select>
                        
                    </div>
                    <div class="span4">
                            <input type="submit" name="action" value="Agregar" class="btn btn-primary btn-block"/>
                            <input type="submit" name="action" value="Editar" class="btn btn-primary btn-block"/>
                            <input type="submit" name="action" value="Eliminar" class="btn btn-primary btn-block"/>
                            <input type="submit" name="action" value="Buscar por placa" class="btn btn-primary btn-block"/>
                            <input type="submit" name="action" value="Buscar todo" class="btn btn-primary btn-block"/>
                            <input type="submit" name="action" value="Buscar vehiculos por estado" class="btn btn-primary btn-block"/>
                    </div>
                </div>
            </form>
            <br>
            <table class="table table-striped table-bordered table-hover table-condensed">
                <th>Placa</th>
                <th>Color</th>
                <th>Estado</th>
                <th>Marca</th>
                <th>Modelo</th>
                <th>Precio</th>
                <th>Imagen</th>

                <c:forEach items="${allVehiculo}" var="veh">
                    <tr>
                        <td>${veh.placa}</td>
                        <td>${veh.color}</td>

                        <c:if test="${veh.estado==0}">
                            <c:set var="estadoStr" value="Disponible"/>
                        </c:if>
                        <c:if test="${veh.estado==1}">
                            <c:set var="estadoStr" value="Vendido"/>
                        </c:if>
                        <td>${estadoStr}</td>
                        <td>${veh.tipoVehiculo.marca}</td>
                        <td>${veh.tipoVehiculo.modelo}</td>
                        <td>${veh.tipoVehiculo.precio}</td>
                        <td><img width="150" height="100" src="images/${veh.tipoVehiculo.id}"></td>

                    </tr>
                </c:forEach>

            </table>
        </div>
    </body>
</html>
