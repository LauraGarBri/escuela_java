<%-- 
    Document   : resultados_busq
    Created on : 26-sep-2019, 15:58:48
    Author     : Formacion
--%>

<%@page import="com.sinensia.modelo.Persona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultados Busqueda</title>
    </head>
    <body>
        <h1>Resultados busqueda</h1>
        <h2>Usuario</h2>
        <% Persona pers =(Persona)session.getAttribute("resultadoBusq");%>
        <% if(pers != null){ %>
            <label for="nombre">Nombre: </label>
            <input id="nombre" readonly="readonly" value="<%= pers.getNombre() %>"/>
            <label for="edad">Edad: </label>
            <input id="edad" readonly="readonly" value="<%= pers.getEdad() %>"/>
            <label for="email">Email: </label>
            <input id="email" readonly="readonly" value="<%= pers.getEmail() %>"/>
            <label for="password">Password: </label>
            <input id="password" readonly="readonly" value="<%= pers.getPassword()%>"/>
        <% }else{ %>
            <span style="color: red">
                No se han encontrado resultados
            </span>
        <% } %>
    </body>
</html>
