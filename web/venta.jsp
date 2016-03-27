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
        <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
       
        <title>Tipo vehiculo</title>
    </head>
    <body>       
        <script>
            $(document).ready(function(){
                var row;
                $("table tr input").on('click', function(e){
                    row = ($(this).closest('td').parent()[0].sectionRowIndex)-1;
                    $("#formVenta").find("input[name=itemSeleccionado]").val(row);
                });
            });
        </script>
        
        <ul class="nav nav-tabs">
            <li><a href="index.jsp">Inicio</a></li>
            <li><a href="ClienteServlet">Clientes</a></li>
            <li><a href="TipoVehiculoServlet">Tipo de vehiculos</a></li>
            <li><a href="VehiculoServlet">Inventario vehiculos</a></li>
            <li><a href="VentaServlet">Realizar venta</a></li>
            <li><a href="VentaServlet">Lista de ventas</a></li>
        </ul>
        
        <div class="container-well">
            <form id="formVenta" action="./VentaServlet" method="POST">
                
                <input type="text" name="itemSeleccionado" style="display:none">
                
                <table>
                    <tr>
                        <th>Placa: </th>
                        <th><input type="text" name="placa" class="form-control" placeholder="Placa"/></th>
                        <th><input type="submit" name="action" value="Buscar"/></th>
                    </tr>
                </table> 
                
                <table class="table table-stripped" id="table1">
                    <tr>
                    <th>Placa</th>
                    <th>Color</th>
                    <th>Marca</th>
                    <th>Modelo</th>
                    <th>Precio</th>
                    <th>Imagen</th>
                    <th></th>
                    </tr>
                    <c:forEach items="${getAllVehiculo}" var="vehiculo">
                        <tr>
                            <td id="placaVehiculo">${vehiculo.placa}</td>
                            <td >${vehiculo.color}</td> 
                            <td >${vehiculo.tipoVehiculo.marca}</td>  
                            <td >${vehiculo.tipoVehiculo.modelo}</td>  
                            <td >${vehiculo.tipoVehiculo.precio}</td>
                            <td><img width="150" height="100" src="images/${vehiculo.tipoVehiculo.id}"></td>  
                            <td><input type="text" name="action2" value="${vehiculo.placa}" placeholder="Placa"/></td>
                            <td><input type="submit" name="action" value="Vender" /></td>
                        </tr>                      
                    </c:forEach>    
                </table>
            </form>
        </div>
    </body>
</html>
