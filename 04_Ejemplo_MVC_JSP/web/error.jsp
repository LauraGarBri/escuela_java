<%-- 
    Document   : error
    Created on : 26-sep-2019, 13:45:10
    Author     : Formacion
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error en registro</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Error en registro</h1>
        Error: 
        <span style="color: red">
            <%= session.getAttribute("mensajeError") %>
                    
        </span>
    </body>
</html>
