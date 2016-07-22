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
                        <td><strong>Mensaje del LOG</strong></td>
                    </tr>
                </tbody>
                <% ArrayList ficherosData = (ArrayList) request.getAttribute("resultados");
                for (int i = 0; i < ficherosData.size(); i++) {%>
                <tbody>
                    <tr>
                        <td><li><%=ficherosData.get(i)%></li></td>
                    </tr>
                </tbody>
                <%}%>
            </table>
        </div>
    </body>
</html>