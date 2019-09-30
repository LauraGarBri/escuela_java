<%-- --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exito - Registro guardado</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <div class="container well" >
            <h1>Existo - Registro guardado</h1>
            <div class="form-group">
                <label for="nombre">Nombre: </label>
                <input  class="form-control" name='nombre' readonly="readonly" id='nombre' value="<%= request.getParameter("nombre")%>" />
            </div>
            <div class="form-group">
                <label for="edad">Edad</label>
                <input id="edad" class="form-control" readonly="readonly" value="<%= request.getParameter("edad")%>"/>
            </div>
            <div class="form-group">
                <label for="infoPassword">Password</label>
                <input id="password"  class="form-control" readonly="readonly" value="<%= request.getParameter("password")%>"/>              
            </div>
            <div class="form-group">
                <label for="infoEmail">E-mail</label>
                <input id="email" class="form-control" readonly="readonly" value="<%= request.getParameter("email")%>"/>
            </div>          
            <a href="./index.jsp" class="btn btn-info" role="button">Inicio</a>
        </div>
    </body>
</html>
