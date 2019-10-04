window.onload = () => {
    document.getElementById("btnSend").onclick = function () {
        let email = document.getElementById("email").value;
        let password = document.getElementById("password").value;
        let name = document.getElementById("name").value;
        let age = document.getElementById("age").value;

        let objUser = {
            "email": email,
            password: password,
            "name": name,
            "age": age

        };
        let jsonTextUser = JSON.stringify(objUser);
        alert(jsonTextUser);

        let ajaxObj = new XMLHttpRequest();

        ajaxObj.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

        ajaxObj.open("POST", "api/users");
        
        
        
        ajaxObj.send({"json":jsonTextUser});
    };

};

