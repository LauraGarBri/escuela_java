<%-- 
    Document   : register
    Created on : 01-oct-2019, 16:02:07
    Author     : Formacion
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register (Create)</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>      
        <div class="container well" >
            <h1>Register (Create)</h1>
            <form name="form1" action="users.do" method="post">
                <div class="form-group">
                    <label for="email">Email: </label>
                    <input type="email"class="form-control"  id="email" name="email" placeholder="Write your email" 
                           size="50" maxlength="255" required="required" />
                </div>
                <div class="form-group">
                    <label for="password">Password: </label>
                    <input type="password"class="form-control"  id="password" name="password" placeholder="Write your password" 
                           size="50" maxlength="50" required="required" />
                </div>
                <div class="form-group">
                    <label for="name">Name: </label>
                    <input type="text"class="form-control"  id="name" name="name" placeholder="Write your name" 
                           size="50" maxlength="50" required="required" />
                </div>
                <div class="form-group">
                    <label for="age">Age: </label>
                    <input type="number"class="form-control"  id="age" name="age" placeholder="Write your age" 
                           size="10" maxlength="3" required="required" min="1" max="199" />
                </div>
                <input type='submit' value='Register' class="btn btn-primary"/>
            </form>


        </div>
        <script src="js/md5.min.js"></script>
        <script src="js/encrypt_register.js"></script>
    </body>
</html>
