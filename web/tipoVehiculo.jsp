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
       
        <title>Tipo vehiculo</title>
    </head>
    <body>
        
        <ul class="nav nav-tabs">
            <li><a href="index.jsp">Inicio</a></li>
            <li><a href="ClienteServlet">Clientes</a></li>
            <li><a href="TipoVehiculoServlet">Tipo de vehiculos</a></li>
            <li><a href="VehiculoServlet">Inventario vehiculos</a></li>
            <li><a href="VentasServlet">Lista de ventas</a></li>
        </ul>
        
        <div class="container-well">
            <form action="./TipoVehiculoServlet" method="POST" enctype="multipart/form-data">
                <table>
                    <tr>
                        <th>Codigo</th>
                        <th><input type="text" name="idTipoVehiculo" class="form-control" placeholder="Codigo"/></th>
                    </tr>
                    <tr>
                        <th>Marca</th>
                        <th><input type="text" name="marca" class="form-control" placeholder="Marca"/></th>
                    </tr>
                    <tr>
                        <th>Modelo</th>
                        <th><input type="text" name="modelo" class="form-control" placeholder="Modelo"/></th>
                    </tr>
                    <tr>
                        <th>Precio</th>
                        <th><input type="text" name="precio" class="form-control" placeholder="Precio"/></th>
                    </tr>
                    <tr>
                        <th>Cantidad</th>
                        <th><input type="text" name="cantidad" class="form-control" placeholder="Cantidad"/></th>
                    </tr>
                    <tr>
                        <th>Imagen</th>
                        <th><input type="file" name="imagen" class="form-control"></th>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="submit" name="action" value="Add"/>
                            <input type="submit" name="action" value="Edit"/>
                            <input type="submit" name="action" value="Delete"/>
                        </td>
                    </tr>
                </table> 
            </form>
            <table class="table table-stripped">
                <th>Codigo</th>
                <th>Marca</th>
                <th>Modelo</th>
                <th>Precio</th>
                <th>Cantidad</th>
                <th>Imagen</th>

                <c:forEach items="${tipoVehiculo}" var="tipoVehiculo"> 
                    <tr>
                        <td>${tipoVehiculo.id}</td>
                        <td>${tipoVehiculo.marca}</td>
                        <td>${tipoVehiculo.modelo}</td>
                        <td>${tipoVehiculo.precio}</td>
                        <td>${tipoVehiculo.cantidad}</td>
                        <td><img width="150" height="100" src="images/${tipoVehiculo.id}"></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
