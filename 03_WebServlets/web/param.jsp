<%-- 
    Estos comentarios no se envian al cliente 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Datos Introducidos</title>
        <link rel="stylesheet" href="./estilos/estilos.jsp">
    </head>
    <body>
        <%@include file="header.jsp" %>
        <h1 class="color-letra">Datos</h1>
        <p>Te llamas <% out.println(request.getParameter("nombre")); %> </p>
        <p>Tienes <% out.println(request.getParameter("edad")); %></p>
        <p>Email <% out.println(request.getParameter("email")); %></p>
        <p>Pass <% out.println(request.getParameter("password")); %></p>
        <ul>
            <% for(int i = 0; i< 10; i++) { %>
            
                <li class="tipo-letra-tam-<%= i %>">Numero <%out.println("" +i ); %> </li>
                
            <% }%>
        </ul>

    </body>
</html>
