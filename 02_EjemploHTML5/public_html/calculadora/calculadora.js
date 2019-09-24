class Calculadora {
    constructor() {
        //this.result = document.getElementById("resultado");
        //Lo mismo pero con jquery
        this.result = $("#resultado");//# --> buscar por id
        //this.anterior = document.getElementById("anterior");
        this.anterior = $("#anterior");
        this.mem = 0;
        this.operador = "";
        this.nuevoNum = false;

    }

    numeroPulsado(eventObj) {
        if (this.nuevoNum) {
            this.result.val("0");
            this.nuevoNum = false;
        }
        let valor = eventObj.currentTarget.innerHTML;

        if (valor === "+/-") {
            this.result.val("" + (-(parseFloat(calculadora.result.val()))));
        } else if (valor === ".") {
            if (!this.result.val().includes(".")) {
                this.result.val(this.result.val()+ valor);
            }
        } else {
            this.result.val(this.result.val() + valor);
            this.result.val(parseFloat(this.result.val()));
        }
    }
    operadorPulsado(evObj) {
        let operadorActual = evObj.currentTarget.innerHTML;

        if (this.operador !== "" || operadorActual === "=") {
            this.calcular();
        }
        this.mem = parseFloat(this.result.val());
        //subir a caja de texto el valor anterior y operador

        if (this.operador !== "=" && operadorActual !== "=") {
            this.anterior.val(`${this.mem} ${operadorActual}`);
            this.result.val("0");
            this.operador = operadorActual;
        } else {
            this.operador = "";
        }

        this.nuevoNum = true;
    }

    calcular() {
        if (this.operador !== "" && this.operador !== "=") {
            let valActual = parseFloat(this.result.val());
            let resultado = eval(this.mem.toString() + this.operador + valActual);
            this.result.val(resultado);
            
            $("#anterior").css("background-color","green");
        }
    }
};

let calculadora = null;

let inicializacion = function () {
    calculadora = new Calculadora();

    $(".num").click((evtObj) =>{
        calculadora.numeroPulsado(evtObj);
    });
    
    $(".oper").click((evtObj) =>{
        calculadora.operadorPulsado(evtObj);
    });

    //let botones = document.getElementsByClassName("num");//devuelve un array de botones
   /* for (let boton of botones) {
        boton.addEventListener("click", (evtObj) => {
            calculadora.numeroPulsado(evtObj);
        }); //Funcion callback
    }
    
   let botonesOp = document.getElementsByClassName("oper");
    for (let boton of botonesOp) {
        boton.onclick = (evtObj) => {
            calculadora.operadorPulsado(evtObj);
        }; //Funcion callback
    }*/
};

$(document).ready(inicializacion); //JQuery se sustituye por el dollar $()

