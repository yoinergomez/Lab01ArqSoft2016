<%-- 
    Document   : index
    Created on : 22/03/2016, 12:29:56 PM
    Author     : esteban
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <!-- Optional theme -->
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <title>Concesionario</title>
    </head>
    <body>
    	<div class="navbar">
	        <div class="navbar-inner">
	            <a href="#" class="brand">Venta de Vehiculos</a>
	            <ul class="nav">
	                <li class="active"><a href="#">Inicio</a></li>
	                <li><a href="ClienteServlet">Clientes</a></li>
	                <li><a href="TipoVehiculoServlet">Tipo de vehiculos</a></li>
	                <li><a href="VehiculoServlet">Inventario vehiculos</a></li>
	                <li><a href="VentasServlet">Lista de ventas</a></li>
	            </ul>
	        </div>
	    </div>
		<div class="container">
			<div class="row-fluid">
				<div class="span6">
					<div class="well well-small">	
					    <h1>Laboratorio #1</h1>
					    <p>Arquitectura de Software</p>
					    <p>Diego Jose Luis Botia</p>
					    <p>Realizar una aplicación CRUD completa que permita manejar la información de un concesionario de vehículos. Deberá soportar la información de Clientes, Vehículos, y Ventas generales. Además deberá permitir subir las fotos de los vehículos y visualizarlos según se busque la
						información de cada uno por medio de la introducción de la matrícula.</p>
					    <br>
					</div>
				</div>
				<div class="span6">
					<div class="well well-small">
					    <h2>Realizado por:</h2>
					    <p>
					    Jhonatan Alexander Orozco<br>
					    Yoiner Esteban Gomez<br>
                                            Maria Camila Gómez<br>
					    Frank Alexis Castrillo<br>
					    Santiago Romero<br>
					    </p>
					</div> 
				</div>
			</div>

		</div>
        
    </body>
</html>
