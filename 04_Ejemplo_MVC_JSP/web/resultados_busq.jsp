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
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
        <title>Resultados Busqueda</title>
    </head>
    <body>

        <div class="container well" >
            <h1>Resultados de la búsqueda</h1>
            <form name="formModif" method="post" action="./personas.do">
                <% Persona pers = (Persona) session.getAttribute("resultadoBusq");%>
                <% if (pers != null) {%>
                <div class="form-group">
                    <label for="infoNombre">Nombre</label>
                    <input type='text' class="form-control" name='nombre' id='nombre' value="<%= pers.getNombre()%>" />
                </div>
                <div class="form-group">
                    <label for="infoEdad">Edad</label>
                    <input type='text' class="form-control"  name='edad' id='edad' value="<%= pers.getEdad()%>" />
                </div>
                <div class="form-group">
                    <label for="infoPassword">Password</label>
                    <input type="password" class="form-control" id="password" name="password" value="<%= pers.getPassword()%>">
                </div>
                <div class="form-group">
                    <label for="infoEmail">E-mail</label>
                    <input type='text' class="form-control"  name='email' id='email' value="<%= pers.getEmail()%>" />
                </div>
                <input type="hidden" name="nombreAntiguo" value="<%= pers.getNombre()%>"/>
                <input type="hidden" name="edadAntiguo" value="<%= pers.getEdad()%>"/>
                <input type="hidden" name="emailAntiguo" value="<%= pers.getEmail()%>"/>          
                <input type="hidden" name="passwordAntiguo" value="<%= pers.getPassword()%>"/>

                <input type="submit" id="metodoMo" name="metodo" value="Modificar" class="btn btn-primary"/>
                <input type="submit" id="metodoEl" name="metodo" value="Eliminar" class="btn btn-primary"/>
                <% } else { %>
                <span style="color: red">
                    No se han encontrado resultados
                </span>
                <% }%>
            </form>
        </div>
    </body>
</html>
