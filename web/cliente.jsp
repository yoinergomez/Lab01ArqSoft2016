<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <title>Cliente</title>
    </head>
    <body>
        <div class="navbar">
            <div class="navbar-inner">
                <a href="#" class="brand">Venta de Vehiculos</a>
                <ul class="nav">
                    <li><a href="index.jsp">Inicio</a></li>
                    <li class="active"><a href="#">Clientes</a></li>
                    <li><a href="TipoVehiculoServlet">Tipo de vehiculos</a></li>
                    <li><a href="VehiculoServlet">Inventario vehiculos</a></li>
                    <li><a href="VentaServlet">Lista de ventas</a></li>
                </ul>
            </div>
        </div>
        <div class="container well">
            <h1>Clientes</h1>
            <table class="table table-stripped">
                <th>Documento</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Direccion</th>
                <th>Telefono</th>  
                    <c:forEach items="${cliente}" var="cliente">
                    <tr>
                        <td >${cliente.numeroDocumento}</td>
                        <td >${cliente.nombre}</td>
                        <td >${cliente.apellido}</td>
                        <td >${cliente.direccion}</td>
                        <td >${cliente.telefono}</td> 
                    </tr>                      
                </c:forEach>
            </table>
        </div>
        <div class="container well">
            <form action="./ClienteServlet" method="POST">
                <div class="row-fluid">
                    <div class="span4">
                        <h5>Documento</h5>
                        <input type="text" name="documento" class="form-control" placeholder="documento" required />

                        <h5>Nombre</h5>
                        <input type="text" name="nombre" class="form-control" placeholder="nombre" required />

                        <h5>Apellido</h5>
                        <input type="text" name="apellido" class="form-control" placeholder="apellido" />
                    </div>
                    <div class="span4">
                        <h5>Direccion</h5>
                        <input type="text" name="direccion" class="form-control" placeholder="direccion" />

                        <h5>Telefono</h5>
                        <input type="text" name="telefono" class="form-control" placeholder="telefono" />
                    </div>
                    <div class="span4">
                        <br>
                        <input type="submit" name="action" value="Agregar" class="btn btn-block btn-primary"/>
                        <br>
                        <input type="submit" name="action" value="Editar" class="btn btn-block btn-primary"/>
                        <br>
                        <input type="submit" name="action" value="Eliminar" class="btn btn-block btn-primary"/>
                        <br>
                        <input type="submit" name="action" value="Buscar" class="btn btn-block btn-primary"/>
                    </div>
                </div>
            </form>  
           
        </div>
    </body>
</html>
