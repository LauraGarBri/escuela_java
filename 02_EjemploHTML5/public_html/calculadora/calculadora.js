class Calculadora {
    constructor() {
        this.result = document.getElementById("resultado");
        this.anterior = document.getElementById("anterior");
        this.mem = 0;
        this.operador = "";
        this.nuevoNum = false;

    }

    numeroPulsado(eventObj) {
        if (this.nuevoNum) {
            this.result.value = "0";
            this.nuevoNum = false;
        }
        let valor = eventObj.currentTarget.innerHTML;

        if (valor === "+/-") {
            calculadora.result.value = "" + (-(parseFloat(calculadora.result.value)));
        } else if (valor === ".") {
            if (!this.result.value.includes(".")) {
                this.result.value += valor;
            }
        } else {
            this.result.value += valor;
            this.result.value = parseFloat(this.result.value);
        }
    }
    operadorPulsado(evObj) {
        let operadorActual = evObj.currentTarget.innerHTML;

        if (this.operador !== "" || operadorActual === "=") {
            this.calcular();
        }
        this.mem = parseFloat(this.result.value);
        //subir a caja de texto el valor anterior y operador

        if (this.operador !== "=" && operadorActual !== "=") {
            this.anterior.value = `${this.mem} ${operadorActual}`;
            this.result.value = "0";
            this.operador = operadorActual;
        } else {
            this.operador = "";
        }

        this.nuevoNum = true;
    }

    calcular() {
        if (this.operador !== "" && this.operador !== "=") {
            let valActual = parseFloat(this.result.value);
            let resultado = eval(this.mem.toString() + this.operador + valActual);
            this.result.value = resultado;
        }
    }

};

let calculadora = null;

let inicializacion = function () {
    calculadora = new Calculadora();

    let botones = document.getElementsByClassName("num");//devuelve un array de botones
    let botonesOp = document.getElementsByClassName("oper");

    for (let boton of botones) {
        boton.addEventListener("click", (evtObj) => {
            calculadora.numeroPulsado(evtObj);
        }); //Funcion callback
    }

    for (let boton of botonesOp) {
        boton.onclick = (evObj) => {
            calculadora.operadorPulsado(evObj);
        }; //Funcion callback
    }
};

jQuery(document).ready(inicializacion);

