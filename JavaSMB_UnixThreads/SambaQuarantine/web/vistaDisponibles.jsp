<%-- 
    Document   : vista
    Created on : 24-feb-2016, 22:12:46
    Author     : Asir
--%>
<%@page import="FileManager.FileData"%>
<%if (session.getAttribute("session") == null) response.sendRedirect("/SambaQuarantine");%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vista Cuarentena</title>
        <link rel="stylesheet" type="text/css" href="css/reset.css">
        <link rel="stylesheet" type="text/css" href="css/tabla.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/structure.css">
        <script src="js/jquery-2.2.1.min.js" ></script>
        <script src="js/ajaxcall.js" ></script>
    </head>
    <body>
        <div class="table-responsive">          
            <table class="table">
                <tbody>
                    <tr>
                        <td><strong>Nombre del Fichero</strong></td>
                        <td><strong>Descargar</strong></td>
                        <td><strong>Tamaño</strong></td>
                    </tr>
                </tbody>
                <% FileData ficherosData = (FileData) request.getAttribute("ficherosDisponibles");
                for (int i = 0; i < ficherosData.ficheros.size(); i++) {%>
                <tbody>
                    <tr>
                        <td><li><%=ficherosData.ficheros.get(i)%></li></td>
                <td><button class="btn btn-primary" onclick="download('<%=ficherosData.smbPath.get(i)%>')"><span class="glyphicon glyphicon-download" aria-hidden="true"></span></button></td>
                <td><li><%=ficherosData.sizes.get(i)%> KB</li></td>
                </tr>
                </tbody>
                <%}%>
            </table>
        </div>
    </body>
</html>
