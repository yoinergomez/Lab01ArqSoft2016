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

        <title>Tipo vehiculo</title>
    </head>
    <body>
        <div class="navbar">
            <div class="navbar-inner">
                <a href="#" class="brand">Venta de Vehiculos</a>
                <ul class="nav">
                    <li><a href="index.jsp">Inicio</a></li>
                    <li><a href="ClienteServlet">Clientes</a></li>
                    <li><a href="TipoVehiculoServlet">Tipo de vehiculos</a></li>
                    <li><a href="VehiculoServlet">Inventario vehiculos</a></li>
                    <li class="active"><a href="#">Lista de ventas</a></li>
                </ul>
            </div>
        </div>


        <div class="container well">
            <h1>Venta de vehiculos</h1>
            <form id="formVenta" action="./VentaServlet" method="POST">
                <div class="row-fluid">
                    <div class="span3">


                        <input type="text" name="itemSeleccionado" style="display:none">
                        <label>Placa:</label> 
                        <input type="text" name="placa" class="form-control" placeholder="Placa"/>
                        <br>
                        <input type="submit" name="action" value="Vender" class="btn btn-primary btn-block" />
                    </div>
                    <div class="span3">

                        <label>Cedula:</label> 
                        <input type="text" name="cedula" class="form-control" placeholder="Cedula cliente"/>
                        <h5>${message}</h5>
                    </div>


                </div>
            </form>
            <table class="table table-striped table-bordered table-hover table-condensed" id="table1">
                <tr>
                    <th>Fecha de venta</th>
                    <th>Cedula</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Placa</th>
                    <th>Marca</th>
                    <th>Modelo</th>
                    <th>Precio</th>
                    <th>Imagen</th>
                    <th></th>
                </tr>
                <c:forEach items="${getAllVentas}" var="venta">
                    <tr>
                        <td >${venta.fecha}</td>
                        <td >${venta.cliente.numeroDocumento}</td> 
                        <td >${venta.cliente.nombre}</td> 
                        <td >${venta.cliente.apellido}</td> 
                        <td >${venta.vehiculo.placa}</td>
                        <td >${venta.vehiculo.tipoVehiculo.marca}</td>
                        <td >${venta.vehiculo.tipoVehiculo.modelo}</td>
                        <td >${venta.vehiculo.tipoVehiculo.precio}</td>
                        <td><img width="150" height="100" src="images/${venta.vehiculo.tipoVehiculo.id}"></td>
                    </tr>                      
                </c:forEach>     
            </table>

        </div>
    </body>
</html>
