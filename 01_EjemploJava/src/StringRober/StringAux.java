package classjava;

import threads.IQuitarEspacio;

public class StringAux implements IQuitarEspacio {

    public StringAux() {
    }
    
    public String quitarEspacios(String texto) {
        // Recorrer caracter a caracter quitando los sobrantes
        String result = "";
        texto = texto.trim();
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) != ' ') {
                result += texto.charAt(i);
            } else if (i < texto.length() - 1){    // Si es ESP
                if (texto.charAt(i + 1) != ' ') 
                    result += ' ';
            }
        }
        return result;
    }
    
    public static String quitarEspSobrantes(String texto) {
        return texto.trim().replaceAll("\\s+", " ");
    }
    public static int contarPalabrasV1(String texto) {
        texto = texto.trim();
        if (texto.isEmpty())
            return 0;
        else
            return quitarEspSobrantes(texto).split(" ").length;
    }
    public static int contarPalabrasV2(String texto) {
        int contador = 1;
        texto = quitarEspSobrantes(texto);
        texto = texto.trim();
        if (texto.isEmpty()) {
            return 0;
        } else {
            for (int i = 0; i < texto.length(); i++) {
                if (texto.charAt(i) == ' ' ) 
                    contador++;
            }
        }
        return contador;
    }
    public static int contarPalabras(String texto) {
        int contador = 1;
        
        texto = texto.trim();
        if (texto.isEmpty()) {
            return 0;
        } else {
            for (int i = 0; i < texto.length() - 1; i++) {
                if (texto.charAt(i) == ' ' && texto.charAt(i + 1) != ' ') 
                    contador++;
            }
        }
        return contador;
    }
}
