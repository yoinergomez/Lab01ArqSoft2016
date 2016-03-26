<%-- 
    Document   : cliente
    Created on : 24-mar-2016, 15:46:17
    Author     : Frank Alexis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <title>Cliente</title>
    </head>
    <body>
        <ul class="nav nav-tabs">
            <li><a href="index.jsp">Inicio</a></li>
            <li><a href="ClienteServlet">Clientes</a></li>
            <li><a href="TipoVehiculoServlet">Tipo de vehiculos</a></li>
            <li><a href="VehiculoServlet">Inventario vehiculos</a></li>
            <li><a href="VentasServlet">Lista de ventas</a></li>
        </ul>
        <form action="./ClienteServlet" method="POST">
            <br>
            <table>
                <tr>
                    <th>Documento</th>
                    <th><input type="text" name="documento" class="form-control"  value="${cliente.documento}"/></th>
                </tr>
                <tr>
                    <th>Nombre</th>
                    <th><input type="text" name="nombre" class="form-control"  value="${cliente.nombre}"/></th>
                </tr>
                <tr>
                    <th>Apellido</th>
                    <th><input type="text" name="apellido" class="form-control"  value="${cliente.apellido}"/></th>
                </tr>
                <tr>
                    <th>Direccion</th>
                    <th><input type="text" name="direccion" class="form-control"  value="${cliente.direccion}"/></th>
                </tr>
                <tr>
                    <th>Telefono</th>
                    <th><input type="text" name="telefono" class="form-control"  value="${cliente.telefono}"/></th>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Agregar" style="border: 1px solid black; padding:5px"/>
                        <input type="submit" name="action" value="Editar" style="border: 1px solid black; padding:5px"/>
                        <input type="submit" name="action" value="Eliminar" style="border: 1px solid black; padding:5px"/>
                        <input type="submit" name="action" value="Buscar" style="border: 1px solid black; padding:5px"/>
                    </td>
                </tr>
            </table> 
        </form>
        <div class="container-well">
            <br>
            <table class="table table-stripped">
                <th></th>
                <th>Documento</th>
                <th>nombre</th>
                <th>apellido</th>
                <th>direccion</th>
                <th>telefono</th>
                
                    <c:forEach items="${clientes}" var="clientes">
                        <tr>
                            <td >${clientes.documento}</td>
                            <td >${clientes.nombre}</td>
                            <td >${clientes.apellido}</td>
                            <td >${clientes.direccion}</td>
                            <td >${clientes.telefono}</td>   
                        </tr>                      
                    </c:forEach>
            </table>
        </div>
    </body>
</html>
