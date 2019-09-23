class Calculadora {
    constructor() {
        this.result = document.getElementById("resultado");
    }

    numeroPulsado(eventObj) {
        let valor = eventObj.currentTarget.innerHTML;

        if (valor === "+/-") {
            calculadora.result.value = "" + (-(parseFloat(calculadora.result.value)));
        } else if( valor === "."){
            if(!this.result.value.includes(".")){
                this.result.value += valor;
            }
        }else {
            this.result.value += valor;
        }
    }
};

let calculadora = null;

window.onload = function () {
    let botones = document.getElementsByClassName("num");//devuelve un array de botones
    calculadora = new Calculadora();
    for (let boton of botones) {
        boton.addEventListener("click",(evtObj) =>{
            calculadora.numeroPulsado(evtObj);
        }); //Funcion callback
    }
};
