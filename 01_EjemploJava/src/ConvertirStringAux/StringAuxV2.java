package ConvertirStringAux;

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
