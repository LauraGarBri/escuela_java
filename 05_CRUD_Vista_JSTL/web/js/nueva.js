$(document).ready(function () {
    $('#btnSend').click(function () {

        let email = $('#email').val();
        let password = $('#password').val();
        let name = $('#name').val();
        let age = $('#age').val();

        let usuario = {
            "email": email,
            "password": password,
            "name": name,
            "age": age
        };

        var miUsuario = JSON.stringify(usuario);
       // alert(miUsuario);
        $.post(
            "api/users",
             {"json":miUsuario},function (respuestaUserObj){
                 $("#id").val(respuestaUserObj.id);
             }
        );
    });

});


