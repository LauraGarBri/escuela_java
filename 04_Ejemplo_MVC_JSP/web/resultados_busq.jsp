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

        <form name="formModif" method="post" action="./personas.do"> 

            <% Persona pers = (Persona) session.getAttribute("resultadoBusq");%>
            <% if (pers != null) {%>
            <label for="nombre">Nombre: </label>
            <input id="nombre" name="nombre" value="<%= pers.getNombre()%>"/>
            <label for="edad">Edad: </label>
            <input id="edad" name="edad" value="<%= pers.getEdad()%>"/>
            <label for="email">Email: </label>
            <input id="email" name="email" value="<%= pers.getEmail()%>"/>
            <label for="password">Password: </label>
            <input id="password" name="password" value="<%= pers.getPassword()%>"/>
            <%--<input type="hidden" id="metodo" name="metodo" value="modificar"/> --%>
            <input type="hidden" name="nombreAntiguo" value="<%= pers.getNombre()%>"/>
            <input type="hidden" name="edadAntiguo" value="<%= pers.getEdad()%>"/>
            <input type="hidden" name="emailAntiguo" value="<%= pers.getEmail()%>"/>          
            <input type="hidden" name="passwordAntiguo" value="<%= pers.getPassword()%>"/>
            <input type="submit" id="metodoMo" name="metodo" value="Modificar" />
            <input type="submit" id="metodoEl" name="metodo" value="Eliminar" />
            <% } else { %>
            <span style="color: red">
                No se han encontrado resultados
            </span>
            <% }%>

        </form>
    </body>
</html>
