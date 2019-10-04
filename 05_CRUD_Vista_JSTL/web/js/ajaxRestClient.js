window.onload = function(){
    let data_table = document.getElementById("data_table");
    //Que va en casi todos los navegadores excepto IE
    let ajaxObj = new XMLHttpRequest();

    //Evento de cambio de estado
    ajaxObj.onreadystatechange = function () {
        //alert("Cambio de estado: " + this.readyState + ", status: " + this.status);
        if (this.readyState === 4 && this.status === 200) {
            let jsonResp = this.responseText;
            //Convertir texto json en obj JS
            let objRespListUser = JSON.parse(jsonResp);
            data_table.innerHTML = "";
            for (let user of objRespListUser) {
                data_table.innerHTML +=
                        `<tr>
                            <td>${user.email}</td>
                            <td>${user.name}</td>
                        </tr>`;
            }
        }
    };
    
    ajaxObj.setRequestHeader()
    
    
    ajaxObj.open("GET", "api/users");
    ajaxObj.send();
};