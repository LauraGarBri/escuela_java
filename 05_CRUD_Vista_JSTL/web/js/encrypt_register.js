window.onload = function () {
    function encrypt(valor) {
        md5(valor);
        let hash = md5.create();
        hash.update(valor);
        return hash.hex();
    }
    let beforeSend = function (event) {
        event.preventDefault();
        let password = document.getElementById("password");
        if (password.value.length > 2) {
            let passwdEncrypt = encrypt(password.value);
            let inputHiddenPsswd = document.createElement("input");
            inputHiddenPsswd.setAttribute("type", "hidden");
            inputHiddenPsswd.setAttribute("name", "password_encript");
            inputHiddenPsswd.setAttribute("value", passwdEncrypt);
            document.forms.form1.appendChild(inputHiddenPsswd);
            
            document.forms.form1.submit();
        } else {
            alert("Password too short.");
        }
    }
    // Pasamos la función como parámetro en la Callback
    document.forms.form1.addEventListener("submit", beforeSend);
};