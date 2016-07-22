<%-- 
    Document   : vistaClamAV
    Created on : 05-mar-2016, 19:20:52
    Author     : root
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="css/tabla.css">
        <script src="js/jquery-2.2.1.min.js" ></script>
        <script src="js/ajaxcall.js" ></script>
    </head>
    <body>
        <div class="table-responsive">          
            <table class="table">
                <tbody>
                    <tr>
                        <td><strong>Nombre del Fichero</strong></td>
                        <td><strong>Leer</strong></td>
                    </tr>
                </tbody>
                <% ArrayList clamAvLogs = (ArrayList) request.getAttribute("clamAvLogs");
                for (int i = 0; i < clamAvLogs.size(); i++) {%>
                <tbody>
                    <tr>
                        <td><li><%=clamAvLogs.get(i)%></li></td>
                <td><button onclick="logRead('<%=clamAvLogs.get(i)%>')" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span></button></td>
                </tr>
                </tbody>
                <%}%>
            </table>
        </div>
    </body>
</html>
