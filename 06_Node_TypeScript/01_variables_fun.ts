// 'usestrict';
// Ultimo código JS

var hola = "Hola";
console.log("Guay " + hola);
function otroHola(saludo) {
	console.log("saludo " + saludo);
}
otroHola(" adios JS!");

// Type Script:
let variableNum: number;
// console.log(variableNoDeclarada);
variableNum = 100;
// variableNum = "texto"; MAL en tipos
console.log(variableNum);

let miUnion: number | string | boolean;
// miUnion = new Object();
miUnion = true;
miUnion = "....";

interface Tiempo {
	dia: number;
	mes: number;
	anio: number;
};
let miCumple: Tiempo = {dia: 7, mes: 10, anio: 1982};
console.log("Cumple el " + miCumple.dia + " del " + miCumple.mes);

// any: tipo que dice que puede ser de cualquier tipo, un buen tipo

function concatenar(texto1: string, texto2: any) {
	console.log("Concatenado: " + texto1 + texto2);
}

concatenar("Total, ", "que recibe una cosa");
concatenar("u otra, ", miCumple);



