package practica_hilos;

import ConvertirStringAux.*;
import practica_hilos.IQuitarEspacios;

/**
 * @author Laura Garcia
 */
public class StringAuxV2 implements IQuitarEspacios{

    @Override
    public String quitarEspaciosSobrantes(String texto) {
        String result = "";
        texto = texto.trim();
        String [] palabras = texto.split(" ");
        
        for(String palabra : palabras){
            if(!palabra.isEmpty()){
                result += palabra + " ";
            }        
        }
        
        return result.trim();
    }

}
