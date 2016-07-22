<%-- 
    Document   : loged
    Created on : 27-feb-2016, 20:08:04
    Author     : Asir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%if (session.getAttribute("session") == null) response.sendRedirect("/SambaQuarantine");%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Panel de Admin</title>
        <link rel="stylesheet" type="text/css" href="css/reset.css">
        <link rel="stylesheet" type="text/css" href="css/structure.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/tabla.css">
        <script src="js/jquery-2.2.1.min.js" ></script>
        <script src="js/ajaxcall.js" ></script>
    </head>
    <body>
        <h1>Panel de Administracion</h1>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <ul class="nav navbar-nav">
                    <li><button id="inicio" class="btn btn-default">Inicio</button></li>
                    <li><button class="btn btn-default" id="cuarentena">Cuarentena</button></li>
                    <li><button class="btn btn-default" id="disponibles">Disponibles</button></li>
                    <li><button class="btn btn-info" id="ownerLog">Log Propietario</button></li>
                    <li><button class="btn btn-info" id="eventLog">Log Sucesos</button></li>
                    <li><button class="btn btn-info" id="antivirusLog">Log Antivirus</button></li>
                    <li><button class="btn btn-danger derecha" id="logout"><span class="glyphicon glyphicon-bed"></span> Cerrar Sesion </button></li> 
                </ul>
            </div>
        </nav>
            <div id="contenido"></div>
            <div id="samba"><img src="samba.jpg" alt="Samba" height="400" width="320"></div>
    </body>
</html>
