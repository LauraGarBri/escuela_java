package clasesjava;

import java.util.StringTokenizer;

/**
 * @author Laura Garcia
 */
public class ProbandoString {

    public static void tratarCadenas(){
        
        String cadena = "En un lugar de la Mancha de cuyo nombre no quiero acordarme, vivia...";
        System.out.println(cadena);
        System.out.println("Cuarta letra: " + cadena.charAt(3));
        //Comparaciones
        String cadena2 = "En un lugar de Madrid...";
        System.out.println("Comparacion: "+ cadena.compareTo(cadena2));
        
        cadena2 = cadena2.substring(0,10);
        if(cadena.contains(cadena2)){
            System.out.println("cadena contiene cadena2");
        }else{
            System.out.println("cadena NO contiene cadena2");
        }
        
        System.out.println("\"Mancha\" está en la posicion " + cadena.indexOf("Mancha"));
        cadena = cadena.replace("lugar", "bar");
        System.out.println(cadena);
        String cadena3 = "            en    UN LUgar";
        cadena3= cadena3.toUpperCase().trim();
        System.out.println(cadena3);
        
        //Quitar todos los espacios del interior de la cadena3 
        //cadena3 = cadena3.replace(" ", "");
        //System.out.println(cadena3);
        
        
        //Quitar espacios que sobren del interior de la cadena3
         cadena3 = cadena3.replaceAll(" +", " ");
         System.out.println("La cadena sin espacios demás: " + cadena3);

        //Metodo para saber el numero de palabras
        int contador = 0;
        String text = "Esto es una prueba";
        String[] palabras = text.split(" ");
        for (String palabra : palabras){
            System.out.println(palabra);
            contador++;           
        }
        System.out.println("El número de palabras es: " + contador);
                        
    }
}
