<%-- --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exito - Registro guardado</title>
    </head>
    <body>
        <h1>Existo - Registro guardado</h1>
        <label for="nombre">Nombre: </label>
        <input id="nombre" readonly="readonly" value="<%= request.getParameter("nombre")%>"/>
        <label for="edad">Edad: </label>
        <input id="edad" readonly="readonly" value="<%= request.getParameter("edad")%>"/>
        <label for="email">E-mail </label>
        <input id="email" readonly="readonly" value="<%= request.getParameter("email")%>"/>
        <label for="password">Password: </label>
        <input id="password" readonly="readonly" value="<%= request.getParameter("password")%>"/>
        
    </body>
</html>
