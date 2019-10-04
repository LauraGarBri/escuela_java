// 'usestrict';
// Ultimo código JS
var hola = "Hola";
console.log("Guay " + hola);
function otroHola(saludo) {
    console.log("saludo " + saludo);
}
otroHola(" adios JS!");
// Type Script:
var variableNum;
// console.log(variableNoDeclarada);
variableNum = 100;
// variableNum = "texto"; MAL en tipos
console.log(variableNum);
var miUnion;
// miUnion = new Object();
miUnion = true;
miUnion = "....";
;
var miCumple = { dia: 7, mes: 10, anio: 1982 };
console.log("Cumple el " + miCumple.dia + " del " + miCumple.mes);
// any: tipo que dice que puede ser de cualquier tipo, un buen tipo
function concatenar(texto1, texto2) {
    console.log("Concatenado: " + texto1 + texto2);
}
concatenar("Total, ", "que recibe una cosa");
concatenar("u otra, ", miCumple);
