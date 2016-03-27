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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="style.css">
        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        
        <title>Lista vehiculos</title>
    </head>
    <body>
        <div class="container well">
            <h1>Lista vehiculos</h1>
            <h1>Mensaje:${message}</h1>
            <form action="./VehiculoServlet" method="POST">
                <table>
                    <tr>
                        <th> Placa </th>
                        <th><input type="text" name="placa" class="form-control" placeholder="Placa" value="${vehiculo.placa}"/></th>
                    </tr>
                    <tr>
                        <th> Color</th>
                        <th><input type="text" name="color" class="form-control" placeholder="Color" value="${vehiculo.color}"/></th>
                    </tr>
                    <tr>
                        <th> Tipo vehiculo </th>
                        <th>
                            <select name="idTipoV">
                                <option value="--">Seleccione el tipo de vehiculo</option>
                            <c:forEach items="${allTipoVeh}" var="tipoVe">
                                <option value="${tipoVe.id}">Marca: ${tipoVe.marca} 
                                        Modelo: ${tipoVe.modelo}</option>
                            </c:forEach>
                            </select>
                        </th>
                    </tr>
                    <tr>
                        <th> Estado </th>
                        <th> <select name="estado">
                                <option value="0">Disponible</option>
                                <option value="1">Vendido</option>
                            </select>
                        </th>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="submit" name="action" value="Agregar"/>
                            <input type="submit" name="action" value="Editar"/>
                            <input type="submit" name="action" value="Eliminar"/>
                            <input type="submit" name="action" value="Buscar por placa"/>
                            <input type="submit" name="action" value="Buscar todo"/>
                            <input type="submit" name="action" value="Buscar vehiculos por estado"/>
                        </td>
                    </tr>
                </table>
            </form>
            <br>
            <table class="table table-striped">
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
