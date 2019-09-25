package classjava;

public class ProbandoString {
    public static void tratarCadenas() {
        String texto = "En un lugar de la Mancha de cuyo nombre no quiero acordarme, vivia...";
        System.out.println(texto);
        System.out.println("Cuarta letra: " + texto.charAt(3));
        
        String texto2 = "En un lugar de Madrid...";
        System.out.println("Comparación: " + texto.compareTo(texto2));
        
        texto2 = texto2.substring(0, 10);
        System.out.println("Texto 2 ahora es: " + texto2);
        if (texto.contains(texto2)) {
            System.out.println("Texto contiene texto2.");
        } else {
            System.out.println("Texto no contiene texto2.");
        }
        
        System.out.println("\"Mancha\" está en la posición: " + texto.indexOf("Mancha"));
        
        texto = texto.replace("lugar", "bar");
        System.out.println(texto);
        
        String texto3 = "     en    un      LUGAR  ";
        texto3 = texto3.toUpperCase().trim();
        
        
        
        System.out.println("Palabras: " + StringAux.contarPalabras(texto3));
        System.out.println("Espacios: " + new StringAux().quitarEspacios(texto3));
        
        
        
        System.out.println("Palabras: " + texto3.split("\\s+").length);
        System.out.println(texto3);
        
    }
    
}
