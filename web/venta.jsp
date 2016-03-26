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
            <li><a href="VentaServlet">Realizar venta</a></li>
            <li><a href="VentaServlet">Lista de ventas</a></li>
        </ul>
        
        <div class="container-well">
            <form action="./TipoVehiculoServlet" method="POST">
                <table>
                    <tr>
                        <th>Placa: </th>
                        <th><input type="text" name="placa" class="form-control" placeholder="Placa"/></th>
                    </tr>
                    <tr>
                        <td><input type="submit" name="action" value="Buscar"/></td>
                    </tr>
                </table> 
            </form>
            <table class="table table-stripped">
                <th>Placa</th>
                <th>Color</th>
                <th>Tipo Vehiculo</th>
                <th></th>
                
                <c:forEach items="${getAllVehiculo}" var="vehiculo">
                    <tr>
                        <td >${vehiculo.placa}</td>
                        <td >${vehiculo.color}</td>
                        <td >${vehiculo.estado}</td>  
                        <td ><input type="submit" name="action" value="Comprar"/></td>  
                    </tr>                      
                </c:forEach>    
                
                    
            </table>
        </div>
    </body>
</html>
