<%-- 
    Document   : estilos
    Created on : 26-sep-2019, 9:33:12
    Author     : Formacion
--%>

<%@page contentType="text/css" pageEncoding="UTF-8"%>

<% for (int i = 0; i < 10; i++) { %>
.tipo-letra-<%="tam-" + i %>{
    font-size: <%=10 + i  * 2 %>px;
    background-color: #4444<%=9 + i * 10 %>
   
}

<% }%>

.color-letra{
    color: white;
    font-family: fantasy;
}

body{
    background-image:  url("http://ist1-4.filesor.com/pimpandhost.com/8/2/8/3/82837/1/e/A/j/1eAjz/wallpaper-1174235.jpg");
}

.menu-princip{
    display: inline-block;
    border: 2px solid green;
    margin: 3px;
}