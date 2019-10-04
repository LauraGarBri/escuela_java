$(document).ready(function () {
    $('#btnUpdate').click(function () {
        let id = $('#id').val();
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
        $.ajax({
            "url": "api/users",
            "contentType": "JSON",
            "data": miUsuario,
            "type": "PUT",
            "success":
                    function (respuestaUserObj) {
                        $("#id").val(respuestaUserObj.id);
                    }
        });
    });

});







$.post({
    "url": "api/users",
    "contentType": "JSON",
    "data": miUsuario,
    "success":
            function (respuestaUserObj) {
                $("#id").val(respuestaUserObj.id);
            }
});


