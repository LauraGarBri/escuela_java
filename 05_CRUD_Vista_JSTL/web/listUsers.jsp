<%-- 
    Document   : listUsers
    Created on : 01-oct-2019, 16:50:40
    Author     : Formacion
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="sinensia.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:useBean  id="usersList" type="java.util.ArrayList<User>" scope="request">
    <jsp:getProperty property="*" name="usersList"></jsp:getProperty>
</jsp:useBean>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users List</title>
    </head>
    <body>
        <h1>Users List</h1>
        <table>
            <%-- ${} corresponde a EL (Expression Language) de JSTL--%>
            <c:forEach items="${usersList}" var="user">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.email}</td>
                    <td>${user.password}</td>
                    <td>${user.name}</td>
                    <td>${user.age}</td>
                </tr>
            </c:forEach> 
        </table>
    </body>
</html>
