$(document).ready(function () {
    $('#btnDelete').click(function () {
        let objUser ={
            "id": $('#id').val()
        };


        $.ajax({
            "url": "api/users",
            "type": "DELETE",
            "data": objUser,
            "contentType" :"application/x-www-form-urlencoded; charset=ISO-8859-1",
            "success":
                    function (respuestaText) {
                        alert(respuestaText);
                    }
                
                    
        });
    });

});




