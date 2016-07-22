<%-- 
    Document   : ownerLog
    Created on : 28-feb-2016, 16:40:41
    Author     : Asir
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Log de Eventos</title>
    </head>
    <body>
        <div class="table-responsive">          
            <table class="table">
                <tbody>
                    <tr>
                        <td><strong>Propietario</strong></td>
                        <td><strong>Ficheros</strong></td>
                    </tr>
                </tbody>
                <% ArrayList ownerfiles = (ArrayList) request.getAttribute("ownerfiles");
                   ArrayList owners = (ArrayList) request.getAttribute("owners");
                for (int i = 0; i < owners.size(); i++) {%>
                <tbody>
                    <tr>
                        <td><li><%=owners.get(i)%></li></td>
                        <td><li><%=ownerfiles.get(i)%></li></td>
                    </tr>
                </tbody>
                <%}%>
            </table>
        </div>
    </body>
</html>