<%@include file="head.jsp" %>
<!DOCTYPE html>
<html>
    <%= head ("Registro") %>
    <body>
        <%@include file="header.jsp" %>
        <div>Registro</div>
        <form name='form1' method='post' action='./param.jsp'>
            <table border ='1'>
                <tr><td>Nombre:</td>
                    <td><input type='text' name='nombre' id='nombre' /></td></tr>
                <tr><td>Edad:</td>
                    <td><input type='number' name='edad' id='edad' /></td></tr>
                <tr><td>Email:</td>
                    <td><input type='email' name='email' id='email' /></td></tr>
                <tr><td>Password:</td>
                    <td><input type='password' name='password' id='password' /></td></tr>
            </table>
            <input type='submit' value='Enviar' />
        </form>
    </body>
</html>