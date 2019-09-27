<!DOCTYPE html>

<html>
    <head>
        <title>Ejemplo MVC con JSP y Servlets</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container well" >
            <div class="row">
                <div class="col-lg-6">
                    <h1>Añadir Persona</h1>
                    <form name='form1' method='post' action='./personas.do'>
                        <div class="form-group">
                            <label for="infoNombre">Nombre</label>
                            <input type='text' class="form-control" placeholder="Nombre" name='nombre' id='nombre' />
                        </div>
                        <div class="form-group">
                            <label for="infoEdad">Edad</label>
                            <input type='text' class="form-control" placeholder="Edad" name='edad' id='edad' />
                        </div>
                        <div class="form-group">
                            <label for="infoPassword">Password</label>
                            <input type="password" class="form-control" id="password" placeholder="Password" name="password">
                        </div>
                        <div class="form-group">
                            <label for="infoEmail">E-mail</label>
                            <input type='text' class="form-control" placeholder="E-mail" name='email' id='email' />
                        </div>
                        <input type='submit' value='Añadir' class="btn btn-primary"/>
                    </form>
                </div>
                <div class="col-lg-6">
                    <h1>Buscar Persona</h1>
                    <form name='formBusq' method='get' action='./personas.do'>
                        <div class="form-group">
                            <label for="infoNombre">Nombre</label>
                            <input type='text' class="form-control" placeholder="Nombre" name='nombre' id='nombre' />
                        </div>
                        <input type='submit' value='Buscar' class="btn btn-primary"/>
                    </form>
                </div>
            </div>
        </div>   
    </body>
</html>
