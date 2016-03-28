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
                <li class="active"><a href="TipoVehiculoServlet">Tipo de vehiculos</a></li>
                <li><a href="VehiculoServlet">Inventario vehiculos</a></li>
                <li><a href="VentasServlet">Lista de ventas</a></li>
            </ul>
        </div>
    </div>

        <div class="container well">
            <h1>Tipos de </h1>
        <div class="row-fluid">
        <form action="./TipoVehiculoServlet" method="POST" enctype="multipart/form-data">
            <div class="span4">              
                    <h5>Codigo</h5>
                    <input type="text" name="idTipoVehiculo" placeholder="Codigo">
             
                    <h5 class="add-on">Marca</h5>
                    <input type="text" name="marca" class="form-control" placeholder="Marca"/>
              
                    <h5 class="add-on">Modelo</h5>
                    <input type="text" name="modelo" class="form-control" placeholder="Modelo"/>                   
            </div>
            <div class="span4">
                <h5 class="add-on">Precio</h5>
                    <input type="text" name="precio" class="form-control" placeholder="Precio"/>
             
                    <h5 class="add-on">Cantidad</h5>
                    <input type="text" name="cantidad" class="form-control" placeholder="Cantidad"/>
  
                    <h5 class="add-on">Imagen</h5>
                    <input type="file" name="imagen" class="btn btn-primary">
            </div>
            <div class="span4">
                <br>
                <br>
                <input type="submit" name="action" value="Add" class="btn btn-primary btn-block" />
                <br>
                <input type="submit" name="action" value="Edit" class="btn btn-primary btn-block" />
                <br>
                <input type="submit" name="action" value="Delete" class="btn btn-primary btn-block" />
            </div>

            </form>
            </div>
            <br>            
                <table class="table table-striped table-bordered table-hover table-condensed">
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
