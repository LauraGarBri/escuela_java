

$.post({"url": "api/users",
                "contentType": "JSON",
                "data": miUsuario,
                "success":
                     function (respuestaUserObj){
                        $("#id").val(respuestaUserObj.id);
                    }
                });